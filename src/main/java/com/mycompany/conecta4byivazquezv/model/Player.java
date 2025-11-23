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
     * @param name nombre del jugador
     * @param color color de las fichas asignadas
     */
    public Player(String name, DiscColor color) {
        this.name = name;
        this.color = color;
        this.ai = false;
        this.strategy = null;
    }

    /**
     * Constructor para jugadores IA (con estrategia).
     * @param name nombre del jugador
     * @param color color de las fichas asignadas
     * @param strategy estrategia de IA que utilizará
     */
    public Player(String name, DiscColor color, Strategy strategy) {
        this.name = name;
        this.color = color;
        this.ai = true;
        this.strategy = strategy;
    }

    /**
     * Devuelve el nombre del jugador.
     * @return nombre
     */
    public String getName() { 
        return name; 
    }

    /**
     * Devuelve el color de las fichas del jugador.
     * @return color (DiscColor)
     */
    public DiscColor getColor() { 
        return color; 
    }

    /**
     * Indica si el jugador es IA.
     * @return true si es IA, false si es humano
     */
    public boolean isAi() { 
        return ai; 
    }

    /**
     * Devuelve la estrategia asociada al jugador IA.
     * Si el jugador es humano, devuelve null.
     * @return estrategia de IA o null si es humano
     */
    public Strategy getStrategy() {
        return strategy;
    }
}
