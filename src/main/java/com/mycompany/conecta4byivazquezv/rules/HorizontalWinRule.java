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

            // Comprobamos el color de la celda usando encapsulación correcta
            if (board.getCellColor(row, currentCol) == color) {

                consecutiveCount++;

                if (consecutiveCount >= 4) {
                    return (color == DiscColor.RED)
                            ? GameResult.RED_WINS
                            : GameResult.YELLOW_WINS;
                }

            } else {
                consecutiveCount = 0;
            }
        }

        return next(board, color, row, col);
    }
}
