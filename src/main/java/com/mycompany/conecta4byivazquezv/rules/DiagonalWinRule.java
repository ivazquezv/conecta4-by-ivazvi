package com.mycompany.conecta4byivazquezv.rules;

import com.mycompany.conecta4byivazquezv.model.Board;      // Modelo del tablero
import com.mycompany.conecta4byivazquezv.model.DiscColor;  // Enum con los colores de las fichas
import com.mycompany.conecta4byivazquezv.model.GameResult; // Resultado posible del juego

/**
 * Regla de victoria para comprobar diagonales en el tablero. Evalúa tanto
 * diagonales descendentes (\) como ascendentes (/). Extiende BaseWinRule para
 * integrarse en la cadena de comprobaciones.
 */
public final class DiagonalWinRule extends BaseWinRule {

    @Override
    public GameResult evaluate(Board board, DiscColor color, int row, int col) {
        // Comprobamos diagonal descendente (\)
        if (checkDiagonal(board, color, row, col, 1, 1)) {
            // Si hay 4 en línea, devolvemos el resultado según el color del jugador
            return (color == DiscColor.RED) ? GameResult.RED_WINS : GameResult.YELLOW_WINS;
        }

        // Comprobamos diagonal ascendente (/)
        if (checkDiagonal(board, color, row, col, -1, 1)) {
            return (color == DiscColor.RED) ? GameResult.RED_WINS : GameResult.YELLOW_WINS;
        }

        // Si no hay victoria diagonal, delegamos en la siguiente regla de la cadena
        return next(board, color, row, col);
    }

    /**
     * Comprueba si hay al menos 4 fichas consecutivas en una diagonal a partir
     * de la posición indicada.
     *
     * @param board tablero completo, necesario para consultar las fichas
     * @param color color de la ficha recién colocada (rojo o amarillo), se pasa
     * porque debemos comprobar que las fichas consecutivas sean del mismo
     * jugador
     * @param row fila inicial donde se colocó la última ficha
     * @param col columna inicial de la última ficha
     * @param rowDir dirección de fila (+1 descendente, -1 ascendente)
     * @param colDir dirección de columna (+1 derecha, -1 izquierda)
     * @return true si hay 4 o más consecutivas del mismo color, false en caso
     * contrario
     */
    private boolean checkDiagonal(Board board, DiscColor color, int row, int col, int rowDir, int colDir) {
        int count = 1; // empezamos contando la ficha recién colocada

        // Avanzar en la dirección indicada (ej. hacia abajo-derecha(descendente) o arriba-derecha(ascendente))
        int currentRow = row + rowDir;
        int currentCol = col + colDir;
        while (currentRow >= 0 && currentRow < Board.ROWS
                && currentCol >= 0 && currentCol < Board.COLS
                && board.getGrid()[currentRow][currentCol].getColor() == color) {
            count++;
            currentRow += rowDir;
            currentCol += colDir;
        }

        // Retroceder en la dirección opuesta (ej. hacia arriba-izquierda(ascendente) o abajo-izquierda (descendente))
        currentRow = row - rowDir;
        currentCol = col - colDir;
        while (currentRow >= 0 && currentRow < Board.ROWS
                && currentCol >= 0 && currentCol < Board.COLS
                && board.getGrid()[currentRow][currentCol].getColor() == color) {
            count++;
            currentRow -= rowDir;
            currentCol -= colDir;
        }

        // Si el total de fichas consecutivas es 4 o más, hay victoria
        return count >= 4;
    }
}
