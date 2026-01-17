package com.mycompany.conecta4byivazquezv;

import com.mycompany.conecta4byivazquezv.controller.GameController; 
import com.mycompany.conecta4byivazquezv.controller.GameSetup;     
import com.mycompany.conecta4byivazquezv.model.Player;             

public class Conecta4byivazquezv {

    /**
     * Punto de entrada del programa.
     * Solo arranca el juego llamando a play().
     * @param args
     */
    public static void main(String[] args) {
        new Conecta4byivazquezv().play();
    }

    /**
     * Método que contiene la lógica principal para iniciar el juego.
     * Este es el método que debería usarse si alguien quiere ejecutar el juego
     * desde otra clase o desde tests.
     */
    public void play() {

        // 1. Configuramos los jugadores
        GameSetup setup = new GameSetup();
        Player[] players = setup.configurePlayers();

        // 2. Creamos el controlador del juego
        GameController controller = new GameController();

        // 3. Iniciamos la partida
        controller.start(players[0], players[1]);
    }
}
