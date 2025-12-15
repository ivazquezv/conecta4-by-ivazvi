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
<<<<<<< HEAD
 * Controlador principal del juego Conecta4.
 * Gestiona el flujo de la partida: turnos, validación de movimientos,
 * comprobación de reglas y comunicación con la vista.
 * 
=======
 * Controlador principal del juego Conecta4. Gestiona el flujo de la partida:
 * turnos, validación de movimientos, comprobación de reglas y comunicación con
 * la vista (TerminalView).
 *
>>>>>>> c40613905afa72172cf579325da90ebf647682ad
 * Soporta tanto jugadores humanos como jugadores IA.
 */
public final class GameController {

<<<<<<< HEAD
    // Constantes especiales para representar acciones de control
    private static final int UNDO_CODE = -2; // código para deshacer jugada
    private static final int REDO_CODE = -3; // código para rehacer jugada

    // Componentes principales del juego
    private final Board board = new Board();             // Tablero del juego
    private final RuleEngine rules = new RuleEngine();   // Motor de reglas (evalúa victorias/empates)
    private final TerminalView view = new TerminalView();// Vista en consola
    private final CommandHistory history = new CommandHistory(); // Historial de comandos (undo/redo)
    private final Ranking ranking = new Ranking();       // Ranking acumulado de partidas

    // Jugadores
=======
    private static final int UNDO_CODE = -2; //representa la acción de deshacer
    private static final int REDO_CODE = -3; //representa la acción de rehacer

    private final Board board = new Board();             // Tablero del juego
    private final RuleEngine rules = new RuleEngine();   // Motor de reglas
    private final TerminalView view = new TerminalView();// Vista en consola
    private final CommandHistory history = new CommandHistory(); // Historial de comandos
    private final Ranking ranking = new Ranking();       // Ranking acumulado

>>>>>>> c40613905afa72172cf579325da90ebf647682ad
    private Player current; // Jugador en turno
    private Player p1;      // Jugador 1
    private Player p2;      // Jugador 2

