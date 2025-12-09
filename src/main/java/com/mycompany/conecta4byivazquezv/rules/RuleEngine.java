package com.mycompany.conecta4byivazquezv.rules;

import com.mycompany.conecta4byivazquezv.model.Board;
import com.mycompany.conecta4byivazquezv.model.DiscColor;
import com.mycompany.conecta4byivazquezv.model.GameResult;

/**
 * Motor de reglas del juego Conecta4.
 * Utiliza el patrón Chain of Responsibility para evaluar
 * condiciones de victoria en orden: horizontal → vertical → diagonal.
 */
public final class RuleEngine {
    private final WinRule chain;

    public RuleEngine() {
        // Creamos las reglas
        WinRule horizontal = new HorizontalWinRule();
        WinRule vertical = new VerticalWinRule();
        WinRule diagonal = new DiagonalWinRule();

        // Encadenamos las reglas (forma segura)
        horizontal.setNext(vertical);
        vertical.setNext(diagonal);

        // La cadena empieza por la regla horizontal
        this.chain = horizontal;
    }

    /**
     * Evalúa el tablero tras la última jugada.
     *
     * @param board tablero actual
     * @param lastColor color de la última ficha colocada
     * @param lastRow fila donde cayó la ficha
     * @param lastCol columna donde cayó la ficha
     * @return resultado del juego (IN_PROGRESS, DRAW, RED_WINS, YELLOW_WINS)
     */
    public GameResult evaluate(Board board, DiscColor lastColor, int lastRow, int lastCol) {
        return chain.evaluate(board, lastColor, lastRow, lastCol);
    }
}
