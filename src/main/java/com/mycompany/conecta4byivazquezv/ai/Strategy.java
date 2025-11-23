
package com.mycompany.conecta4byivazquezv.ai;


import com.mycompany.conecta4byivazquezv.model.Board;
import com.mycompany.conecta4byivazquezv.model.Player;

/**
 * Interfaz para definir estrategias de IA en Conecta4.
 * Permite implementar distintos algoritmos de decisión.
 */
public interface Strategy {
    /**
     * Calcula la columna donde el jugador IA debe colocar su ficha.
     *
     * @param board tablero actual
     * @param player jugador que usa la estrategia
     * @return índice de columna (0..Board.COLS-1) donde colocar la ficha
     */
    int chooseColumn(Board board, Player player);
}
