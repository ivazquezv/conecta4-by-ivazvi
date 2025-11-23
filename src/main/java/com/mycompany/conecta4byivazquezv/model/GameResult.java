package com.mycompany.conecta4byivazquezv.model;

/**
 * Enumeración que representa los posibles resultados de una partida de Conecta4.
 * Se utiliza para controlar el estado del juego en cada momento.
 */
public enum GameResult {
    /**
     * La partida sigue en curso, aún no hay ganador ni empate.
     */
    IN_PROGRESS,

    /**
     * La partida terminó en empate (tablero lleno sin ganador).
     */
    DRAW,

    /**
     * El jugador con fichas rojas ha ganado la partida.
     */
    RED_WINS,

    /**
     * El jugador con fichas amarillas ha ganado la partida.
     */
    YELLOW_WINS
}
