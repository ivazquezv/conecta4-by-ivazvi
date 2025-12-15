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

    // Profundidad máxima de búsqueda en el árbol de jugadas
    private final int maxDepth;
<<<<<<< HEAD
    // Motor de reglas que evalúa victorias, derrotas o empates
=======
    // Motor de reglas que evalúa si hay victoria, derrota o empate
>>>>>>> c40613905afa72172cf579325da90ebf647682ad
    private final RuleEngine rules = new RuleEngine();
    // Generador aleatorio para elegir entre jugadas con la misma puntuación
    private final Random random = new Random();

    // Constructor: recibe la profundidad máxima de búsqueda
    public MinimaxStrategy(int depth) {
        this.maxDepth = depth;
    }

    /**
     * Método principal que elige la columna donde la IA jugará.
     * Explora todas las columnas posibles y usa minimax para evaluarlas.
     */
    @Override
    public int chooseColumn(Board board, Player player) {
        List<Integer> bestMoves = new ArrayList<>(); // Lista de columnas candidatas
        int bestScore = Integer.MIN_VALUE;           // Mejor puntuación encontrada

        // Recorremos todas las columnas del tablero
        for (int column = 0; column < Board.COLS; column++) {
<<<<<<< HEAD
            if (!board.isColumnFull(column)) {       // Solo columnas no llenas
                board.dropDisc(column, player.getColor()); // Simula jugada de la IA
=======
            // Solo consideramos columnas que no estén llenas
            if (!board.isColumnFull(column)) {
                // Simulamos colocar la ficha del jugador en esa columna
                board.dropDisc(column, player.getColor());
>>>>>>> c40613905afa72172cf579325da90ebf647682ad

                // Evaluamos la jugada con minimax (profundidad reducida en 1)
                int score = minimax(board, maxDepth - 1, false, player.getColor());

<<<<<<< HEAD
                board.removeDisc(column);            // Deshacemos la jugada simulada

                // Actualizamos mejor jugada si la puntuación es superior
                if (score > bestScore) {
                    bestScore = score;
                    bestMoves.clear();               // Reiniciamos lista de mejores
                    bestMoves.add(column);           // Añadimos esta columna
                } else if (score == bestScore) {
                    bestMoves.add(column);           // Empate → añadimos también
=======
                // Deshacemos la jugada simulada
                board.removeDisc(column);

                // Si la puntuación es mejor que la actual, actualizamos
                if (score > bestScore) {
                    bestScore = score;
                    bestMoves.clear();      // Limpiamos lista de mejores jugadas
                    bestMoves.add(column);  // Añadimos esta columna como mejor
                } else if (score == bestScore) {
                    // Si la puntuación es igual, añadimos la columna como empate
                    bestMoves.add(column);
>>>>>>> c40613905afa72172cf579325da90ebf647682ad
                }
            }
        }

        // Elegimos aleatoriamente entre las mejores jugadas encontradas
        return bestMoves.get(random.nextInt(bestMoves.size()));
    }

    /**
     * Algoritmo recursivo Minimax.
     * Simula jugadas futuras alternando entre la IA (maximizing) y el oponente (minimizing).
     */
    private int minimax(Board board, int depth, boolean maximizing, DiscColor aiColor) {
        // Evaluamos si el tablero está en estado de victoria/derrota
        GameResult result = rules.evaluate(board, aiColor, 0, 0);

        if (result == GameResult.RED_WINS || result == GameResult.YELLOW_WINS) {
            if (result == (aiColor == DiscColor.RED ? GameResult.RED_WINS : GameResult.YELLOW_WINS)) {
                // Si la IA gana → cuanto antes mejor (valor alto)
                return 100 - (maxDepth - depth);
            } else {
                // Si la IA pierde → cuanto más tarde mejor (valor bajo)
                return -100 + (maxDepth - depth);
            }
        }

<<<<<<< HEAD
        // Si llegamos a la profundidad máxima o el tablero está lleno → evaluación heurística
=======
        // Si llegamos a la profundidad máxima o el tablero está lleno, evaluamos heurísticamente
>>>>>>> c40613905afa72172cf579325da90ebf647682ad
        if (depth == 0 || isBoardFull(board)) {
            return evaluateBoard(board, aiColor);
        }

        // Inicializamos el mejor valor según si maximizamos o minimizamos
        int bestValue = maximizing ? Integer.MIN_VALUE : Integer.MAX_VALUE;
<<<<<<< HEAD
        // Determinamos de quién es el turno
=======
        // Determinamos de quién es el turno (IA u oponente)
>>>>>>> c40613905afa72172cf579325da90ebf647682ad
        DiscColor currentColor = maximizing ? aiColor : getOpponent(aiColor);

        // Recorremos todas las columnas posibles
        for (int column = 0; column < Board.COLS; column++) {
            if (!board.isColumnFull(column)) {
<<<<<<< HEAD
                board.dropDisc(column, currentColor); // Simula jugada

                int eval = minimax(board, depth - 1, !maximizing, aiColor); // Llamada recursiva

                board.removeDisc(column);             // Revierte jugada
=======
                // Simulamos colocar ficha
                board.dropDisc(column, currentColor);

                // Llamada recursiva alternando maximizing/minimizing
                int eval = minimax(board, depth - 1, !maximizing, aiColor);

                // Deshacemos jugada
                board.removeDisc(column);
>>>>>>> c40613905afa72172cf579325da90ebf647682ad

                // Actualizamos mejor valor según si maximizamos o minimizamos
                bestValue = maximizing ? Math.max(bestValue, eval) : Math.min(bestValue, eval);
            }
        }
        return bestValue;
    }

    // Devuelve el color del oponente
    private DiscColor getOpponent(DiscColor color) {
        return (color == DiscColor.RED) ? DiscColor.YELLOW : DiscColor.RED;
    }

    // Comprueba si el tablero está lleno
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
        var grid = board.getGrid(); // Obtenemos la matriz de celdas

        // Recorremos todas las filas y columnas
        for (int row = 0; row < Board.ROWS; row++) {
            for (int column = 0; column < Board.COLS; column++) {
<<<<<<< HEAD
                if (grid[row][column].getColor() == aiColor) {
                    score += 1; // Cada ficha propia suma 1
=======
                // Si la celda pertenece a la IA, sumamos 1
                if (grid[row][column].getColor() == aiColor) {
                    score += 1;
>>>>>>> c40613905afa72172cf579325da90ebf647682ad
                }
            }
        }

        // Evaluamos pares horizontales
        for (int row = 0; row < Board.ROWS; row++) {
            for (int column = 0; column < Board.COLS - 1; column++) {
                if (grid[row][column].getColor() == aiColor &&
                    grid[row][column + 1].getColor() == aiColor) {
<<<<<<< HEAD
                    score += 2; // Dos fichas consecutivas horizontales suman 2
=======
                    score += 2;
>>>>>>> c40613905afa72172cf579325da90ebf647682ad
                }
            }
        }

        // Evaluamos pares verticales
        for (int column = 0; column < Board.COLS; column++) {
            for (int row = 0; row < Board.ROWS - 1; row++) {
                if (grid[row][column].getColor() == aiColor &&
                    grid[row + 1][column].getColor() == aiColor) {
<<<<<<< HEAD
                    score += 2; // Dos fichas consecutivas verticales suman 2
=======
                    score += 2;
>>>>>>> c40613905afa72172cf579325da90ebf647682ad
                }
            }
        }

        return score; // Devolvemos la puntuación total
    }
}
