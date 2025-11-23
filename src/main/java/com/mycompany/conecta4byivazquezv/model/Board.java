package com.mycompany.conecta4byivazquezv.model;

/**
 * Representa el tablero del juego Conecta4.
 * Se compone de una matriz de 6 filas x 7 columnas de celdas.
 */
public final class Board {
    // Constantes que definen el tamaño del tablero
    public static final int ROWS = 6;
    public static final int COLS = 7;

    // Matriz de celdas que almacena el estado del tablero
    private final Cell[][] grid = new Cell[ROWS][COLS];

    /**
     * Constructor: inicializa todas las celdas como vacías.
     */
    public Board() {
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                grid[r][c] = new Cell();
            }
        }
    }

    /**
     * Comprueba si una columna está llena.
     * @param col índice de columna
     * @return true si la columna está llena, false si aún tiene espacio
     */
    public boolean isColumnFull(int col) {
        return !grid[0][col].isEmpty();
    }

    /**
     * Coloca una ficha en la columna indicada, en la posición más baja disponible.
     * @param col columna donde se coloca la ficha
     * @param color color de la ficha
     * @return fila en la que se colocó la ficha
     * @throws IllegalStateException si la columna está llena
     */
    public int dropDisc(int col, DiscColor color) {
        for (int r = ROWS - 1; r >= 0; r--) {
            if (grid[r][col].isEmpty()) {
                grid[r][col].setColor(color);
                return r;
            }
        }
        throw new IllegalStateException("Columna llena");
    }

    /**
     * Elimina la ficha más alta de una columna (para operaciones de undo).
     * @param col columna de la que se elimina la ficha
     * @throws IllegalStateException si la columna está vacía
     */
    public void removeDisc(int col) {
        for (int r = 0; r < ROWS; r++) {
            if (!grid[r][col].isEmpty()) {
                grid[r][col].setColor(DiscColor.NONE);
                return;
            }
        }
        throw new IllegalStateException("Columna vacía");
    }

    /**
     * Devuelve la matriz completa del tablero.
     * @return grid de celdas
     */
    public Cell[][] getGrid() {
        return grid;
    }
}
