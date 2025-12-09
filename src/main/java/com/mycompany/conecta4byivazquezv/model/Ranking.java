package com.mycompany.conecta4byivazquezv.model;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Ranking acumulado de partidas de Conecta4.
 * Permite mostrar resultados ordenados por tiempo o por número de victorias.
 */
public class Ranking {
    private final List<MatchResult> results = new ArrayList<>();

    /**
     * Añade un resultado al ranking.
     */
    public void addResult(MatchResult result) {
        results.add(result);
    }

    /**
     * Muestra el ranking ordenado por la partida más rápida.
     */
    public void printByFastest() {
        System.out.println();
        System.out.println("=== Ranking por partida más rápida ===");
        results.stream()
               .sorted(Comparator.comparingLong(MatchResult::getDurationMillis))
               .forEach(r -> System.out.println(r));
    }

    /**
     * Muestra el ranking por número de victorias acumuladas.
     */
    public void printByWins() {
        System.out.println();
        System.out.println("=== Ranking por número de victorias ===");
        Map<String, Long> wins = results.stream()
                .collect(Collectors.groupingBy(MatchResult::getWinnerName, Collectors.counting()));

        wins.entrySet().stream()
            .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
            .forEach(e -> System.out.println(e.getKey() + " - " + e.getValue() + " victorias"));
    }
}

