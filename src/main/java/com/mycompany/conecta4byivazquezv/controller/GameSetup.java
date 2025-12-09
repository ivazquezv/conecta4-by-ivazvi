package com.mycompany.conecta4byivazquezv.controller;

import com.mycompany.conecta4byivazquezv.factory.PlayerFactory;
import com.mycompany.conecta4byivazquezv.model.Board;
import com.mycompany.conecta4byivazquezv.model.DiscColor;
import com.mycompany.conecta4byivazquezv.model.Player;

import java.util.Scanner;

public class GameSetup {

    private final Scanner sc = new Scanner(System.in);

    public Player[] configurePlayers() {
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

        int opcion = leerOpcion();

        return switch (opcion) {
            case 1 -> new Player[]{
                crearJugadorHumano(DiscColor.RED),
                crearJugadorHumano(DiscColor.YELLOW)
            };
            case 2 -> {
                int nivelIA = seleccionarNivelIA();
                yield new Player[]{
                    crearJugadorHumano(DiscColor.RED),
                    PlayerFactory.createAI("Bot Amarillo", DiscColor.YELLOW, nivelIA)
                };
            }
            case 3 -> {
                int nivelIA1 = seleccionarNivelIA("Rojo");
                int nivelIA2 = seleccionarNivelIA("Amarillo");
                yield new Player[]{
                    PlayerFactory.createAI("Bot Rojo", DiscColor.RED, nivelIA1),
                    PlayerFactory.createAI("Bot Amarillo", DiscColor.YELLOW, nivelIA2)
                };
            }
            default -> new Player[]{
                crearJugadorHumano(DiscColor.RED),
                crearJugadorHumano(DiscColor.YELLOW)
            };
        };
    }

    private int leerOpcion() {
        try {
            System.out.print("Opción: ");
            return Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Se usará Humano vs Humano por defecto.");
            return 1;
        }
    }

    private Player crearJugadorHumano(DiscColor color) {
        System.out.printf("Introduce el nombre para el jugador %s (%s): ",
                color == DiscColor.RED ? "Rojo" : "Amarillo", color);
        String nombre = sc.nextLine().trim();
        if (nombre.isEmpty()) {
            nombre = "Jugador " + (color == DiscColor.RED ? "Rojo" : "Amarillo");
        }
        return PlayerFactory.createHuman(nombre, color);
    }

    private int seleccionarNivelIA() {
        return seleccionarNivelIA("");
    }

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
