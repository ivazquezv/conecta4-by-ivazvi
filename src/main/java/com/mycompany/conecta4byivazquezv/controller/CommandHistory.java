package com.mycompany.conecta4byivazquezv.controller;

import java.util.ArrayDeque;
<<<<<<< HEAD
import java.util.Deque; // Deque = "doble cola": permite insertar y eliminar elementos por ambos extremos.

/**
 * CommandHistory gestiona el historial de comandos del juego Conecta 4.
 * 
 * Implementa la lógica de "undo/redo" usando el patrón Command:
 * - executed: pila de comandos ya ejecutados (sirve para deshacer).
 * - undone: pila de comandos deshechos (sirve para rehacer).
 *
 * Esto permite al jugador retroceder movimientos y volver a aplicarlos,
 * mejorando la experiencia de usuario y facilitando pruebas de IA.
 */
public final class CommandHistory {
    // Pila de comandos ejecutados (último en entrar = primero en deshacer).
    private final Deque<Command> executed = new ArrayDeque<>();
    // Pila de comandos deshechos (último en entrar = primero en rehacer).
=======
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
>>>>>>> c40613905afa72172cf579325da90ebf647682ad
    private final Deque<Command> undone = new ArrayDeque<>();

    /**
     * Ejecuta un comando y lo guarda en el historial.
<<<<<<< HEAD
     * 
     * - Se llama al método execute() del comando.
     * - Se añade a la pila de ejecutados.
     * - ⚠️ Nota: antes se limpiaba la pila de "redo" al ejecutar un nuevo comando,
     *   pero ahora se mantiene para permitir rehacer incluso tras nuevas jugadas.
     */
    public void execute(Command cmd) {
        try {
            cmd.execute();              // Ejecuta la acción (colocar ficha).
            executed.addLast(cmd);      // Guarda el comando en la pila de ejecutados.
            // undone.clear();          // Antes se borraba, ahora se conserva.
=======
     * Ya no se limpia automáticamente la pila de redo,
     * permitiendo rehacer incluso tras nuevas jugadas.
     */
    public void execute(Command cmd) {
        try {
            cmd.execute();
            executed.addLast(cmd);
            // ⚠️ Antes se hacía undone.clear(), ahora se mantiene
>>>>>>> c40613905afa72172cf579325da90ebf647682ad
        } catch (Exception e) {
            System.err.println("Error al ejecutar comando: " + e.getMessage());
        }
    }

    /**
     * Deshace el último comando ejecutado.
<<<<<<< HEAD
     * 
     * - Se extrae el último comando de la pila executed.
     * - Se llama a undo() para revertir la acción.
     * - Se guarda en la pila undone para poder rehacerlo más tarde.
     */
    public void undo() {
        if (!executed.isEmpty()) {
            Command cmd = executed.removeLast(); // Saca el último comando ejecutado.
            try {
                cmd.undo();                      // Revierte la acción (quita ficha).
                undone.addLast(cmd);             // Lo guarda en la pila de deshechos.
=======
     */
    public void undo() {
        if (!executed.isEmpty()) {
            Command cmd = executed.removeLast();
            try {
                cmd.undo();
                undone.addLast(cmd);
>>>>>>> c40613905afa72172cf579325da90ebf647682ad
            } catch (Exception e) {
                System.err.println("Error al deshacer comando: " + e.getMessage());
            }
        }
    }

    /**
     * Rehace el último comando deshecho.
<<<<<<< HEAD
     * 
     * - Se extrae el último comando de la pila undone.
     * - Se vuelve a ejecutar con execute().
     * - Se guarda otra vez en executed.
     */
    public void redo() {
        if (!undone.isEmpty()) {
            Command cmd = undone.removeLast();   // Saca el último comando deshecho.
            try {
                cmd.execute();                   // Vuelve a ejecutar la acción.
                executed.addLast(cmd);           // Lo guarda en la pila de ejecutados.
=======
     */
    public void redo() {
        if (!undone.isEmpty()) {
            Command cmd = undone.removeLast();
            try {
                cmd.execute();
                executed.addLast(cmd);
>>>>>>> c40613905afa72172cf579325da90ebf647682ad
            } catch (Exception e) {
                System.err.println("Error al rehacer comando: " + e.getMessage());
            }
        }
    }

    /**
     * Comprueba si hay comandos para deshacer.
<<<<<<< HEAD
     * @return true si la pila executed no está vacía.
=======
>>>>>>> c40613905afa72172cf579325da90ebf647682ad
     */
    public boolean canUndo() {
        return !executed.isEmpty();
    }

    /**
     * Comprueba si hay comandos para rehacer.
<<<<<<< HEAD
     * @return true si la pila undone no está vacía.
=======
>>>>>>> c40613905afa72172cf579325da90ebf647682ad
     */
    public boolean canRedo() {
        return !undone.isEmpty();
    }

    /**
     * Limpia todo el historial de comandos (undo/redo).
<<<<<<< HEAD
     * 
     * Se usa al iniciar una nueva partida para empezar desde cero.
=======
     * Se usa al iniciar una nueva partida para empezar fresco.
>>>>>>> c40613905afa72172cf579325da90ebf647682ad
     */
    public void clear() {
        executed.clear();
        undone.clear();
    }
}
