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
<<<<<<< HEAD
        // Usamos nombres más expresivos: row y cell
        for (int row = 0; row < ROWS; row++) {
            for (int cell = 0; cell < COLS; cell++) {
                grid[row][cell] = new Cell();
=======
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                grid[r][c] = new Cell();
>>>>>>> c40613905afa72172cf579325da90ebf647682ad
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
<<<<<<< HEAD
        // Recorremos desde la última fila hacia arriba
        for (int row = ROWS - 1; row >= 0; row--) {
            if (grid[row][col].isEmpty()) {
                grid[row][col].setColor(color);
                return row;
=======
        for (int r = ROWS - 1; r >= 0; r--) {
            if (grid[r][col].isEmpty()) {
                grid[r][col].setColor(color);
                return r;
>>>>>>> c40613905afa72172cf579325da90ebf647682ad
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
<<<<<<< HEAD
        for (int row = 0; row < ROWS; row++) {
            if (!grid[row][col].isEmpty()) {
                grid[row][col].setColor(DiscColor.NONE);
=======
        for (int r = 0; r < ROWS; r++) {
            if (!grid[r][col].isEmpty()) {
                grid[r][col].setColor(DiscColor.NONE);
>>>>>>> c40613905afa72172cf579325da90ebf647682ad
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

<<<<<<< HEAD
    /**
     * Comprueba si el tablero está lleno (sin columnas disponibles).
     * @return true si todas las columnas están llenas, false en caso contrario
     */
    public boolean isFull() {
        // Usamos cell en lugar de c para mayor claridad
        for (int cell = 0; cell < COLS; cell++) {
            if (!isColumnFull(cell)) {
                return false; // encontramos una columna con espacio
            }
        }
        return true; // todas las columnas están llenas
    }

    /**
=======
/**
 * Comprueba si el tablero está lleno (sin columnas disponibles).
 * @return true si todas las columnas están llenas, false en caso contrario
 */
public boolean isFull() {
    for (int c = 0; c < COLS; c++) {
        if (!isColumnFull(c)) {
            return false; // encontramos una columna con espacio
        }
    }
    return true; // todas las columnas están llenas
}

     /**
>>>>>>> c40613905afa72172cf579325da90ebf647682ad
     * Limpia el tablero, dejando todas las celdas vacías.
     */
    public void clear() {
        for (int row = 0; row < ROWS; row++) {
<<<<<<< HEAD
            for (int cell = 0; cell < COLS; cell++) {
                grid[row][cell] = new Cell(); // crea celda vacía
            }
        }
    }
=======
            for (int col = 0; col < COLS; col++) {
                grid[row][col] = new Cell(); // crea celda vacía
            }
        }
    }

>>>>>>> c40613905afa72172cf579325da90ebf647682ad
}
