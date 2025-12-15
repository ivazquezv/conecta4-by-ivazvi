package com.mycompany.conecta4byivazquezv.model;

/**
 * Enumeración que representa los posibles resultados de una partida de Conecta4.
 * Se utiliza para controlar el estado del juego en cada momento.
 */
public enum GameResult {
    /**
     * La partida sigue en curso, aún no hay ganador ni empate.
     * Se devuelve cuando tras la última jugada no se detecta condición de victoria ni tablero lleno.
     */
    IN_PROGRESS,

    /**
     * La partida terminó en empate (tablero lleno sin ganador).
     * Se devuelve cuando el tablero está completo y ninguna regla detecta victoria.
     */
    DRAW,

    /**
     * El jugador con fichas rojas ha ganado la partida.
     * Se devuelve cuando alguna regla detecta 4 en línea de color rojo.
     */
    RED_WINS,

    /**
     * El jugador con fichas amarillas ha ganado la partida.
     * Se devuelve cuando alguna regla detecta 4 en línea de color amarillo.
     */
    YELLOW_WINS
}
