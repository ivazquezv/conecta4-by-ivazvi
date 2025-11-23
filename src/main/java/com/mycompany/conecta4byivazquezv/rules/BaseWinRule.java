package com.mycompany.conecta4byivazquezv.rules;

import com.mycompany.conecta4byivazquezv.model.Board;
import com.mycompany.conecta4byivazquezv.model.DiscColor;
import com.mycompany.conecta4byivazquezv.model.GameResult;

/**
 * Clase base para las reglas de victoria.
 * Implementa la lógica común de encadenamiento entre reglas.
 */
public abstract class BaseWinRule implements WinRule {
    private WinRule next;

    @Override
    public void setNext(WinRule next) {
        this.next = next;
    }

    /**
     * Llama a la siguiente regla en la cadena si existe.
     * Si no hay más reglas, devuelve IN_PROGRESS.
     */
    protected GameResult next(Board board, DiscColor color, int row, int col) {
        return (next == null) ? GameResult.IN_PROGRESS : next.evaluate(board, color, row, col);
    }
}
