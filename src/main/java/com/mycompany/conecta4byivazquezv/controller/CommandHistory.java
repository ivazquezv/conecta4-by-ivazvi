
package com.mycompany.conecta4byivazquezv.controller;

import java.util.Stack;

/**
 * Maneja el historial de comandos para permitir undo/redo.
 */
public final class CommandHistory {
    private final Stack<Command> executed = new Stack<>();
    private final Stack<Command> undone = new Stack<>();

    /**
     * Ejecuta un comando y lo guarda en el historial.
     */
    public void execute(Command cmd) {
        cmd.execute();
        executed.push(cmd);
        // Al ejecutar un nuevo comando, se limpia la pila de redo
        undone.clear();
    }

    /**
     * Deshace el último comando ejecutado.
     */
    public void undo() {
        if (!executed.isEmpty()) {
            Command cmd = executed.pop();
            cmd.undo();
            undone.push(cmd);
        }
    }

    /**
     * Rehace el último comando deshecho.
     */
    public void redo() {
        if (!undone.isEmpty()) {
            Command cmd = undone.pop();
            cmd.execute();
            executed.push(cmd);
        }
    }

    /**
     * Comprueba si hay comandos para deshacer.
     */
    public boolean canUndo() {
        return !executed.isEmpty();
    }

    /**
     * Comprueba si hay comandos para rehacer.
     */
    public boolean canRedo() {
        return !undone.isEmpty();
    }
}
