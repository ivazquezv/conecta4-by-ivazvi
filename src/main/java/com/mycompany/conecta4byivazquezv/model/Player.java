package com.mycompany.conecta4byivazquezv.model;

import com.mycompany.conecta4byivazquezv.ai.Strategy;

/**
 * Representa a un jugador en el juego Conecta4.
 * Cada jugador tiene un nombre, un color de ficha y puede ser humano o IA.
 * Si es IA, se le asigna una estrategia para decidir sus jugadas.
 */
public final class Player {
    // Nombre del jugador (ej. "Jugador 1", "Bot")
    private final String name;
    // Color de las fichas que utiliza (ROJO o AMARILLO)
    private final DiscColor color;
    // Indica si el jugador es controlado por la IA (true) o es humano (false)
    private final boolean ai;
    // Estrategia de IA asociada (solo se usa si ai == true)
    private final Strategy strategy;

    /**
     * Constructor para jugadores humanos (sin estrategia).
     * Si no se pasa nombre, se asigna uno por defecto según el color.
     * Ejemplo: "Jugador Rojo" o "Jugador Amarillo".
     *
     * @param name nombre del jugador
     * @param color color de las fichas asignadas
     */
    public Player(String name, DiscColor color) {
        this.name = (name == null || name.isBlank())
                ? (color == DiscColor.RED ? "Jugador Rojo" : "Jugador Amarillo")
                : name;
        this.color = color;
        this.ai = false;        // es humano
        this.strategy = null;   // no tiene estrategia de IA
    }

    /**
     * Constructor para jugadores IA (con estrategia).
     * Si no se pasa nombre, se asigna uno por defecto: "Bot Rojo" o "Bot Amarillo".
     *
     * @param name nombre del jugador
     * @param color color de las fichas asignadas
     * @param strategy estrategia de IA que utilizará
     */
    public Player(String name, DiscColor color, Strategy strategy) {
        this.name = (name == null || name.isBlank())
                ? "Bot " + (color == DiscColor.RED ? "Rojo" : "Amarillo")
                : name;
        this.color = color;
        this.ai = true;         // es IA
        this.strategy = strategy; // se le asigna una estrategia
    }

    /** Devuelve el nombre del jugador. */
    public String getName() { 
        return name; 
    }

    /** Devuelve el color de las fichas del jugador. */
    public DiscColor getColor() { 
        return color; 
    }

    /** Indica si el jugador es IA. */
    public boolean isAi() { 
        return ai; 
    }

    /** Devuelve la estrategia asociada al jugador IA (o null si es humano). */
    public Strategy getStrategy() {
        return strategy;
    }

    /**
     * Devuelve una representación lista para mostrar en la interfaz:
     * "Nombre (COLOR)".
     * Ejemplo: "Iván (RED)" o "Bot Amarillo (YELLOW)".
     */
    public String getDisplayName() {
        return name + " (" + color + ")";
    }
}
