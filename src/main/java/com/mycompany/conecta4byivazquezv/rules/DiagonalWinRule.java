
package com.mycompany.conecta4byivazquezv.rules;

import com.mycompany.conecta4byivazquezv.model.Board;
import com.mycompany.conecta4byivazquezv.model.DiscColor;
import com.mycompany.conecta4byivazquezv.model.GameResult;
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

        // Si no hay victoria diagonal, pasa al siguiente en la cadena
        return next(board, color, row, col);
    }

    private boolean checkDiagonal(Board board, DiscColor color, int row, int col, int rowDir, int colDir) {
        int count = 1; // incluye la ficha recién colocada

        // Hacia adelante
        int r = row + rowDir;
        int c = col + colDir;
        while (r >= 0 && r < Board.ROWS && c >= 0 && c < Board.COLS &&
               board.getGrid()[r][c].getColor() == color) {
            count++;
            r += rowDir;
            c += colDir;
        }

        // Hacia atrás
        r = row - rowDir;
        c = col - colDir;
        while (r >= 0 && r < Board.ROWS && c >= 0 && c < Board.COLS &&
               board.getGrid()[r][c].getColor() == color) {
            count++;
            r -= rowDir;
            c -= colDir;
        }

        return count >= 4;
    }
}
