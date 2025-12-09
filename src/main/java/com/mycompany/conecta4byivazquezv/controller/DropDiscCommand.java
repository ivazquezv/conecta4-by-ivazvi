package com.mycompany.conecta4byivazquezv.controller;

import com.mycompany.conecta4byivazquezv.model.Board;
import com.mycompany.conecta4byivazquezv.model.Player;
import com.mycompany.conecta4byivazquezv.model.Move;

/**
 * Comando concreto que representa la acción de colocar una ficha en el tablero.
 * Forma parte del patrón Command, lo que permite encapsular la acción
 * y ofrecer la posibilidad de deshacerla (undo).
 */
public final class DropDiscCommand implements Command {
    private final Board board;   // Tablero donde se aplica la jugada
    private final Player player; // Jugador que realiza la acción
    private final int column;    // Columna elegida
    private int rowApplied = -1; // Fila donde cayó la ficha
    private Move move;           // Jugada creada

    public DropDiscCommand(Board board, Player player, int column) {
        this.board = board;
        this.player = player;
        this.column = column;
    }

    @Override
    public Move execute() {
        rowApplied = board.dropDisc(column, player.getColor());
        if (rowApplied < 0) {
            throw new IllegalStateException("No se pudo colocar ficha en columna " + column);
        }
        move = new Move(player, column, rowApplied);
        return move;
    }

    @Override
    public void undo() {
        if (rowApplied >= 0) {
            // Eliminar exactamente la ficha que se colocó
            board.removeDisc(column);
            rowApplied = -1;
            move = null;
        }
    }

    public Move getMove() {
        return move;
    }
}
