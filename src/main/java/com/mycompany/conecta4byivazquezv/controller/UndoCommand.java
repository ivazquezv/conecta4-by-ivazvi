package com.mycompany.conecta4byivazquezv.controller;

import com.mycompany.conecta4byivazquezv.model.Move;

/**
 * Comando del sistema que deshace la última jugada usando CommandHistory.
 */
public final class UndoCommand implements Command {
    private final CommandHistory history;

    public UndoCommand(CommandHistory history) {
        this.history = history;
    }

    /**
     * Ejecuta la operación de deshacer en el historial.
     * No crea una jugada de tablero, por eso devuelve null.
     */
    @Override
    public Move execute() {
        if (history.canUndo()) {
            history.undo();
        }
        return null;
    }

    /**
     * Deshace el efecto de este comando de sistema,
     * que equivale a rehacer (redo) lo que se deshizo.
     */
    @Override
    public void undo() {
        if (history.canRedo()) {
            history.redo();
        }
    }
}

