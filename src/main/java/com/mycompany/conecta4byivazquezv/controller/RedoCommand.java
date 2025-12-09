
package com.mycompany.conecta4byivazquezv.controller;

import com.mycompany.conecta4byivazquezv.model.Move;

/**
 * Comando del sistema que rehace la última jugada deshecha usando CommandHistory.
 */
public final class RedoCommand implements Command {
    private final CommandHistory history;

    public RedoCommand(CommandHistory history) {
        this.history = history;
    }

    /**
     * Ejecuta la operación de rehacer en el historial.
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
        }
    }
}
