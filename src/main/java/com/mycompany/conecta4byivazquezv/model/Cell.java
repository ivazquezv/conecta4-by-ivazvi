package com.mycompany.conecta4byivazquezv.model;

/**
 * Representa una celda individual del tablero de Conecta4.
 * Cada celda puede estar vacía o contener una ficha de un color específico.
 */
public final class Cell {
    // Color actual de la celda (ROJO, AMARILLO o NONE si está vacía)
    private DiscColor color;

    /**
     * Constructor: inicializa la celda como vacía (sin ficha).
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
     */
    public void setColor(DiscColor color) {
        this.color = color;
    }

    /**
     * Comprueba si la celda está vacía.
     * @return true si no contiene ficha, false en caso contrario
     */
    public boolean isEmpty() {
        return color == DiscColor.NONE;
    }
}
