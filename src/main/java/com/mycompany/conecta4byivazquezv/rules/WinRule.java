
package com.mycompany.conecta4byivazquezv.rules;

import com.mycompany.conecta4byivazquezv.model.Board;
import com.mycompany.conecta4byivazquezv.model.DiscColor;
import com.mycompany.conecta4byivazquezv.model.GameResult;



public interface WinRule {
    GameResult evaluate(Board board, DiscColor lastColor, int lastRow, int lastCol);
    void setNext(WinRule next);
}
