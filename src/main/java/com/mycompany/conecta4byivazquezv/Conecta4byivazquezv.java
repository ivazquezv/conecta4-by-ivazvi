package com.mycompany.conecta4byivazquezv;

import com.mycompany.conecta4byivazquezv.controller.GameController;
import com.mycompany.conecta4byivazquezv.model.DiscColor;
import com.mycompany.conecta4byivazquezv.model.Player;
import com.mycompany.conecta4byivazquezv.factory.PlayerFactory;

import java.util.Scanner;

/**
 * Clase principal del proyecto Conecta4.
 * Contiene el método main que arranca la aplicación en consola.
 */
public class Conecta4byivazquezv {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Bienvenido a Conecta4 ===");
        System.out.println("Selecciona modo de juego:");
        System.out.println("1. Humano vs Humano");
        System.out.println("2. Humano vs IA");
        System.out.println("3. IA vs IA (modo prueba)");

        int opcion;
        try {
            opcion = Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Se usará Humano vs Humano por defecto.");
            opcion = 1;
        }

        Player p1;
        Player p2;

        switch (opcion) {
            case 1 -> {
                p1 = PlayerFactory.createHuman("Jugador 1", DiscColor.RED);
                p2 = PlayerFactory.createHuman("Jugador 2", DiscColor.YELLOW);
            }
            case 2 -> {
                p1 = PlayerFactory.createHuman("Jugador 1", DiscColor.RED);
                p2 = PlayerFactory.createAI("Bot Minimax", DiscColor.YELLOW);
            }
            case 3 -> {
                p1 = PlayerFactory.createAI("Bot Rojo", DiscColor.RED);
                p2 = PlayerFactory.createAI("Bot Amarillo", DiscColor.YELLOW);
            }
            default -> {
                p1 = PlayerFactory.createHuman("Jugador 1", DiscColor.RED);
                p2 = PlayerFactory.createHuman("Jugador 2", DiscColor.YELLOW);
            }
        }

        GameController controller = new GameController();
        controller.start(p1, p2);
    }
}
