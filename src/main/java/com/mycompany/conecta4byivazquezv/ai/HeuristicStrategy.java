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

    // Motor de reglas para evaluar victorias/empates
    private final RuleEngine rules = new RuleEngine();
    // Generador de números aleatorios para decisiones no críticas
    private final Random random = new Random();

    @Override
    public int chooseColumn(Board board, Player player) {
        DiscColor aiColor = player.getColor();          // Color de la IA
        DiscColor opponentColor = getOpponent(aiColor); // Color del oponente

        // 1. Buscar jugada ganadora inmediata
        for (int column = 0; column < Board.COLS; column++) {
            if (!board.isColumnFull(column)) {                  // Solo probar columnas no llenas
                board.dropDisc(column, aiColor);                // Simula colocar ficha de la IA
                if (rules.evaluate(board, aiColor, 0, 0) ==     // Evalúa si esa jugada gana
                        (aiColor == DiscColor.RED ? GameResult.RED_WINS : GameResult.YELLOW_WINS)) {
                    board.removeDisc(column);                   // Revierte simulación
                    return column;                              // Devuelve jugada ganadora inmediata
                }
                board.removeDisc(column);                       // Revierte simulación si no gana
            }
        }

        // 2. Bloquear jugada ganadora del oponente
        for (int column = 0; column < Board.COLS; column++) {
            if (!board.isColumnFull(column)) {
                board.dropDisc(column, opponentColor);          // Simula jugada del rival
                if (rules.evaluate(board, opponentColor, 0, 0) ==
                        (opponentColor == DiscColor.RED ? GameResult.RED_WINS : GameResult.YELLOW_WINS)) {
                    board.removeDisc(column);                   // Revierte simulación
                    return column;                              // Bloquea jugada ganadora del rival
                }
                board.removeDisc(column);
            }
        }

        // 3. Priorizar columnas centrales
        int centerColumn = Board.COLS / 2;                      // Columna central
        if (!board.isColumnFull(centerColumn)) {
            return centerColumn;                                // Jugar en el centro si está libre
        }

        // Buscar columnas cercanas al centro
        List<Integer> nearCenter = new ArrayList<>();
        for (int offset = 1; offset <= Board.COLS / 2; offset++) {
            int left = centerColumn - offset;                   // Columna a la izquierda del centro
            int right = centerColumn + offset;                  // Columna a la derecha del centro
            if (left >= 0 && !board.isColumnFull(left)) nearCenter.add(left);
            if (right < Board.COLS && !board.isColumnFull(right)) nearCenter.add(right);
        }
        if (!nearCenter.isEmpty()) {
            // Elige aleatoriamente entre las columnas cercanas al centro
            return nearCenter.get(random.nextInt(nearCenter.size()));
        }

        // 4. Si no hay nada crítico, elegir aleatoriamente entre las válidas
        List<Integer> validColumns = new ArrayList<>();
        for (int column = 0; column < Board.COLS; column++) {
            if (!board.isColumnFull(column)) {
                validColumns.add(column);                       // Añade columnas válidas
            }
        }
        if (validColumns.isEmpty()) {
            return Strategy.NO_MOVE;                            // Tablero lleno → no hay jugada
        }
        // Elige aleatoriamente una columna válida
        return validColumns.get(random.nextInt(validColumns.size()));
    }

    /**
     * Devuelve el color del oponente según el color de la IA.
     */
    private DiscColor getOpponent(DiscColor color) {
        return (color == DiscColor.RED) ? DiscColor.YELLOW : DiscColor.RED;
    }
}
