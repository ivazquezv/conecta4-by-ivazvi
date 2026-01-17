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
 * Estrategia de IA basada en el algoritmo Minimax.
 * Versión simplificada: sin constantes de puntuación,
 * usando valores directos en la evaluación.
 */
public final class MinimaxStrategy implements Strategy {

    private final int maxDepth;
    private final RuleEngine rules = new RuleEngine();
    private final Random random = new Random();

    public MinimaxStrategy(int depth) {
        this.maxDepth = depth;
    }

    @Override
    public int chooseColumn(Board board, Player player) {
        List<Integer> bestMoves = new ArrayList<>();
        int bestScore = Integer.MIN_VALUE;

        for (int column = 0; column < Board.COLS; column++) {

            if (!board.isColumnFull(column)) {

                board.dropDisc(column, player.getColor());

                int score = minimax(board, maxDepth - 1, false, player.getColor());

                board.removeDisc(column);

                if (score > bestScore) {
                    bestScore = score;
                    bestMoves.clear();
                    bestMoves.add(column);
                } else if (score == bestScore) {
                    bestMoves.add(column);
                }
            }
        }

        return bestMoves.get(random.nextInt(bestMoves.size()));
    }

    private int minimax(Board board, int depth, boolean maximizing, DiscColor aiColor) {

        GameResult result = rules.evaluate(board, aiColor, 0, 0);

        if (result == GameResult.RED_WINS || result == GameResult.YELLOW_WINS) {

            boolean aiWins = (result == GameResult.RED_WINS && aiColor == DiscColor.RED)
                          || (result == GameResult.YELLOW_WINS && aiColor == DiscColor.YELLOW);

            if (aiWins) {
                return 100 - (maxDepth - depth);
            } else {
                return -100 + (maxDepth - depth);
            }
        }

        if (depth == 0 || isBoardFull(board)) {
            return evaluateBoard(board, aiColor);
        }

        int bestValue = maximizing ? Integer.MIN_VALUE : Integer.MAX_VALUE;

        DiscColor currentColor = maximizing ? aiColor : getOpponent(aiColor);

        for (int column = 0; column < Board.COLS; column++) {
            if (!board.isColumnFull(column)) {

                board.dropDisc(column, currentColor);

                int eval = minimax(board, depth - 1, !maximizing, aiColor);

                board.removeDisc(column);

                bestValue = maximizing
                        ? Math.max(bestValue, eval)
                        : Math.min(bestValue, eval);
            }
        }

        return bestValue;
    }

    private DiscColor getOpponent(DiscColor color) {
        return (color == DiscColor.RED) ? DiscColor.YELLOW : DiscColor.RED;
    }

    private boolean isBoardFull(Board board) {
        for (int column = 0; column < Board.COLS; column++) {
            if (!board.isColumnFull(column)) return false;
        }
        return true;
    }

    /**
     * Evaluación heurística simplificada del tablero.
     * Cada ficha propia suma +1, pares consecutivos suman +2.
     */
    private int evaluateBoard(Board board, DiscColor aiColor) {
        int score = 0;

        // Fichas individuales
        for (int row = 0; row < Board.ROWS; row++) {
            for (int col = 0; col < Board.COLS; col++) {

                if (board.getCellColor(row, col) == aiColor) {
                    score += 1;
                }
            }
        }

        // Pares horizontales
        for (int row = 0; row < Board.ROWS; row++) {
            for (int col = 0; col < Board.COLS - 1; col++) {

                if (board.getCellColor(row, col) == aiColor &&
                    board.getCellColor(row, col + 1) == aiColor) {
                    score += 2;
                }
            }
        }

        // Pares verticales
        for (int col = 0; col < Board.COLS; col++) {
            for (int row = 0; row < Board.ROWS - 1; row++) {

                if (board.getCellColor(row, col) == aiColor &&
                    board.getCellColor(row + 1, col) == aiColor) {
                    score += 2;
                }
            }
        }

        return score;
    }
}
