package com.mycompany.conecta4byivazquezv.model;

import java.util.*;
import java.util.stream.Collectors; //API de Streams de Java para procesar colecciones, y en concreto para agrupar y contar elementos.

/**
 * Ranking acumulado de partidas de Conecta4.
 * Permite mostrar resultados ordenados por tiempo o por número de victorias.
 */
public class Ranking {
    // Lista que almacena los resultados de todas las partidas jugadas
    private final List<MatchResult> results = new ArrayList<>();

    /**
     * Añade un resultado al ranking.
     * @param result resultado de una partida (ganador, color, duración)
     */
    public void addResult(MatchResult result) {
        results.add(result);
    }

    /**
     * Muestra el ranking ordenado por la partida más rápida.
     * Se ordena la lista de resultados por duración (menor a mayor).
     */
    public void printByFastest() {
        System.out.println();
        System.out.println("=== Ranking por partida más rápida ===");
        results.stream()
               // Ordenamos por duración en milisegundos con .sorted
               .sorted(Comparator.comparingLong(MatchResult::getDurationMillis))
               // Mostramos cada resultado usando su toString()
               .forEach(r -> System.out.println(r));
    }

    /**
     * Muestra el ranking por número de victorias acumuladas.
     * Agrupa los resultados por nombre del ganador y cuenta cuántas veces aparece.
     */
    public void printByWins() {
        System.out.println();
        System.out.println("=== Ranking por número de victorias ===");

        // Agrupamos por nombre del ganador y contamos cuántas victorias tiene cada uno
        //Collector transforma un Stream en una colección o mapa o estructura asi reresento los resutlados
        Map<String, Long> wins = results.stream()
                .collect(Collectors.groupingBy(MatchResult::getWinnerName, Collectors.counting()));

        // Ordenamos de mayor a menor número de victorias y mostramos
        wins.entrySet().stream()
            .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
            .forEach(e -> System.out.println(e.getKey() + " - " + e.getValue() + " victorias"));
    }
}
