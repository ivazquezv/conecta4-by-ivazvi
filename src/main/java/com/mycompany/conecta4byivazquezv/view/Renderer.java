package com.mycompany.conecta4byivazquezv.view;

import com.mycompany.conecta4byivazquezv.model.Board;
import com.mycompany.conecta4byivazquezv.model.DiscColor;

/**
 * Clase utilitaria para renderizar el tablero en diferentes formatos.
 * Actualmente implementa renderizado en texto plano con colores ANSI
 * para mejorar la visualización en consola.
 */
public final class Renderer {

    private static final String ANSI_RESET  = "\u001B[0m";
    private static final String ANSI_RED    = "\u001B[31m";
    private static final String ANSI_YELLOW = "\u001B[33m";

    private Renderer() {}

    /**
     * Devuelve una representación en texto del tablero con colores ANSI.
     * @param board
     * @return 
     */
    public static String renderBoard(Board board) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");

        for (int r = 0; r < Board.ROWS; r++) {
            sb.append("|");
            for (int c = 0; c < Board.COLS; c++) {

                DiscColor color = board.getCellColor(r, c);

                String symbol = switch (color) {
                    case RED    -> ANSI_RED + "R" + ANSI_RESET;
                    case YELLOW -> ANSI_YELLOW + "Y" + ANSI_RESET;
                    default     -> " ";
                };

                sb.append(" ").append(symbol).append(" |");
            }
            sb.append("\n");
        }

        sb.append(" ");
        for (int c = 0; c < Board.COLS; c++) {
            sb.append(" ").append(c).append("  ");
        }
        sb.append("\n");

        return sb.toString();
    }
}