    /**
     * Inicia la partida entre dos jugadores (humanos o IA).
     */
    public void start(Player p1, Player p2) {
        this.p1 = p1;
        this.p2 = p2;

        boolean seguirJugando = true;

<<<<<<< HEAD
        // Bucle para jugar varias partidas seguidas
        while (seguirJugando) {
            long startTime = System.currentTimeMillis(); // Marca inicio de la partida

            this.current = p1; // Siempre comienza el jugador 1
            board.clear();     // Reinicia tablero vacío
            history.clear();   // Limpia historial de jugadas
            GameResult result = GameResult.IN_PROGRESS; // Estado inicial

            // Bucle principal de la partida
            while (result == GameResult.IN_PROGRESS) {
                view.printBoard(board); // Muestra tablero en consola

                int col = getColumnFromPlayer(current); // Obtiene columna elegida

                // --- Gestión de acciones especiales (undo/redo) ---
                if (col == UNDO_CODE) {
                    if (history.canUndo()) {
                        history.undo();          // Deshace última jugada
                        current = toggle(current); // Cambia turno atrás
=======
        while (seguirJugando) {
            long startTime = System.currentTimeMillis(); // inicio de partida

            this.current = p1; // comienza el jugador 1
            board.clear();     // reinicia tablero
            history.clear();   // limpia historial de comandos
            GameResult result = GameResult.IN_PROGRESS;

            // Bucle principal de la partida
            while (result == GameResult.IN_PROGRESS) {
                view.printBoard(board);

                int col = getColumnFromPlayer(current);

                // Gestionar acciones de control (undo/redo)
                if (col == UNDO_CODE) {
                    if (history.canUndo()) {
                        history.undo();
                        current = toggle(current);
>>>>>>> c40613905afa72172cf579325da90ebf647682ad
                        view.println("<< Acción deshecha.");
                    } else {
                        view.println("No hay movimientos para deshacer.");
                    }
<<<<<<< HEAD
                    continue; // Vuelve al inicio del bucle
                }
                if (col == REDO_CODE) {
                    if (history.canRedo()) {
                        history.redo();          // Rehace jugada deshecha
                        current = toggle(current); // Cambia turno adelante
=======
                    continue;
                }
                if (col == REDO_CODE) {
                    if (history.canRedo()) {
                        history.redo();
                        current = toggle(current);
>>>>>>> c40613905afa72172cf579325da90ebf647682ad
                        view.println("Acción rehecha.>>");
                    } else {
                        view.println("No hay movimientos para rehacer.");
                    }
                    continue;
                }

<<<<<<< HEAD
                // --- Validación de movimiento ---
=======
                // Validar movimiento
>>>>>>> c40613905afa72172cf579325da90ebf647682ad
                if (!isValidMove(col)) {
                    view.println("Movimiento inválido. Intenta de nuevo.");
                    continue;
                }

<<<<<<< HEAD
                // --- Aplicar jugada usando patrón Command ---
                DropDiscCommand cmd = new DropDiscCommand(board, current, col);
                history.execute(cmd); // Ejecuta y guarda en historial
                Move mv = cmd.getMove(); // Obtiene jugada aplicada

                // --- Evaluar estado del juego ---
                result = rules.evaluate(board, current.getColor(),
                                        mv.getRowApplied(), mv.getColumn());

                if (result == GameResult.IN_PROGRESS) {
                    if (board.isFull()) {
                        result = GameResult.DRAW; // Empate si tablero lleno
                    } else {
                        current = toggle(current); // Cambia turno al otro jugador
=======
                // Aplicar jugada usando Command/Historial
                DropDiscCommand cmd = new DropDiscCommand(board, current, col);
                history.execute(cmd);
                Move mv = cmd.getMove();

                // Evaluar estado del juego
                result = rules.evaluate(board, current.getColor(), mv.getRowApplied(), mv.getColumn());

                if (result == GameResult.IN_PROGRESS) {
                    if (board.isFull()) {
                        result = GameResult.DRAW;
                    } else {
                        current = toggle(current); // cambiar turno
>>>>>>> c40613905afa72172cf579325da90ebf647682ad
                    }
                }
            }

<<<<<<< HEAD
            // --- Fin de partida ---
            view.printBoard(board);    // Muestra tablero final
            mostrarResultado(result);  // Muestra mensaje de resultado

            // --- Registrar resultado en ranking ---
=======
            // Mostrar resultado final
            view.printBoard(board);
            mostrarResultado(result);

            // Registrar resultado en ranking
>>>>>>> c40613905afa72172cf579325da90ebf647682ad
            long duration = System.currentTimeMillis() - startTime;
            if (result == GameResult.RED_WINS) {
                ranking.addResult(new MatchResult(p1.getName(), p1.getColor(), duration));
            } else if (result == GameResult.YELLOW_WINS) {
                ranking.addResult(new MatchResult(p2.getName(), p2.getColor(), duration));
            }

<<<<<<< HEAD
            // --- Mostrar ranking acumulado ---
            ranking.printByWins();    // Ranking por victorias
            ranking.printByFastest(); // Ranking por partidas más rápidas

            // --- Preguntar si se quiere jugar otra partida ---
            String respuesta;
            do {
                respuesta = view.prompt("¿Quieres jugar otra partida? (s/n): ")
                                .trim().toLowerCase();
=======
            // Mostrar ranking acumulado
            ranking.printByWins();
            ranking.printByFastest();

            // Preguntar si quiere volver a jugar
            String respuesta;
            do {
                respuesta = view.prompt("¿Quieres jugar otra partida? (s/n): ").trim().toLowerCase();
>>>>>>> c40613905afa72172cf579325da90ebf647682ad
                if (!respuesta.equals("s") && !respuesta.equals("n")) {
                    view.println("Entrada no válida. Debes escribir 's' para sí o 'n' para no.");
                }
            } while (!respuesta.equals("s") && !respuesta.equals("n"));

<<<<<<< HEAD
            // --- Decisión de continuar ---
=======
>>>>>>> c40613905afa72172cf579325da90ebf647682ad
            if (respuesta.equals("s")) {
                seguirJugando = true;
            } else {
                seguirJugando = false;
                view.println("Gracias por jugar Conecta4. ¡Hasta pronto!");
            }
<<<<<<< HEAD
=======

>>>>>>> c40613905afa72172cf579325da90ebf647682ad
        }
    }

    /**
<<<<<<< HEAD
     * Obtiene la columna elegida por el jugador actual.
     * Soporta atajos: 'u' -> undo, 'r' -> redo (solo humanos).
     */
    private int getColumnFromPlayer(Player player) {
        if (player.isAi()) {
            // Si es IA, se delega en su estrategia
=======
     * Obtiene la columna elegida por el jugador actual. Soporta atajos: 'u' ->
     * undo, 'r' -> redo (solo humanos).
     */
    private int getColumnFromPlayer(Player player) {
        if (player.isAi()) {
>>>>>>> c40613905afa72172cf579325da90ebf647682ad
            int col = player.getStrategy().chooseColumn(board, player);
            view.println(player.getDisplayName() + " juega en columna " + col);
            return col;
        } else {
<<<<<<< HEAD
            // Si es humano, se pide entrada por consola
=======
>>>>>>> c40613905afa72172cf579325da90ebf647682ad
            String input = view.prompt(player.getDisplayName()
                    + " - columna [0-" + (Board.COLS - 1) + "] o 'u' (undo), 'r' (redo): ")
                    .trim();

<<<<<<< HEAD
            // Atajos especiales
=======
>>>>>>> c40613905afa72172cf579325da90ebf647682ad
            if (input.equalsIgnoreCase("u")) {
                return UNDO_CODE;
            }
            if (input.equalsIgnoreCase("r")) {
                return REDO_CODE;
            }

<<<<<<< HEAD
            // Intentar convertir a número
=======
>>>>>>> c40613905afa72172cf579325da90ebf647682ad
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                view.println("Entrada no válida. Debes introducir un número entre 0 y "
                        + (Board.COLS - 1) + ", o 'u' para deshacer, 'r' para rehacer.");
<<<<<<< HEAD
                return -1; // Movimiento inválido
=======
                return -1;
>>>>>>> c40613905afa72172cf579325da90ebf647682ad
            }
        }
    }

    /**
<<<<<<< HEAD
     * Comprueba si un movimiento es válido (columna dentro de rango y no llena).
=======
     * Comprueba si un movimiento es válido.
>>>>>>> c40613905afa72172cf579325da90ebf647682ad
     */
    private boolean isValidMove(int col) {
        return col >= 0 && col < Board.COLS && !board.isColumnFull(col);
    }

    /**
<<<<<<< HEAD
     * Alterna entre jugadores (cambia turno).
=======
     * Alterna entre jugadores.
>>>>>>> c40613905afa72172cf579325da90ebf647682ad
     */
    private Player toggle(Player current) {
        return current == p1 ? p2 : p1;
    }

    /**
<<<<<<< HEAD
     * Muestra el resultado final de la partida en consola.
=======
     * Muestra el resultado final de la partida.
>>>>>>> c40613905afa72172cf579325da90ebf647682ad
     */
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
}
