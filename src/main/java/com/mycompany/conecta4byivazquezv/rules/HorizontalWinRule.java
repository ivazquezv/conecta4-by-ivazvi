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

        // Recorremos todas las columnas de la fila indicada (row)
        for (int currentCol = 0; currentCol < Board.COLS; currentCol++) {
            // Si la celda tiene el mismo color que la ficha recién colocada
            if (board.getGrid()[row][currentCol].getColor() == color) {
                consecutiveCount++; // sumamos al contador
                if (consecutiveCount >= 4) {
                    // Si hay 4 o más consecutivas, declaramos victoria
                    return (color == DiscColor.RED) ? GameResult.RED_WINS : GameResult.YELLOW_WINS;
                }
            } else {
                // Si encontramos otra ficha o vacío, reiniciamos el contador
                consecutiveCount = 0;
            }
        }

        // Si no hay victoria horizontal, pasamos la comprobación a la siguiente regla
        return next(board, color, row, col);
    }

}
