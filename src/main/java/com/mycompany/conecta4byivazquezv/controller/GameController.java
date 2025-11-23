package com.mycompany.conecta4byivazquezv.controller;

import com.mycompany.conecta4byivazquezv.model.Board;
import com.mycompany.conecta4byivazquezv.model.Player;
import com.mycompany.conecta4byivazquezv.model.GameResult;
import com.mycompany.conecta4byivazquezv.model.Move;
import com.mycompany.conecta4byivazquezv.rules.RuleEngine;
import com.mycompany.conecta4byivazquezv.view.TerminalView;

/**
 * Controlador principal del juego Conecta4.
 * Gestiona el flujo de la partida: turnos, validación de movimientos,
 * comprobación de reglas y comunicación con la vista (TerminalView).
 *
 * Soporta tanto jugadores humanos como jugadores IA.
 */
public final class GameController {
    // Tablero del juego
    private final Board board = new Board();
    // Motor de reglas para evaluar victorias y estado del juego
    private final RuleEngine rules = new RuleEngine();
    // Vista en consola para mostrar tablero y mensajes
    private final TerminalView view = new TerminalView();

    // Jugador actual en turno
    private Player current;
    // Referencias a los dos jugadores
    private Player p1;
    private Player p2;

    /**
     * Inicia la partida entre dos jugadores (humanos o IA).
     * @param p1 primer jugador
     * @param p2 segundo jugador
     */
    public void start(Player p1, Player p2) {
        this.p1 = p1;
        this.p2 = p2;
        this.current = p1; // comienza el jugador 1

        GameResult result = GameResult.IN_PROGRESS;

        // Bucle principal de la partida: se repite mientras no haya ganador ni empate
        while (result == GameResult.IN_PROGRESS) {
            // Mostrar tablero en consola
            view.printBoard(board);

            // Obtener columna según tipo de jugador
            int col = getColumnFromPlayer(current);

            // Validar que la columna esté dentro de rango y no esté llena
            if (col < 0 || col >= Board.COLS || board.isColumnFull(col)) {
                view.println("Movimiento inválido.");
                continue;
            }

            // Aplicar jugada en el tablero
            int row = board.dropDisc(col, current.getColor());
            Move mv = new Move(current, col, row);

            // Evaluar estado del juego tras la jugada
            result = rules.evaluate(board, current.getColor(), mv.getRowApplied(), mv.getColumn());

            if (result == GameResult.IN_PROGRESS) {
                // Si no hay ganador, comprobar si el tablero está lleno
                if (isBoardFull()) {
                    result = GameResult.DRAW; // empate
                } else {
                    // Cambiar turno al otro jugador
                    current = toggle(current);
                }
            }
        }

        // Mostrar tablero final y resultado
        view.printBoard(board);
        view.println(switch (result) {
            case RED_WINS -> "¡Ganó ROJO!";
            case YELLOW_WINS -> "¡Ganó AMARILLO!";
            default -> "Empate.";
        });
    }

    /**
     * Obtiene la columna elegida por el jugador actual.
     * Si es IA, se usa su estrategia; si es humano, se pide entrada por consola.
     * @param player jugador actual
     * @return índice de columna elegido
     */
    private int getColumnFromPlayer(Player player) {
        if (player.isAi()) {
            int col = player.getStrategy().chooseColumn(board, player);
            view.println(player.getName() + " (" + player.getColor() + ") juega en columna " + col);
            return col;
        } else {
            String input = view.prompt(player.getName() + " (" + player.getColor() + ") - columna [0-6]: ");
            try {
                return Integer.parseInt(input.trim());
            } catch (NumberFormatException e) {
                view.println("Entrada no válida.");
                return -1; // valor inválido para forzar repetición de turno
            }
        }
    }

    /**
     * Alterna entre jugadores: si el actual es p1, devuelve p2; si es p2, devuelve p1.
     * @param current jugador actual
     * @return jugador contrario
     */
    private Player toggle(Player current) {
        return current == p1 ? p2 : p1;
    }

    /**
     * Comprueba si el tablero está lleno (sin columnas disponibles).
     * @return true si todas las columnas están llenas, false en caso contrario
     */
    private boolean isBoardFull() {
        for (int c = 0; c < Board.COLS; c++) {
            if (!board.isColumnFull(c)) return false;
        }
        return true;
    }
}
