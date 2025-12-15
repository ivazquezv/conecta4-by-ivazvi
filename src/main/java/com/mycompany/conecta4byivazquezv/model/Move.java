package com.mycompany.conecta4byivazquezv.model;

/**
 * Representa una jugada realizada en el juego Conecta4.
 * Contiene información sobre el jugador que hizo la jugada,
 * la columna elegida y la fila en la que se aplicó la ficha.
 */
public final class Move {
    // Jugador que realizó la jugada
    private final Player player;
    // Columna donde se colocó la ficha
    private final int column;
    // Fila en la que finalmente se aplicó la ficha
    private final int rowApplied;

    /**
     * Constructor de la jugada.
     * @param player jugador que realiza la jugada
     * @param column columna elegida
     * @param rowApplied fila donde se colocó la ficha
     */
    public Move(Player player, int column, int rowApplied) {
        this.player = player;
        this.column = column;
        this.rowApplied = rowApplied;
    }

    /**
     * Devuelve el jugador que realizó la jugada.
     * @return jugador
     */
    public Player getPlayer() { 
        return player; 
    }

    /**
     * Devuelve la columna donde se colocó la ficha.
     * @return índice de columna
     */
    public int getColumn() { 
        return column; 
    }

    /**
     * Devuelve la fila en la que se aplicó la ficha.
     * @return índice de fila
     */
    public int getRowApplied() { 
        return rowApplied; 
    }
}
