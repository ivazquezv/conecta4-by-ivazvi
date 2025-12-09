package com.mycompany.conecta4byivazquezv.controller;

import java.util.ArrayDeque;
import java.util.Deque; // representa una estructura de datos donde puedes insertar y eliminar elementos por ambos extremos (inicio y fin)

/**
 * Maneja el historial de comandos para permitir undo/redo.
 * 
 * Usa dos pilas:
 * - executed: comandos ya ejecutados (para poder deshacer).
 * - undone: comandos deshechos (para poder rehacer).
 */
public final class CommandHistory {
    private final Deque<Command> executed = new ArrayDeque<>();
    private final Deque<Command> undone = new ArrayDeque<>();

    /**
     * Ejecuta un comando y lo guarda en el historial.
     * Ya no se limpia automáticamente la pila de redo,
     * permitiendo rehacer incluso tras nuevas jugadas.
     */
    public void execute(Command cmd) {
        try {
            cmd.execute();
            executed.addLast(cmd);
            // ⚠️ Antes se hacía undone.clear(), ahora se mantiene
        } catch (Exception e) {
            System.err.println("Error al ejecutar comando: " + e.getMessage());
        }
    }

    /**
     * Deshace el último comando ejecutado.
     */
    public void undo() {
        if (!executed.isEmpty()) {
            Command cmd = executed.removeLast();
            try {
                cmd.undo();
                undone.addLast(cmd);
            } catch (Exception e) {
                System.err.println("Error al deshacer comando: " + e.getMessage());
            }
        }
    }

    /**
     * Rehace el último comando deshecho.
     */
    public void redo() {
        if (!undone.isEmpty()) {
            Command cmd = undone.removeLast();
            try {
                cmd.execute();
                executed.addLast(cmd);
            } catch (Exception e) {
                System.err.println("Error al rehacer comando: " + e.getMessage());
            }
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

    /**
     * Limpia todo el historial de comandos (undo/redo).
     * Se usa al iniciar una nueva partida para empezar fresco.
     */
    public void clear() {
        executed.clear();
        undone.clear();
    }
}
