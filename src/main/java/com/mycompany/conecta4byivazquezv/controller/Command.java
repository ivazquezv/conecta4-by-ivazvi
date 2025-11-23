
package com.mycompany.conecta4byivazquezv.controller;

import com.mycompany.conecta4byivazquezv.model.Move;

public interface Command {
    /**
     * Ejecuta el comando y devuelve el movimiento realizado.
     * @return Move con la información del jugador, columna y fila aplicada.
     */
    Move execute();

    /**
     * Revierte el comando (deshace el movimiento).
     */
    void undo();
}
