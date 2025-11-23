package com.mycompany.conecta4byivazquezv.view;

import com.mycompany.conecta4byivazquezv.model.Board;
import com.mycompany.conecta4byivazquezv.model.DiscColor;

/**
 * Clase utilitaria para renderizar el tablero en diferentes formatos.
 * Actualmente implementa renderizado en texto plano con colores ANSI
 * para mejorar la visualización en consola.
 */
public final class Renderer {

    // Códigos ANSI para aplicar colores en la consola
    private static final String ANSI_RESET  = "\u001B[0m";  // Restablece color por defecto
    private static final String ANSI_RED    = "\u001B[31m"; // Texto rojo
    private static final String ANSI_YELLOW = "\u001B[33m"; // Texto amarillo

    /**
     * Constructor privado para evitar instanciación.
     * La clase solo contiene métodos estáticos.
     */
    private Renderer() {
        // Evita instanciación
    }

    /**
     * Devuelve una representación en texto del tablero con colores ANSI.
     * Cada celda se muestra como:
     * - "R" en rojo para fichas rojas
     * - "Y" en amarillo para fichas amarillas
     * - Espacio en blanco para celdas vacías
     *
     * @param board tablero actual
     * @return String con el tablero renderizado en formato visual
     */
    public static String renderBoard(Board board) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        
        // Recorremos todas las filas del tablero
        for (int r = 0; r < Board.ROWS; r++) {
            sb.append("|"); // separador de inicio de fila
            for (int c = 0; c < Board.COLS; c++) {
                // Obtenemos el color de la celda actual
                DiscColor color = board.getGrid()[r][c].getColor();
                
                // Asignamos símbolo según el color
                String symbol = switch (color) {
                    case RED -> ANSI_RED + "R" + ANSI_RESET;       // Ficha roja
                    case YELLOW -> ANSI_YELLOW + "Y" + ANSI_RESET; // Ficha amarilla
                    default -> " ";                                // Celda vacía
                };
                
                // Añadimos símbolo con separadores
                sb.append(" ").append(symbol).append(" |");
            }
            sb.append("\n"); // salto de línea al final de cada fila
        }
        
        // Línea inferior con índices de columnas para referencia del jugador
        sb.append(" ");
        for (int c = 0; c < Board.COLS; c++) {
            sb.append(" ").append(c).append("  ");
        }
        sb.append("\n");
        
        return sb.toString();
    }
}
