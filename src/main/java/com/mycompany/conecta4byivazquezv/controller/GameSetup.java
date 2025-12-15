package com.mycompany.conecta4byivazquezv.controller;

import com.mycompany.conecta4byivazquezv.factory.PlayerFactory;
import com.mycompany.conecta4byivazquezv.model.Board;
import com.mycompany.conecta4byivazquezv.model.DiscColor;
import com.mycompany.conecta4byivazquezv.model.Player;

import java.util.Scanner;

public class GameSetup {

    // Scanner para leer entradas desde la consola
    private final Scanner sc = new Scanner(System.in);

    /**
     * Configura los jugadores según el modo de juego elegido.
     * Devuelve un array con los dos jugadores (p1 y p2).
     */
    public Player[] configurePlayers() {
        // Mensajes iniciales de bienvenida e instrucciones
        System.out.println();
        System.out.println("=== Bienvenido a Conecta4 ===");
        System.out.println("Instrucciones iniciales:");
        System.out.println("- Introduce tu nombre cuando se te pida.");
        System.out.println("- Para jugar, escribe un número entre 0 y " + (Board.COLS - 1) + " (columna).");
        System.out.println("- Controles extra: 'u' para deshacer (undo), 'r' para rehacer (redo).");
        System.out.println();
        System.out.println("Selecciona modo de juego:");
        System.out.println("1. Humano vs Humano");
        System.out.println("2. Humano vs IA");
        System.out.println("3. IA vs IA");

        // Leer opción elegida por el usuario
        int opcion = leerOpcion();

        // Según la opción, se crean los jugadores adecuados
        return switch (opcion) {
            case 1 -> new Player[]{
                crearJugadorHumano(DiscColor.RED),      // Jugador humano rojo
                crearJugadorHumano(DiscColor.YELLOW)    // Jugador humano amarillo
            };
            case 2 -> {
                int nivelIA = seleccionarNivelIA();     // Selección de nivel IA
                yield new Player[]{
                    crearJugadorHumano(DiscColor.RED),  // Humano rojo
                    PlayerFactory.createAI("Bot Amarillo", DiscColor.YELLOW, nivelIA) // IA amarillo
                };
            }
            case 3 -> {
                int nivelIA1 = seleccionarNivelIA("Rojo");     // Nivel IA para jugador rojo
                int nivelIA2 = seleccionarNivelIA("Amarillo"); // Nivel IA para jugador amarillo
                yield new Player[]{
                    PlayerFactory.createAI("Bot Rojo", DiscColor.RED, nivelIA1),
                    PlayerFactory.createAI("Bot Amarillo", DiscColor.YELLOW, nivelIA2)
                };
            }
            // Si la entrada es inválida, por defecto Humano vs Humano
            default -> new Player[]{
                crearJugadorHumano(DiscColor.RED),
                crearJugadorHumano(DiscColor.YELLOW)
            };
        };
    }

    /**
     * Lee la opción de modo de juego desde consola.
     * Si la entrada no es válida, devuelve 1 (Humano vs Humano).
     */
    private int leerOpcion() {
        try {
            System.out.print("Opción: ");
            return Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Se usará Humano vs Humano por defecto.");
            return 1;
        }
    }

    /**
     * Crea un jugador humano pidiendo su nombre por consola.
     * Si no se introduce nada, se asigna un nombre por defecto.
     */
    private Player crearJugadorHumano(DiscColor color) {
        System.out.printf("Introduce el nombre para el jugador %s (%s): ",
                color == DiscColor.RED ? "Rojo" : "Amarillo", color);
        String nombre = sc.nextLine().trim();
        if (nombre.isEmpty()) {
            nombre = "Jugador " + (color == DiscColor.RED ? "Rojo" : "Amarillo");
        }
        return PlayerFactory.createHuman(nombre, color);
    }

    /**
     * Selecciona el nivel de dificultad de la IA.
     * Sobrecarga sin etiqueta (para un solo jugador IA).
     */
    private int seleccionarNivelIA() {
        return seleccionarNivelIA("");
    }

    /**
     * Selecciona el nivel de dificultad de la IA con etiqueta (Rojo/Amarillo).
     * Niveles disponibles:
     * 1. Fácil (Random)
     * 2. Medio (Heurístico)
     * 3. Difícil (Minimax)
     */
    private int seleccionarNivelIA(String etiqueta) {
        System.out.println("Selecciona nivel de IA " + (etiqueta.isEmpty() ? "" : "(" + etiqueta + ")") + ":");
        System.out.println("1. Fácil (Random)");
        System.out.println("2. Medio (Heurístico)");
        System.out.println("3. Difícil (Minimax)");
        try {
            System.out.print("Nivel: ");
            int nivel = Integer.parseInt(sc.nextLine().trim());
            if (nivel < 1 || nivel > 3) {
                System.out.println("Nivel inválido. Se usará nivel Fácil por defecto.");
                return 1;
            }
            return nivel;
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Se usará nivel Fácil por defecto.");
            return 1;
        }
    }
}
