package com.mycompany.conecta4byivazquezv.ai;

import com.mycompany.conecta4byivazquezv.model.Board;
import com.mycompany.conecta4byivazquezv.model.Player;
import com.mycompany.conecta4byivazquezv.model.DiscColor;
import com.mycompany.conecta4byivazquezv.model.GameResult;
import com.mycompany.conecta4byivazquezv.rules.RuleEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Estrategia avanzada de IA basada en heurísticas rápidas:
 * 1. Jugar para ganar inmediatamente.
 * 2. Bloquear al oponente si puede ganar en la siguiente jugada.
 * 3. Priorizar columnas centrales.
 * 4. Si no hay nada crítico, elegir aleatoriamente.
 */
public final class HeuristicStrategy implements Strategy {

    private final RuleEngine rules = new RuleEngine();
    private final Random random = new Random();

    @Override
    public int chooseColumn(Board board, Player player) {
        DiscColor aiColor = player.getColor();
        DiscColor opponentColor = getOpponent(aiColor);

        // 1. Buscar jugada ganadora inmediata
        for (int column = 0; column < Board.COLS; column++) {
            if (!board.isColumnFull(column)) {
                board.dropDisc(column, aiColor);
                if (rules.evaluate(board, aiColor, 0, 0) ==
                        (aiColor == DiscColor.RED ? GameResult.RED_WINS : GameResult.YELLOW_WINS)) {
                    board.removeDisc(column);
                    return column; // jugada ganadora inmediata
                }
                board.removeDisc(column);
            }
        }

        // 2. Bloquear jugada ganadora del oponente
        for (int column = 0; column < Board.COLS; column++) {
            if (!board.isColumnFull(column)) {
                board.dropDisc(column, opponentColor);
                if (rules.evaluate(board, opponentColor, 0, 0) ==
                        (opponentColor == DiscColor.RED ? GameResult.RED_WINS : GameResult.YELLOW_WINS)) {
                    board.removeDisc(column);
                    return column; // bloquear al oponente
                }
                board.removeDisc(column);
            }
        }

        // 3. Priorizar columnas centrales
        int centerColumn = Board.COLS / 2;
        if (!board.isColumnFull(centerColumn)) {
            return centerColumn;
        }

        // Buscar columnas cercanas al centro
        List<Integer> nearCenter = new ArrayList<>();
        for (int offset = 1; offset <= Board.COLS / 2; offset++) {
            int left = centerColumn - offset;
            int right = centerColumn + offset;
            if (left >= 0 && !board.isColumnFull(left)) nearCenter.add(left);
            if (right < Board.COLS && !board.isColumnFull(right)) nearCenter.add(right);
        }
        if (!nearCenter.isEmpty()) {
            return nearCenter.get(random.nextInt(nearCenter.size()));
        }

        // 4. Si no hay nada, elegir aleatoriamente entre las válidas
        List<Integer> validColumns = new ArrayList<>();
        for (int column = 0; column < Board.COLS; column++) {
            if (!board.isColumnFull(column)) {
                validColumns.add(column);
            }
        }
        if (validColumns.isEmpty()) {
            return Strategy.NO_MOVE; // tablero lleno
        }
        return validColumns.get(random.nextInt(validColumns.size()));
    }

    private DiscColor getOpponent(DiscColor color) {
        return (color == DiscColor.RED) ? DiscColor.YELLOW : DiscColor.RED;
    }
}

