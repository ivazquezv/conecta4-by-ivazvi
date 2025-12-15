package com.mycompany.conecta4byivazquezv.model;

/**
 * Representa el resultado de una partida de Conecta4.
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
    public MatchResult(String winnerName, DiscColor winnerColor, long durationMillis) {
        this.winnerName = winnerName;
        this.winnerColor = winnerColor;
        this.durationMillis = durationMillis;
    }

    /**
     * Devuelve el nombre del jugador ganador.
     */
    public String getWinnerName() {
        return winnerName;
    }

    /**
     * Devuelve el color de las fichas del ganador.
     */
    public DiscColor getWinnerColor() {
        return winnerColor;
    }

    /**
     * Devuelve la duración de la partida en milisegundos.
     */
    public long getDurationMillis() {
        return durationMillis;
    }

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
