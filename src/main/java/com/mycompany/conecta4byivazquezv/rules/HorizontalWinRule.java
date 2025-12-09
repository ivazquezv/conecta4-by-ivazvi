package com.mycompany.conecta4byivazquezv.rules;

import com.mycompany.conecta4byivazquezv.model.Board;
import com.mycompany.conecta4byivazquezv.model.DiscColor;
import com.mycompany.conecta4byivazquezv.model.GameResult;

/**
 * Regla de victoria para comprobar alineaciones horizontales en el tablero.
 */
public final class HorizontalWinRule extends BaseWinRule {

    @Override
    public GameResult evaluate(Board board, DiscColor color, int row, int col) {
        int consecutiveCount = 0;

        // Recorremos todas las columnas de la fila indicada
        for (int currentCol = 0; currentCol < Board.COLS; currentCol++) {
            if (board.getGrid()[row][currentCol].getColor() == color) {
                consecutiveCount++;
                if (consecutiveCount >= 4) {
                    return (color == DiscColor.RED) ? GameResult.RED_WINS : GameResult.YELLOW_WINS;
                }
            } else {
                consecutiveCount = 0; // reiniciamos si encontramos otra ficha o vacío
            }
        }

        // Si no hay victoria horizontal, pasa al siguiente en la cadena
        return next(board, color, row, col);
    }
}
