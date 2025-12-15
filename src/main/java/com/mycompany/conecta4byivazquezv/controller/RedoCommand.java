<<<<<<< HEAD
=======

>>>>>>> c40613905afa72172cf579325da90ebf647682ad
package com.mycompany.conecta4byivazquezv.controller;

import com.mycompany.conecta4byivazquezv.model.Move;

/**
 * Comando del sistema que rehace la última jugada deshecha usando CommandHistory.
<<<<<<< HEAD
 * Forma parte del patrón Command, encapsulando la acción de "rehacer".
 */
public final class RedoCommand implements Command {
    // Referencia al historial de comandos (donde se gestionan undo/redo)
    private final CommandHistory history;

    // Constructor: recibe el historial para poder operar sobre él
=======
 */
public final class RedoCommand implements Command {
    private final CommandHistory history;

>>>>>>> c40613905afa72172cf579325da90ebf647682ad
    public RedoCommand(CommandHistory history) {
        this.history = history;
    }

    /**
     * Ejecuta la operación de rehacer en el historial.
<<<<<<< HEAD
     * - Comprueba si hay jugadas disponibles para rehacer.
     * - Si las hay, llama a history.redo().
     * - No devuelve un Move porque no se crea una jugada nueva,
     *   simplemente se reaplica una ya existente.
     */
    @Override
    public Move execute() {
        if (history.canRedo()) {   // ¿Hay jugadas para rehacer?
            history.redo();        // Reaplica la última jugada deshecha
        }
        return null;               // No se genera un nuevo movimiento
    }

    /**
     * Deshace el efecto de este comando de sistema.
     * - Equivale a "deshacer" lo que se acaba de rehacer.
     * - Se apoya en history.undo() para revertir.
     */
    @Override
    public void undo() {
        if (history.canUndo()) {   // ¿Hay jugadas para deshacer?
            history.undo();        // Revierte la jugada rehecha
=======
     * No crea una jugada de tablero, por eso devuelve null.
     */
    @Override
    public Move execute() {
        if (history.canRedo()) {
            history.redo();
        }
        return null;
    }

    /**
     * Deshace el efecto de este comando de sistema,
     * que equivale a deshacer (undo) lo que se rehizo.
     */
    @Override
    public void undo() {
        if (history.canUndo()) {
            history.undo();
>>>>>>> c40613905afa72172cf579325da90ebf647682ad
        }
    }
}
