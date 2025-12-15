package com.mycompany.conecta4byivazquezv.model;

/**
 * Enumeración que representa los posibles colores de las fichas en el juego Conecta4.
 * Se utiliza para identificar el estado de cada celda del tablero.
 */
public enum DiscColor {
    /**
     * Ficha de color rojo (jugador 1).
     * Permite distinguir las fichas del primer jugador.
     */
    RED,

    /**
     * Ficha de color amarillo (jugador 2).
     * Permite distinguir las fichas del segundo jugador.
     */
    YELLOW,

    /**
     * Estado vacío: la celda no contiene ninguna ficha.
     * Se usa para inicializar el tablero y comprobar si una celda está libre.
     */
    NONE
}
