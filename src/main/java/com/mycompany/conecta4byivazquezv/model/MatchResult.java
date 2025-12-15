package com.mycompany.conecta4byivazquezv.model;

/**
 * Representa el resultado de una partida de Conecta4.
<<<<<<< HEAD
 * Incluye el nombre del ganador, el color de sus fichas y la duración de la partida.
 */
public class MatchResult {
    // Nombre del jugador que ganó la partida
    private final String winnerName;

    // Color de las fichas del ganador (RED o YELLOW)
    private final DiscColor winnerColor;

    // Duración total de la partida en milisegundos
    private final long durationMillis;

    /**
     * Constructor: inicializa el resultado con los datos del ganador y la duración.
     *
     * @param winnerName nombre del jugador ganador
     * @param winnerColor color de las fichas del ganador
     * @param durationMillis duración de la partida en milisegundos
     */
=======
 * Incluye el ganador y la duración de la partida en milisegundos.
 */
public class MatchResult {
    private final String winnerName;
    private final DiscColor winnerColor;
    private final long durationMillis;

>>>>>>> c40613905afa72172cf579325da90ebf647682ad
    public MatchResult(String winnerName, DiscColor winnerColor, long durationMillis) {
        this.winnerName = winnerName;
        this.winnerColor = winnerColor;
        this.durationMillis = durationMillis;
    }

<<<<<<< HEAD
    /**
     * Devuelve el nombre del jugador ganador.
     */
=======
>>>>>>> c40613905afa72172cf579325da90ebf647682ad
    public String getWinnerName() {
        return winnerName;
    }

<<<<<<< HEAD
    /**
     * Devuelve el color de las fichas del ganador.
     */
=======
>>>>>>> c40613905afa72172cf579325da90ebf647682ad
    public DiscColor getWinnerColor() {
        return winnerColor;
    }

<<<<<<< HEAD
    /**
     * Devuelve la duración de la partida en milisegundos.
     */
=======
>>>>>>> c40613905afa72172cf579325da90ebf647682ad
    public long getDurationMillis() {
        return durationMillis;
    }

<<<<<<< HEAD
    /**
     * Representación en texto del resultado.
     * Convierte la duración a minutos y segundos para mostrarla de forma legible.
     * Ejemplo: "Iván (RED) - 5 min 32 s"
     */
    @Override
    public String toString() {
        long totalSeconds = durationMillis / 1000; // convertimos a segundos
        long minutes = totalSeconds / 60;          // minutos completos
        long seconds = totalSeconds % 60;          // segundos restantes

        return winnerName + " (" + winnerColor + ") - "
               + minutes + " min " + seconds + " s";
    }
}
=======
@Override
public String toString() {
    long totalSeconds = durationMillis / 1000;
    long minutes = totalSeconds / 60;
    long seconds = totalSeconds % 60;

    return winnerName + " (" + winnerColor + ") - " 
           + minutes + " min " + seconds + " s";
}

}

>>>>>>> c40613905afa72172cf579325da90ebf647682ad
