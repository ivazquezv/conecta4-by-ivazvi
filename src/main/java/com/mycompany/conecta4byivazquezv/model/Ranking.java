package com.mycompany.conecta4byivazquezv.model;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Ranking acumulado de partidas de Conecta4.
 * Permite obtener resultados ordenados por tiempo o por número de victorias.
 */
public class Ranking {

    private final List<MatchResult> results = new ArrayList<>();

    /**
     * Añade un resultado al ranking.
     * @param result
     */
    public void addResult(MatchResult result) {
        results.add(result);
    }

    /**
     * Devuelve los resultados ordenados por duración (más rápida primero).
     * @return 
     */
    public List<MatchResult> getByFastest() {
        return results.stream()
                .sorted(Comparator.comparingLong(MatchResult::getDurationMillis))
                .toList();
    }

    /**
     * Devuelve un mapa con el número de victorias por jugador.
     * Ordenado de mayor a menor número de victorias.
     * @return 
     */
    public List<Map.Entry<String, Long>> getWinsRanking() {
        Map<String, Long> wins = results.stream()
                .collect(Collectors.groupingBy(
                        MatchResult::getWinnerName,
                        Collectors.counting()
                ));

        return wins.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .toList();
    }
}
