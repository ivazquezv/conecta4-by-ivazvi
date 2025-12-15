package com.mycompany.conecta4byivazquezv.model;

/**
 * Representa una celda individual del tablero de Conecta4.
 * Cada celda puede estar vacía o contener una ficha de un color específico.
 */
public final class Cell {
<<<<<<< HEAD
    // Color actual de la celda.
    // Puede ser ROJO, AMARILLO o NONE (vacía).
=======
    // Color actual de la celda (ROJO, AMARILLO o NONE si está vacía)
>>>>>>> c40613905afa72172cf579325da90ebf647682ad
    private DiscColor color;

    /**
     * Constructor: inicializa la celda como vacía (sin ficha).
<<<<<<< HEAD
     * Se asigna DiscColor.NONE para indicar que no hay ficha colocada.
=======
>>>>>>> c40613905afa72172cf579325da90ebf647682ad
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
<<<<<<< HEAD
     * Este método se usa cuando un jugador coloca o retira una ficha.
=======
>>>>>>> c40613905afa72172cf579325da90ebf647682ad
     */
    public void setColor(DiscColor color) {
        this.color = color;
    }

    /**
     * Comprueba si la celda está vacía.
     * @return true si no contiene ficha, false en caso contrario
<<<<<<< HEAD
     * Se usa en Board para saber si se puede colocar una ficha en esa posición.
=======
>>>>>>> c40613905afa72172cf579325da90ebf647682ad
     */
    public boolean isEmpty() {
        return color == DiscColor.NONE;
    }
}
