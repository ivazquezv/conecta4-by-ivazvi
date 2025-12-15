<<<<<<< HEAD
=======

>>>>>>> c40613905afa72172cf579325da90ebf647682ad
package com.mycompany.conecta4byivazquezv.controller;

import com.mycompany.conecta4byivazquezv.model.Move;

<<<<<<< HEAD
/**
 * La interfaz Command define el contrato para implementar el patrón Command
 * dentro del juego Conecta 4.
 *
 * Este patrón permite encapsular las acciones (como colocar una ficha)
 * en objetos independientes, facilitando la ejecución y la reversión
 * de movimientos (por ejemplo, para implementar la opción de "deshacer").
 */
public interface Command {

    /**
     * Ejecuta el comando y devuelve el movimiento realizado.
     *
     * En el contexto del juego, este método representa la acción
     * de colocar una ficha en una columna. El resultado es un objeto
     * Move que contiene:
     *  - El jugador que realizó la acción.
     *  - La columna seleccionada.
     *  - La fila donde finalmente se colocó la ficha.
     *
=======
public interface Command {
    /**
     * Ejecuta el comando y devuelve el movimiento realizado.
>>>>>>> c40613905afa72172cf579325da90ebf647682ad
     * @return Move con la información del jugador, columna y fila aplicada.
     */
    Move execute();

    /**
     * Revierte el comando (deshace el movimiento).
<<<<<<< HEAD
     *
     * Este método permite eliminar la última ficha colocada,
     * devolviendo el tablero al estado anterior. Es útil para:
     *  - Funcionalidad de "deshacer" en la interfaz.
     *  - Algoritmos de inteligencia artificial que prueban
     *    diferentes jugadas y necesitan retroceder.
=======
>>>>>>> c40613905afa72172cf579325da90ebf647682ad
     */
    void undo();
}
