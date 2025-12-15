package com.mycompany.conecta4byivazquezv.model;

/**
 * Representa una celda individual del tablero de Conecta4.
 * Cada celda puede estar vacía o contener una ficha de un color específico.
 */
public final class Cell {
    // Color actual de la celda.
    // Puede ser ROJO, AMARILLO o NONE (vacía).
    private DiscColor color;

    /**
     * Constructor: inicializa la celda como vacía (sin ficha).
     * Se asigna DiscColor.NONE para indicar que no hay ficha colocada.
     */
    public Cell() {
        this.color = DiscColor.NONE;
    }

    /**
     * Devuelve el color actual de la celda.
     * @return color de la celda (DiscColor)
     */
    public DiscColor getColor() {
        return color;
    }

    /**
     * Asigna un color a la celda.
     * @param color nuevo color (ROJO, AMARILLO o NONE)
     * Este método se usa cuando un jugador coloca o retira una ficha.
     */
    public void setColor(DiscColor color) {
        this.color = color;
    }

    /**
     * Comprueba si la celda está vacía.
     * @return true si no contiene ficha, false en caso contrario
     * Se usa en Board para saber si se puede colocar una ficha en esa posición.
     */
    public boolean isEmpty() {
        return color == DiscColor.NONE;
    }
}
