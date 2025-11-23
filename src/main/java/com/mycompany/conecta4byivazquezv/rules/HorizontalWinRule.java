
package com.mycompany.conecta4byivazquezv.rules;

import com.mycompany.conecta4byivazquezv.model.Board;
import com.mycompany.conecta4byivazquezv.model.DiscColor;
import com.mycompany.conecta4byivazquezv.model.GameResult;

public final class HorizontalWinRule extends BaseWinRule {

    @Override
    public GameResult evaluate(Board board, DiscColor color, int row, int col) {
        int count = 0;
        for (int c = 0; c < Board.COLS; c++) {
            if (board.getGrid()[row][c].getColor() == color) {
                count++;
                if (count >= 4) {
                    return (color == DiscColor.RED) ? GameResult.RED_WINS : GameResult.YELLOW_WINS;
                }
            } else {
                count = 0;
            }
        }
        // Si no hay victoria horizontal, pasa al siguiente en la cadena
        return next(board, color, row, col);
    }
}
