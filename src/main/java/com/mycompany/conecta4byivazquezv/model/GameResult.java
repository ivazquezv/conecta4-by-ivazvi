package com.mycompany.conecta4byivazquezv.model;

/**
 * Enumeración que representa los posibles resultados de una partida de Conecta4.
 * Se utiliza para controlar el estado del juego en cada momento.
 */
public enum GameResult {
    /**
     * La partida sigue en curso, aún no hay ganador ni empate.
<<<<<<< HEAD
     * Se devuelve cuando tras la última jugada no se detecta condición de victoria ni tablero lleno.
=======
>>>>>>> c40613905afa72172cf579325da90ebf647682ad
     */
    IN_PROGRESS,

    /**
     * La partida terminó en empate (tablero lleno sin ganador).
<<<<<<< HEAD
     * Se devuelve cuando el tablero está completo y ninguna regla detecta victoria.
=======
>>>>>>> c40613905afa72172cf579325da90ebf647682ad
     */
    DRAW,

    /**
     * El jugador con fichas rojas ha ganado la partida.
<<<<<<< HEAD
     * Se devuelve cuando alguna regla detecta 4 en línea de color rojo.
=======
>>>>>>> c40613905afa72172cf579325da90ebf647682ad
     */
    RED_WINS,

    /**
     * El jugador con fichas amarillas ha ganado la partida.
<<<<<<< HEAD
     * Se devuelve cuando alguna regla detecta 4 en línea de color amarillo.
=======
>>>>>>> c40613905afa72172cf579325da90ebf647682ad
     */
    YELLOW_WINS
}
