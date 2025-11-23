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
    // Referencia al tablero donde se aplicará la jugada
    private final Board board;
    // Jugador que realiza la acción
    private final Player player;
    // Columna en la que se coloca la ficha
    private final int column;
    // Fila en la que se aplicó la jugada (se guarda para poder deshacer)
    private int rowApplied = -1;

    /**
     * Constructor del comando.
     * @param board tablero sobre el que se juega
     * @param player jugador que coloca la ficha
     * @param column columna elegida para la jugada
     */
    public DropDiscCommand(Board board, Player player, int column) {
        this.board = board;
        this.player = player;
        this.column = column;
    }

    /**
     * Ejecuta la acción de colocar una ficha en el tablero.
     * @return objeto Move que representa la jugada realizada
     */
    @Override
    public Move execute() {
        // Colocar la ficha en la columna indicada y guardar la fila resultante
        rowApplied = board.dropDisc(column, player.getColor());
        // Devolver un objeto Move con los datos de la jugada
        return new Move(player, column, rowApplied);
    }

    /**
     * Deshace la jugada realizada previamente.
     * Solo se ejecuta si existe una jugada aplicada (rowApplied >= 0).
     */
    @Override
    public void undo() {
        if (rowApplied >= 0) {
            // Eliminar la ficha de la columna correspondiente
            board.removeDisc(column);
            // Resetear rowApplied para evitar múltiples undo consecutivos
            rowApplied = -1;
        }
    }
}
