package com.mycompany.conecta4byivazquezv.rules;

import com.mycompany.conecta4byivazquezv.model.Board;
import com.mycompany.conecta4byivazquezv.model.DiscColor;
import com.mycompany.conecta4byivazquezv.model.GameResult;

/**
 * Regla de victoria para comprobar diagonales en el tablero. Evalúa tanto
 * diagonales descendentes (\) como ascendentes (/). Extiende BaseWinRule para
 * integrarse en la cadena de comprobaciones.
 */
public final class DiagonalWinRule extends BaseWinRule {

    @Override
    public GameResult evaluate(Board board, DiscColor color, int row, int col) {

        // Diagonal descendente (\)
        if (checkDiagonal(board, color, row, col, 1, 1)) {
            return (color == DiscColor.RED) ? GameResult.RED_WINS : GameResult.YELLOW_WINS;
        }

        // Diagonal ascendente (/)
        if (checkDiagonal(board, color, row, col, -1, 1)) {
            return (color == DiscColor.RED) ? GameResult.RED_WINS : GameResult.YELLOW_WINS;
        }

        return next(board, color, row, col);
    }

    /**
     * Comprueba si hay al menos 4 fichas consecutivas en una diagonal.
     */
    private boolean checkDiagonal(Board board, DiscColor color, int row, int col, int rowDir, int colDir) {

        int count = 1;

        // Avanzar en la dirección indicada
        int currentRow = row + rowDir;
        int currentCol = col + colDir;

        while (currentRow >= 0 && currentRow < Board.ROWS
                && currentCol >= 0 && currentCol < Board.COLS
                && board.getCellColor(currentRow, currentCol) == color) {

            count++;
            currentRow += rowDir;
            currentCol += colDir;
        }

        // Retroceder en la dirección opuesta
        currentRow = row - rowDir;
        currentCol = col - colDir;

        while (currentRow >= 0 && currentRow < Board.ROWS
                && currentCol >= 0 && currentCol < Board.COLS
                && board.getCellColor(currentRow, currentCol) == color) {

            count++;
            currentRow -= rowDir;
            currentCol -= colDir;
        }

        return count >= 4;
    }
}
