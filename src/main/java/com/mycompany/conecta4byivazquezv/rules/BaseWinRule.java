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
    private WinRule next;// Referencia a la siguiente regla en la cadena

    /**
     * Establece la siguiente regla en la cadena.
     * Respeta la firma de la interfaz (void).
     */
    @Override
    //El método setNext permite encadenar reglas de forma secuencial.
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
 *
 * @param board tablero actual del juego, necesario para consultar las fichas colocadas
 * @param color color de la ficha recién colocada (DiscColor.RED o DiscColor.YELLOW),
 *              se pasa porque las reglas deben comprobar si hay 4 en línea del mismo jugador.
 *              No se analiza el tablero desde cero, solo alrededor de la última ficha colocada.
 * @param row fila donde se colocó la última ficha, para iniciar la comprobación desde esa posición
 * @param col columna donde se colocó la última ficha, complementa la posición exacta a evaluar
 * @return resultado de la evaluación (victoria, empate o en progreso)
 */
protected GameResult next(Board board, DiscColor color, int row, int col) {
    // Si no hay más reglas en la cadena, devolvemos que la partida sigue en progreso.
    // Si existe otra regla, delegamos la evaluación pasando tablero, color y posición.
    return (next == null) ? GameResult.IN_PROGRESS : next.evaluate(board, color, row, col);
}

}
