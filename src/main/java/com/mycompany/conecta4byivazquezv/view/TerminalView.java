package com.mycompany.conecta4byivazquezv.view;

import com.mycompany.conecta4byivazquezv.model.Board;
import com.mycompany.conecta4byivazquezv.model.DiscColor;

import java.util.Scanner;

/**
 * Vista en consola para el juego Conecta4.
 * Se encarga de mostrar el tablero con colores ANSI y gestionar la interacción con el usuario.
 */
public final class TerminalView {
    // Scanner para leer entrada del usuario desde consola
    private final Scanner scanner = new Scanner(System.in);

    // Códigos ANSI para aplicar colores en la consola
    private static final String ANSI_RESET  = "\u001B[0m";  // Restablece color por defecto
    private static final String ANSI_RED    = "\u001B[31m"; // Texto rojo
    private static final String ANSI_YELLOW = "\u001B[33m"; // Texto amarillo

    /**
     * Muestra el tablero en consola con colores ANSI.
     * Cada celda se representa como:
     * - "R" en rojo para fichas rojas
     * - "Y" en amarillo para fichas amarillas
     * - Espacio en blanco para celdas vacías
     *
     * @param board tablero actual
     */
    public void printBoard(Board board) {
        System.out.println("\n   === TABLERO CONECTA4 ===");
        
        // Recorremos todas las filas del tablero
        for (int r = 0; r < Board.ROWS; r++) {
            System.out.print("|"); // separador de inicio de fila
            for (int c = 0; c < Board.COLS; c++) {
                DiscColor color = board.getGrid()[r][c].getColor();
                
                // Asignamos símbolo según el color de la celda
                String symbol = switch (color) {
                    case RED -> ANSI_RED + "R" + ANSI_RESET;       // Ficha roja
                    case YELLOW -> ANSI_YELLOW + "Y" + ANSI_RESET; // Ficha amarilla
                    default -> " ";                                // Celda vacía
                };
                
                // Imprimimos celda con separadores
                System.out.print(" " + symbol + " |");
            }
            System.out.println(); // salto de línea al final de cada fila
        }

        // Línea inferior con índices de columnas para referencia del jugador
        System.out.print("   ");
        for (int c = 0; c < Board.COLS; c++) {
            System.out.print(" " + c + "  ");
        }
        System.out.println("\n");
    }

    /**
     * Solicita entrada al usuario mostrando un mensaje en consola.
     * @param message mensaje que se muestra al usuario
     * @return texto introducido por el usuario
     */
    public String prompt(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    /**
     * Imprime un mensaje en consola con salto de línea.
     * @param message texto a mostrar
     */
    public void println(String message) {
        System.out.println(message);
    }
}
