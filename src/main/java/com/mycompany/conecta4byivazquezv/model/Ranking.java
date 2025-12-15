package com.mycompany.conecta4byivazquezv.model;

import java.util.*;
<<<<<<< HEAD
import java.util.stream.Collectors; //API de Streams de Java para procesar colecciones, y en concreto para agrupar y contar elementos.
=======
import java.util.stream.Collectors;
>>>>>>> c40613905afa72172cf579325da90ebf647682ad

/**
 * Ranking acumulado de partidas de Conecta4.
 * Permite mostrar resultados ordenados por tiempo o por número de victorias.
 */
public class Ranking {
<<<<<<< HEAD
    // Lista que almacena los resultados de todas las partidas jugadas
=======
>>>>>>> c40613905afa72172cf579325da90ebf647682ad
    private final List<MatchResult> results = new ArrayList<>();

    /**
     * Añade un resultado al ranking.
<<<<<<< HEAD
     * @param result resultado de una partida (ganador, color, duración)
=======
>>>>>>> c40613905afa72172cf579325da90ebf647682ad
     */
    public void addResult(MatchResult result) {
        results.add(result);
    }

    /**
     * Muestra el ranking ordenado por la partida más rápida.
<<<<<<< HEAD
     * Se ordena la lista de resultados por duración (menor a mayor).
=======
>>>>>>> c40613905afa72172cf579325da90ebf647682ad
     */
    public void printByFastest() {
        System.out.println();
        System.out.println("=== Ranking por partida más rápida ===");
        results.stream()
<<<<<<< HEAD
               // Ordenamos por duración en milisegundos con .sorted
               .sorted(Comparator.comparingLong(MatchResult::getDurationMillis))
               // Mostramos cada resultado usando su toString()
=======
               .sorted(Comparator.comparingLong(MatchResult::getDurationMillis))
>>>>>>> c40613905afa72172cf579325da90ebf647682ad
               .forEach(r -> System.out.println(r));
    }

    /**
     * Muestra el ranking por número de victorias acumuladas.
<<<<<<< HEAD
     * Agrupa los resultados por nombre del ganador y cuenta cuántas veces aparece.
=======
>>>>>>> c40613905afa72172cf579325da90ebf647682ad
     */
    public void printByWins() {
        System.out.println();
        System.out.println("=== Ranking por número de victorias ===");
<<<<<<< HEAD

        // Agrupamos por nombre del ganador y contamos cuántas victorias tiene cada uno
        //Collector transforma un Stream en una colección o mapa o estructura asi reresento los resutlados
        Map<String, Long> wins = results.stream()
                .collect(Collectors.groupingBy(MatchResult::getWinnerName, Collectors.counting()));

        // Ordenamos de mayor a menor número de victorias y mostramos
=======
        Map<String, Long> wins = results.stream()
                .collect(Collectors.groupingBy(MatchResult::getWinnerName, Collectors.counting()));

>>>>>>> c40613905afa72172cf579325da90ebf647682ad
        wins.entrySet().stream()
            .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
            .forEach(e -> System.out.println(e.getKey() + " - " + e.getValue() + " victorias"));
    }
}
<<<<<<< HEAD
=======

>>>>>>> c40613905afa72172cf579325da90ebf647682ad
