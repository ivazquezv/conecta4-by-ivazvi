package com.mycompany.conecta4byivazquezv.controller;

import com.mycompany.conecta4byivazquezv.model.Board;
import com.mycompany.conecta4byivazquezv.model.Player;
import com.mycompany.conecta4byivazquezv.model.GameResult;
import com.mycompany.conecta4byivazquezv.model.Move;
import com.mycompany.conecta4byivazquezv.model.MatchResult;
import com.mycompany.conecta4byivazquezv.model.Ranking;
import com.mycompany.conecta4byivazquezv.rules.RuleEngine;
import com.mycompany.conecta4byivazquezv.view.TerminalView;

/**
 * Controlador principal del juego Conecta4.
 * Gestiona el flujo de la partida: turnos, validación de movimientos,
 * comprobación de reglas y comunicación con la vista.
 *
 * Soporta tanto jugadores humanos como jugadores IA.
 */
public final class GameController {

    private static final int UNDO_CODE = -2;
    private static final int REDO_CODE = -3;

    private final Board board = new Board();
    private final RuleEngine rules = new RuleEngine();
    private final TerminalView view = new TerminalView();
    private final CommandHistory history = new CommandHistory();
    private final Ranking ranking = new Ranking();

    private Player current;
    private Player p1;
    private Player p2;

    public void start(Player p1, Player p2) {
        this.p1 = p1;
        this.p2 = p2;

        boolean seguirJugando = true;

        while (seguirJugando) {
            long startTime = System.currentTimeMillis();

            this.current = p1;
            board.clear();
            history.clear();
            GameResult result = GameResult.IN_PROGRESS;

            while (result == GameResult.IN_PROGRESS) {
                view.printBoard(board);

                int col = getColumnFromPlayer(current);

                if (col == UNDO_CODE) {
                    if (history.canUndo()) {
                        history.undo();
                        current = toggle(current);
                        view.println("<< Acción deshecha.");
                    } else {
                        view.println("No hay movimientos para deshacer.");
                    }
                    continue;
                }

                if (col == REDO_CODE) {
                    if (history.canRedo()) {
                        history.redo();
                        current = toggle(current);
                        view.println("Acción rehecha.>>");
                    } else {
                        view.println("No hay movimientos para rehacer.");
                    }
                    continue;
                }

                if (!isValidMove(col)) {
                    view.println("Movimiento inválido. Intenta de nuevo.");
                    continue;
                }

                DropDiscCommand cmd = new DropDiscCommand(board, current, col);
                history.execute(cmd);
                Move mv = cmd.getMove();

                result = rules.evaluate(board, current.getColor(),
                        mv.getRowApplied(), mv.getColumn());

                if (result == GameResult.IN_PROGRESS) {
                    if (board.isFull()) {
                        result = GameResult.DRAW;
                    } else {
                        current = toggle(current);
                    }
                }
            }

            view.printBoard(board);
            mostrarResultado(result);

            long duration = System.currentTimeMillis() - startTime;

            if (result == GameResult.RED_WINS) {
                ranking.addResult(new MatchResult(p1.getName(), p1.getColor(), duration));
            } else if (result == GameResult.YELLOW_WINS) {
                ranking.addResult(new MatchResult(p2.getName(), p2.getColor(), duration));
            }

            mostrarRanking();

            String respuesta;
            do {
                respuesta = view.prompt("¿Quieres jugar otra partida? (s/n): ")
                        .trim().toLowerCase();
                if (!respuesta.equals("s") && !respuesta.equals("n")) {
                    view.println("Entrada no válida. Debes escribir 's' o 'n'.");
                }
            } while (!respuesta.equals("s") && !respuesta.equals("n"));

            seguirJugando = respuesta.equals("s");

            if (!seguirJugando) {
                view.println("Gracias por jugar Conecta4. ¡Hasta pronto!");
            }
        }
    }

    private int getColumnFromPlayer(Player player) {
        if (player.isAi()) {
            int col = player.getStrategy().chooseColumn(board, player);
            view.println(player.getDisplayName() + " juega en columna " + col);
            return col;
        } else {
            String input = view.prompt(player.getDisplayName()
                    + " - columna [0-" + (Board.COLS - 1) + "] o 'u' (undo), 'r' (redo): ")
                    .trim();

            if (input.equalsIgnoreCase("u")) return UNDO_CODE;
            if (input.equalsIgnoreCase("r")) return REDO_CODE;

            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                view.println("Entrada no válida. Introduce un número o 'u'/'r'.");
                return -1;
            }
        }
    }

    private boolean isValidMove(int col) {
        return col >= 0 && col < Board.COLS && !board.isColumnFull(col);
    }

    private Player toggle(Player current) {
        return current == p1 ? p2 : p1;
    }

    private void mostrarResultado(GameResult result) {
        switch (result) {
            case RED_WINS ->
                view.println("¡Ganó " + p1.getName() + " (" + p1.getColor() + ")!");
            case YELLOW_WINS ->
                view.println("¡Ganó " + p2.getName() + " (" + p2.getColor() + ")!");
            case DRAW ->
                view.println("Empate. ¡Gran partida entre "
                        + p1.getName() + " y " + p2.getName() + "!");
            default ->
                view.println("Partida finalizada.");
        }
    }

    /**
     * Nuevo método que imprime el ranking usando la vista.
     */
    private void mostrarRanking() {
        view.println("\n=== Ranking por número de victorias ===");
        ranking.getWinsRanking().forEach(entry ->
                view.println(entry.getKey() + " - " + entry.getValue() + " victorias")
        );

        view.println("\n=== Ranking por partida más rápida ===");
        ranking.getByFastest().forEach(result ->
                view.println(result.toString())
        );
    }
}
