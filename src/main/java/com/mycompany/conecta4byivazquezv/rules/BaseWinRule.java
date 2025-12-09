package com.mycompany.conecta4byivazquezv.rules;

import com.mycompany.conecta4byivazquezv.model.Board;
import com.mycompany.conecta4byivazquezv.model.DiscColor;
import com.mycompany.conecta4byivazquezv.model.GameResult;

/**
 * Clase base para las reglas de victoria.
 * Implementa el patrón Chain of Responsibility:
 * cada regla puede evaluar una condición y, si no aplica,
 * delega en la siguiente regla de la cadena.
 */
public abstract class BaseWinRule implements WinRule {
    private WinRule next;

    /**
     * Establece la siguiente regla en la cadena.
     * Respeta la firma de la interfaz (void).
     */
    @Override
    public void setNext(WinRule next) {
        this.next = next;
    }

    /**
     * Método auxiliar para encadenamiento fluido sin romper la interfaz.
     * Permite escribir: rule1.then(rule2).then(rule3);
     */
    public WinRule then(WinRule next) {
        this.next = next;
        return next;
    }

    /**
     * Comprueba si existe una regla siguiente en la cadena.
     * @return true si hay otra regla, false si es el final
     */
    protected boolean hasNext() {
        return next != null;
    }

    /**
     * Llama a la siguiente regla en la cadena si existe.
     * Si no hay más reglas, devuelve IN_PROGRESS.
     */
    protected GameResult next(Board board, DiscColor color, int row, int col) {
        return (next == null) ? GameResult.IN_PROGRESS : next.evaluate(board, color, row, col);
    }
}
