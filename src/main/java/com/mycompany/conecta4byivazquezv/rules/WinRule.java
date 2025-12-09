package com.mycompany.conecta4byivazquezv.rules;

import com.mycompany.conecta4byivazquezv.model.Board;
import com.mycompany.conecta4byivazquezv.model.DiscColor;
import com.mycompany.conecta4byivazquezv.model.GameResult;

/**
 * Interfaz para las reglas de victoria en Conecta4.
 * Cada regla evalúa el tablero y puede delegar en la siguiente.
 */
public interface WinRule {
    /**
     * Evalúa el tablero tras la última jugada.
     *
     * @param board tablero actual
     * @param lastColor color de la última ficha colocada
     * @param lastRow fila donde cayó la ficha
     * @param lastCol columna donde cayó la ficha
     * @return resultado del juego (IN_PROGRESS, DRAW, RED_WINS, YELLOW_WINS)
     */
    GameResult evaluate(Board board, DiscColor lastColor, int lastRow, int lastCol);

    /**
     * Establece la siguiente regla en la cadena.
     */
    void setNext(WinRule next);
}
