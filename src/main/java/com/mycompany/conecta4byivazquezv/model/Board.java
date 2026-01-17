package com.mycompany.conecta4byivazquezv.model;

/**
 * Representa el tablero del juego Conecta4.
 * Se compone de una matriz de 6 filas x 7 columnas de celdas.
 */
public final class Board {

    public static final int ROWS = 6;
    public static final int COLS = 7;

    private final Cell[][] grid = new Cell[ROWS][COLS];

    /**
     * Constructor: inicializa todas las celdas como vacías.
     */
    public Board() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                grid[row][col] = new Cell();
            }
        }
    }

    /**
     * Comprueba si una columna está llena.
     * @param col
     * @return 
     */
    public boolean isColumnFull(int col) {
        return !grid[0][col].isEmpty();
    }

    /**
     * Coloca una ficha en la columna indicada, en la posición más baja disponible.
     * @param col
     * @param color
     * @return 
     */
    public int dropDisc(int col, DiscColor color) {
        for (int row = ROWS - 1; row >= 0; row--) {
            if (grid[row][col].isEmpty()) {
                grid[row][col].setColor(color);
                return row;
            }
        }
        throw new IllegalStateException("Columna llena");
    }

    /**
     * Elimina la ficha más alta de una columna (para undo).
     * @param col
     */
    public void removeDisc(int col) {
        for (int row = 0; row < ROWS; row++) {
            if (!grid[row][col].isEmpty()) {
                grid[row][col].setColor(DiscColor.NONE);
                return;
            }
        }
        throw new IllegalStateException("Columna vacía");
    }

    /**
     * Devuelve el color de una celda sin exponer la estructura interna.
     * @param row
     * @param col
     * @return 
     */
    public DiscColor getCellColor(int row, int col) {
        return grid[row][col].getColor();
    }

    /**
     * Devuelve una celda concreta (si alguna regla necesita más información).
     * @param row
     * @param col
     * @return 
     */
    public Cell getCell(int row, int col) {
        return grid[row][col];
    }

    /**
     * Comprueba si el tablero está lleno.
     * @return 
     */
    public boolean isFull() {
        for (int col = 0; col < COLS; col++) {
            if (!isColumnFull(col)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Limpia el tablero, dejando todas las celdas vacías.
     */
    public void clear() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                grid[row][col] = new Cell();
            }
        }
    }
}
