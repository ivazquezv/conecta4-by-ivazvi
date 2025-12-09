package com.mycompany.conecta4byivazquezv.rules;

import com.mycompany.conecta4byivazquezv.model.Board;
import com.mycompany.conecta4byivazquezv.model.DiscColor;
import com.mycompany.conecta4byivazquezv.model.GameResult;

/**
 * Regla de victoria para comprobar alineaciones verticales en el tablero.
 */
public final class VerticalWinRule extends BaseWinRule {

    @Override
    public GameResult evaluate(Board board, DiscColor color, int row, int col) {
        int consecutiveCount = 0;

        // Recorremos todas las filas de la columna indicada
        for (int currentRow = 0; currentRow < Board.ROWS; currentRow++) {
            if (board.getGrid()[currentRow][col].getColor() == color) {
                consecutiveCount++;
                if (consecutiveCount >= 4) {
                    return (color == DiscColor.RED) ? GameResult.RED_WINS : GameResult.YELLOW_WINS;
                }
            } else {
                consecutiveCount = 0; // reiniciamos si encontramos otra ficha o vacío
            }
        }

        // Si no hay victoria vertical, pasa al siguiente en la cadena
        return next(board, color, row, col);
    }
}
