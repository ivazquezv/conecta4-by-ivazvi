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
 * Es útil como oponente sencillo o para pruebas.
 */
public final class RandomStrategy implements Strategy {
    // Generador de números aleatorios para elegir columnas
    private final Random random = new Random();

    /**
     * Elige una columna aleatoria entre las disponibles.
     * @param board tablero actual
     * @param player jugador que realiza la jugada (no se usa en esta estrategia)
     * @return índice de columna elegido, o -1 si el tablero está lleno
     */
    @Override
    public int chooseColumn(Board board, Player player) {
        // Lista de columnas válidas (no llenas)
        List<Integer> validColumns = new ArrayList<>();
        
        // Recorrer todas las columnas del tablero
        for (int c = 0; c < Board.COLS; c++) {
            // Si la columna no está llena, añadirla a la lista de opciones
            if (!board.isColumnFull(c)) {
                validColumns.add(c);
            }
        }

        // Si no hay columnas válidas, devolver -1 (jugada imposible)
        if (validColumns.isEmpty()) {
            return -1; // tablero lleno, no hay jugadas posibles
        }

        // Elegir aleatoriamente una columna de la lista de válidas
        return validColumns.get(random.nextInt(validColumns.size()));
    }
}
