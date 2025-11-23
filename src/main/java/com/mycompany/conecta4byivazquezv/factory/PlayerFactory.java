package com.mycompany.conecta4byivazquezv.factory;

import com.mycompany.conecta4byivazquezv.model.DiscColor;
import com.mycompany.conecta4byivazquezv.model.Player;
import com.mycompany.conecta4byivazquezv.ai.Strategy;
import com.mycompany.conecta4byivazquezv.ai.MinimaxStrategy;
import com.mycompany.conecta4byivazquezv.ai.RandomStrategy;

/**
 * Fábrica para crear instancias de Player.
 * Permite encapsular la lógica de inicialización de jugadores humanos o IA.
 */
public final class PlayerFactory {

    private PlayerFactory() {
        // Evita instanciación
    }

    /**
     * Crea un jugador humano.
     *
     * @param name nombre del jugador
     * @param color color de la ficha
     * @return instancia de Player humano
     */
    public static Player createHuman(String name, DiscColor color) {
        return new Player(name, color); // constructor humano
    }

    /**
     * Crea un jugador controlado por IA con estrategia Minimax por defecto.
     *
     * @param name nombre del jugador IA
     * @param color color de la ficha
     * @return instancia de Player IA con estrategia Minimax
     */
    public static Player createAI(String name, DiscColor color) {
        Strategy strategy = new MinimaxStrategy(4); // profundidad configurable
        return new Player(name, color, strategy);
    }

    /**
     * Crea un jugador IA con estrategia específica.
     *
     * @param name nombre del jugador IA
     * @param color color de la ficha
     * @param strategy estrategia de IA a utilizar
     * @return instancia de Player IA con la estrategia indicada
     */
    public static Player createAI(String name, DiscColor color, Strategy strategy) {
        return new Player(name, color, strategy);
    }

    /**
     * Crea un jugador IA con estrategia aleatoria (RandomStrategy).
     *
     * @param name nombre del jugador IA
     * @param color color de la ficha
     * @return instancia de Player IA con estrategia aleatoria
     */
    public static Player createRandomAI(String name, DiscColor color) {
        Strategy strategy = new RandomStrategy();
        return new Player(name, color, strategy);
    }
}
