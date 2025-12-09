package com.mycompany.conecta4byivazquezv;

import com.mycompany.conecta4byivazquezv.controller.GameController;
import com.mycompany.conecta4byivazquezv.controller.GameSetup;
import com.mycompany.conecta4byivazquezv.model.Player;

public class Conecta4byivazquezv {

    public static void main(String[] args) {
        GameSetup setup = new GameSetup();
        Player[] players = setup.configurePlayers();

        GameController controller = new GameController();
        controller.start(players[0], players[1]);
    }
}
