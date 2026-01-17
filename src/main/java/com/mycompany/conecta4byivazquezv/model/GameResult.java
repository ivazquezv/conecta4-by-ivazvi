package com.mycompany.conecta4byivazquezv.model;

/**
 * Posibles resultados de una partida de Conecta4.
 */
public enum GameResult {
    IN_PROGRESS,   // La partida sigue en curso
    DRAW,          // Tablero lleno sin ganador
    RED_WINS,      // Gana el jugador rojo
    YELLOW_WINS    // Gana el jugador amarillo
}
