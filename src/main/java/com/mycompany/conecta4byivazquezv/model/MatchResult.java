package com.mycompany.conecta4byivazquezv.model;

/**
 * Representa el resultado de una partida de Conecta4.
 * Incluye el ganador y la duración de la partida en milisegundos.
 */
public class MatchResult {
    private final String winnerName;
    private final DiscColor winnerColor;
    private final long durationMillis;

    public MatchResult(String winnerName, DiscColor winnerColor, long durationMillis) {
        this.winnerName = winnerName;
        this.winnerColor = winnerColor;
        this.durationMillis = durationMillis;
    }

    public String getWinnerName() {
        return winnerName;
    }

    public DiscColor getWinnerColor() {
        return winnerColor;
    }

    public long getDurationMillis() {
        return durationMillis;
    }

@Override
public String toString() {
    long totalSeconds = durationMillis / 1000;
    long minutes = totalSeconds / 60;
    long seconds = totalSeconds % 60;

    return winnerName + " (" + winnerColor + ") - " 
           + minutes + " min " + seconds + " s";
}

}

