package com.mycompany.conecta4byivazquezv.view;

import com.mycompany.conecta4byivazquezv.model.Board;
import com.mycompany.conecta4byivazquezv.model.DiscColor;
import java.util.Scanner;

/**
 * Vista en consola para el juego Conecta4.
 * Se encarga de mostrar el tablero con colores ANSI y gestionar la interacción con el usuario.
 */
public final class TerminalView {

    private final Scanner scanner = new Scanner(System.in);

    private static final String ANSI_RESET  = "\u001B[0m";
    private static final String ANSI_RED    = "\u001B[31m";
    private static final String ANSI_YELLOW = "\u001B[33m";

    /**
     * Muestra el tablero en consola con colores ANSI.
     * @param board
     */
    public void printBoard(Board board) {
        System.out.println("\n   === TABLERO CONECTA4 ===");

        for (int r = 0; r < Board.ROWS; r++) {
            System.out.print("|");

            for (int c = 0; c < Board.COLS; c++) {

                DiscColor color = board.getCellColor(r, c);

                String symbol = switch (color) {
                    case RED    -> ANSI_RED + "O" + ANSI_RESET;
                    case YELLOW -> ANSI_YELLOW + "X" + ANSI_RESET;
                    default     -> "_";
                };

                System.out.print(" " + symbol + " |");
            }

            System.out.println();
        }

        System.out.print("   ");
        for (int c = 0; c < Board.COLS; c++) {
            System.out.print(" " + c + "  ");
        }
        System.out.println("\n");
    }

    /**
     * Solicita entrada al usuario mostrando un mensaje en consola.
     * @param message
     * @return 
     */
    public String prompt(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    /**
     * Imprime un mensaje en consola con salto de línea.
     * @param message
     */
    public void println(String message) {
        System.out.println(message);
    }
}
