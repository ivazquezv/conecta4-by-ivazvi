package com.mycompany.conecta4byivazquezv.controller;

// Importa las clases necesarias del modelo del juego
import com.mycompany.conecta4byivazquezv.model.Board;
import com.mycompany.conecta4byivazquezv.model.Player;
import com.mycompany.conecta4byivazquezv.model.Move;

/**
 * Comando concreto que representa la acción de colocar una ficha en el tablero.
 * Forma parte del patrón Command, lo que permite encapsular la acción
 * y ofrecer la posibilidad de deshacerla (undo).
 */
public final class DropDiscCommand implements Command {
    // Referencia al tablero donde se aplicará la jugada
    private final Board board;
    // Jugador que realiza la acción
    private final Player player;
    // Columna elegida por el jugador
    private final int column;
    // Fila donde finalmente cayó la ficha (se calcula al ejecutar)
    private int rowApplied = -1; //-1 india valor no asignado
    // Objeto Move que guarda la jugada realizada (jugador, columna, fila)
    private Move move;

    // Constructor: recibe el tablero, el jugador y la columna seleccionada
    public DropDiscCommand(Board board, Player player, int column) {
        this.board = board;     // Inicializa el tablero
        this.player = player;   // Inicializa el jugador
        this.column = column;   // Inicializa la columna elegida
    }

    @Override
    public Move execute() {
        // Intenta colocar la ficha en la columna indicada
        rowApplied = board.dropDisc(column, player.getColor());
        
        // Si no se pudo colocar (columna llena), lanza una excepción
        if (rowApplied < 0) {
            throw new IllegalStateException("No se pudo colocar ficha en columna " + column);
        }

        // Crea un objeto Move con la información de la jugada
        move = new Move(player, column, rowApplied);

        // Devuelve la jugada realizada
        return move;
    }

    @Override
    public void undo() {
        // Solo se puede deshacer si realmente se colocó una ficha
        if (rowApplied >= 0) {
            // Elimina la ficha de la columna (revierte la jugada)
            board.removeDisc(column);
            // Resetea la fila aplicada
            rowApplied = -1;
            // Borra la referencia al movimiento
            move = null;
        }
    }

    // Devuelve el objeto Move asociado a este comando
    public Move getMove() {
        return move;
    }
}
