package com.mycompany.conecta4byivazquezv.ai;

import com.mycompany.conecta4byivazquezv.model.Board;
import com.mycompany.conecta4byivazquezv.model.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Estrategia básica de IA que elige una columna aleatoria válida.
 * 
 * Esta implementación no analiza el tablero ni aplica heurísticas,
 * simplemente selecciona al azar una columna disponible.
 * Es útil como oponente sencillo.
 */
public final class RandomStrategy implements Strategy {
    // Generador de números aleatorios para elegir columnas
    private final Random random = new Random();

    // Valor especial para indicar que no hay jugadas posibles
    private static final int NO_MOVE = -1;

    /**
     * Elige una columna aleatoria entre las disponibles.
     * @param board tablero actual
     * @param player jugador que realiza la jugada (no se usa en esta estrategia)
     * @return índice de columna elegido, o NO_MOVE si el tablero está lleno
     */
    @Override
    public int chooseColumn(Board board, Player player) {
        // Lista de columnas válidas (no llenas)
        List<Integer> validColumns = new ArrayList<>();
        
        // Recorrer todas las columnas del tablero
        for (int column = 0; column < Board.COLS; column++) {
            if (!board.isColumnFull(column)) {
                validColumns.add(column);
            }
        }

        // Si no hay columnas válidas, devolver NO_MOVE
        if (validColumns.isEmpty()) {
            return NO_MOVE;
        }

        // Elegir aleatoriamente una columna de la lista de válidas
        return validColumns.get(random.nextInt(validColumns.size()));
    }
}
