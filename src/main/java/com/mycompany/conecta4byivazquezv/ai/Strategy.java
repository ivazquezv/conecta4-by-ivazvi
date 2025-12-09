package com.mycompany.conecta4byivazquezv.ai;

import com.mycompany.conecta4byivazquezv.model.Board;
import com.mycompany.conecta4byivazquezv.model.Player;

/**
 * Interfaz para definir estrategias de IA en Conecta4.
 * 
 * Implementaciones posibles:
 * - {@link RandomStrategy}: elige una columna aleatoria válida.
 * - {@link MinimaxStrategy}: explora jugadas futuras con el algoritmo Minimax.
 * - {@link HeuristicStrategy}: aplica reglas rápidas (ganar, bloquear, centro).
 * 
 * Permite añadir nuevas estrategias sin modificar el resto del código,
 * siguiendo el principio de Open/Closed (OCP).
 */
public interface Strategy {

    /**
     * Valor especial que indica que no hay jugadas posibles
     * (tablero lleno o sin columnas válidas).
     */
    int NO_MOVE = -1;

    /**
     * Calcula la columna donde el jugador IA debe colocar su ficha.
     *
     * @param board tablero actual
     * @param player jugador que usa la estrategia
     * @return índice de columna (0..Board.COLS-1) donde colocar la ficha,
     *         o NO_MOVE si no hay jugadas posibles
     */
    int chooseColumn(Board board, Player player);
}
