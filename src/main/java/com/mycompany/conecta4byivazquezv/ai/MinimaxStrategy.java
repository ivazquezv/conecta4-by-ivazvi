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
 * Explora posibles jugadas hasta cierta profundidad y selecciona la mejor
 * en función de una evaluación heurística.
 * 
 * Ahora incluye aleatorización en caso de empate entre varias jugadas óptimas.
 */
public final class MinimaxStrategy implements Strategy {
    // Profundidad máxima de búsqueda en el árbol de jugadas
    private final int depth;
    // Motor de reglas para evaluar estados del tablero (victorias, etc.)
    private final RuleEngine rules = new RuleEngine();
    // Generador de aleatoriedad para romper empates
    private final Random random = new Random();

    /**
     * Constructor que recibe la profundidad de búsqueda.
     * @param depth número de niveles de jugadas a simular
     */
    public MinimaxStrategy(int depth) {
        this.depth = depth;
    }

    /**
     * Elige la mejor columna para jugar según el algoritmo minimax.
     * Si varias columnas tienen la misma puntuación, se elige una al azar.
     * 
     * @param board tablero actual
     * @param player jugador que realiza la jugada
     * @return índice de columna elegido
     */
    @Override
    public int chooseColumn(Board board, Player player) {
        List<Integer> bestMoves = new ArrayList<>();
        int bestScore = Integer.MIN_VALUE;

        // Iterar sobre todas las columnas posibles
        for (int c = 0; c < Board.COLS; c++) {
            if (!board.isColumnFull(c)) {
                // Simular jugada del jugador en la columna c
                board.dropDisc(c, player.getColor());
                // Evaluar resultado con minimax recursivo
                int score = minimax(board, depth - 1, false, player.getColor());
                // Deshacer jugada simulada
                board.removeDisc(c);

                // Actualizar lista de mejores jugadas
                if (score > bestScore) {
                    bestScore = score;
                    bestMoves.clear();
                    bestMoves.add(c);
                } else if (score == bestScore) {
                    bestMoves.add(c);
                }
            }
        }

        // Elegir aleatoriamente entre las mejores jugadas
        return bestMoves.get(random.nextInt(bestMoves.size()));
    }

    /**
     * Algoritmo recursivo Minimax.
     */
    private int minimax(Board board, int depth, boolean maximizing, DiscColor aiColor) {
        GameResult result = rules.evaluate(board, aiColor, 0, 0);
        if (result == GameResult.RED_WINS || result == GameResult.YELLOW_WINS) {
            return (result == (aiColor == DiscColor.RED ? GameResult.RED_WINS : GameResult.YELLOW_WINS)) ? 1000 : -1000;
        }
        if (depth == 0 || isBoardFull(board)) {
            return evaluateBoard(board, aiColor);
        }

        if (maximizing) {
            int maxEval = Integer.MIN_VALUE;
            for (int c = 0; c < Board.COLS; c++) {
                if (!board.isColumnFull(c)) {
                    board.dropDisc(c, aiColor);
                    int eval = minimax(board, depth - 1, false, aiColor);
                    board.removeDisc(c);
                    maxEval = Math.max(maxEval, eval);
                }
            }
            return maxEval;
        } else {
            int minEval = Integer.MAX_VALUE;
            DiscColor opponent = (aiColor == DiscColor.RED) ? DiscColor.YELLOW : DiscColor.RED;
            for (int c = 0; c < Board.COLS; c++) {
                if (!board.isColumnFull(c)) {
                    board.dropDisc(c, opponent);
                    int eval = minimax(board, depth - 1, true, aiColor);
                    board.removeDisc(c);
                    minEval = Math.min(minEval, eval);
                }
            }
            return minEval;
        }
    }

    private boolean isBoardFull(Board board) {
        for (int c = 0; c < Board.COLS; c++) {
            if (!board.isColumnFull(c)) return false;
        }
        return true;
    }

    private int evaluateBoard(Board board, DiscColor aiColor) {
        int score = 0;
        DiscColor[][] grid = new DiscColor[Board.ROWS][Board.COLS];
        for (int r = 0; r < Board.ROWS; r++) {
            for (int c = 0; c < Board.COLS; c++) {
                grid[r][c] = board.getGrid()[r][c].getColor();
                if (grid[r][c] == aiColor) {
                    score += 5;
                }
            }
        }

        // Evaluar alineaciones horizontales y verticales
        for (int r = 0; r < Board.ROWS; r++) {
            for (int c = 0; c < Board.COLS - 1; c++) {
                if (grid[r][c] == aiColor && grid[r][c + 1] == aiColor) score += 20;
            }
        }
        for (int c = 0; c < Board.COLS; c++) {
            for (int r = 0; r < Board.ROWS - 1; r++) {
                if (grid[r][c] == aiColor && grid[r + 1][c] == aiColor) score += 20;
            }
        }

        // Evaluar diagonales simples (tríos)
        for (int r = 0; r < Board.ROWS - 2; r++) {
            for (int c = 0; c < Board.COLS - 2; c++) {
                if (grid[r][c] == aiColor && grid[r + 1][c + 1] == aiColor && grid[r + 2][c + 2] == aiColor) score += 50;
                if (grid[r + 2][c] == aiColor && grid[r + 1][c + 1] == aiColor && grid[r][c + 2] == aiColor) score += 50;
            }
        }

        return score;
    }
}
