
package com.mycompany.conecta4byivazquezv.rules;

import com.mycompany.conecta4byivazquezv.model.Board;
import com.mycompany.conecta4byivazquezv.model.DiscColor;
import com.mycompany.conecta4byivazquezv.model.GameResult;

public final class VerticalWinRule extends BaseWinRule {

    @Override
    public GameResult evaluate(Board board, DiscColor color, int row, int col) {
        int count = 0;
        for (int r = 0; r < Board.ROWS; r++) {
            if (board.getGrid()[r][col].getColor() == color) {
                count++;
                if (count >= 4) {
                    return (color == DiscColor.RED) ? GameResult.RED_WINS : GameResult.YELLOW_WINS;
                }
            } else {
                count = 0;
            }
        }
        // Si no hay victoria vertical, pasa al siguiente en la cadena
        return next(board, color, row, col);
    }
}
