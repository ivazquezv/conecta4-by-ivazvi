package com.mycompany.conecta4byivazquezv;

import com.mycompany.conecta4byivazquezv.controller.GameController; // Controla el flujo del juego
import com.mycompany.conecta4byivazquezv.controller.GameSetup;     // Configura los jugadores antes de empezar
import com.mycompany.conecta4byivazquezv.model.Player;             // Representa a cada jugador

public class Conecta4byivazquezv {

    public static void main(String[] args) {
          // 1. Creamos un objeto GameSetup para configurar los jugadores
        GameSetup setup = new GameSetup();
        
        // 2. Llamamos a configurePlayers() que devuelve un array con los dos jugadores listos
        Player[] players = setup.configurePlayers();

        // 3. Creamos el controlador del juego, encargado de gestionar la partida
        GameController controller = new GameController();
        
        // 4. Iniciamos el juego pasando los dos jugadores al controlador
        controller.start(players[0], players[1]);
    }
}
