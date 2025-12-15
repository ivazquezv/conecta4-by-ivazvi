package com.mycompany.conecta4byivazquezv.controller;

<<<<<<< HEAD
// Importa las clases necesarias del modelo del juego
=======
>>>>>>> c40613905afa72172cf579325da90ebf647682ad
import com.mycompany.conecta4byivazquezv.model.Board;
import com.mycompany.conecta4byivazquezv.model.Player;
import com.mycompany.conecta4byivazquezv.model.Move;

/**
 * Comando concreto que representa la acción de colocar una ficha en el tablero.
 * Forma parte del patrón Command, lo que permite encapsular la acción
 * y ofrecer la posibilidad de deshacerla (undo).
 */
public final class DropDiscCommand implements Command {
<<<<<<< HEAD
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
=======
    private final Board board;   // Tablero donde se aplica la jugada
    private final Player player; // Jugador que realiza la acción
    private final int column;    // Columna elegida
    private int rowApplied = -1; // Fila donde cayó la ficha
    private Move move;           // Jugada creada

    public DropDiscCommand(Board board, Player player, int column) {
        this.board = board;
        this.player = player;
        this.column = column;
>>>>>>> c40613905afa72172cf579325da90ebf647682ad
    }

    @Override
    public Move execute() {
<<<<<<< HEAD
        // Intenta colocar la ficha en la columna indicada
        rowApplied = board.dropDisc(column, player.getColor());
        
        // Si no se pudo colocar (columna llena), lanza una excepción
        if (rowApplied < 0) {
            throw new IllegalStateException("No se pudo colocar ficha en columna " + column);
        }

        // Crea un objeto Move con la información de la jugada
        move = new Move(player, column, rowApplied);

        // Devuelve la jugada realizada
=======
        rowApplied = board.dropDisc(column, player.getColor());
        if (rowApplied < 0) {
            throw new IllegalStateException("No se pudo colocar ficha en columna " + column);
        }
        move = new Move(player, column, rowApplied);
>>>>>>> c40613905afa72172cf579325da90ebf647682ad
        return move;
    }

    @Override
    public void undo() {
<<<<<<< HEAD
        // Solo se puede deshacer si realmente se colocó una ficha
        if (rowApplied >= 0) {
            // Elimina la ficha de la columna (revierte la jugada)
            board.removeDisc(column);
            // Resetea la fila aplicada
            rowApplied = -1;
            // Borra la referencia al movimiento
=======
        if (rowApplied >= 0) {
            // Eliminar exactamente la ficha que se colocó
            board.removeDisc(column);
            rowApplied = -1;
>>>>>>> c40613905afa72172cf579325da90ebf647682ad
            move = null;
        }
    }

<<<<<<< HEAD
    // Devuelve el objeto Move asociado a este comando
=======
>>>>>>> c40613905afa72172cf579325da90ebf647682ad
    public Move getMove() {
        return move;
    }
}
