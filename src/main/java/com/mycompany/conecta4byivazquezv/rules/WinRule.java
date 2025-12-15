package com.mycompany.conecta4byivazquezv.rules;

<<<<<<< HEAD
import com.mycompany.conecta4byivazquezv.model.Board;      // Modelo del tablero
import com.mycompany.conecta4byivazquezv.model.DiscColor;  // Enum con los colores de las fichas
import com.mycompany.conecta4byivazquezv.model.GameResult; // Resultado posible del juego

/**
 * Interfaz para las reglas de victoria en Conecta4.
 * Define el contrato que deben cumplir todas las reglas (horizontal, vertical, diagonal).
 * Cada regla evalúa el tablero y, si no detecta victoria, puede delegar en la siguiente.
 */
public interface WinRule {

    /**
     * Evalúa el tablero tras la última jugada.
     *
     * @param board tablero actual, necesario para consultar las fichas colocadas
     * @param lastColor color de la última ficha colocada (DiscColor.RED o DiscColor.YELLOW),
     *                  se pasa porque las reglas deben comprobar si hay 4 consecutivas del mismo jugador
     * @param lastRow fila donde cayó la última ficha, punto de partida para la comprobación
     * @param lastCol columna donde cayó la última ficha, complementa la posición exacta
     * @return resultado del juego (IN_PROGRESS si sigue, DRAW si empate, RED_WINS o YELLOW_WINS si hay victoria)
=======
import com.mycompany.conecta4byivazquezv.model.Board;
import com.mycompany.conecta4byivazquezv.model.DiscColor;
import com.mycompany.conecta4byivazquezv.model.GameResult;

/**
 * Interfaz para las reglas de victoria en Conecta4.
 * Cada regla evalúa el tablero y puede delegar en la siguiente.
 */
public interface WinRule {
    /**
     * Evalúa el tablero tras la última jugada.
     *
     * @param board tablero actual
     * @param lastColor color de la última ficha colocada
     * @param lastRow fila donde cayó la ficha
     * @param lastCol columna donde cayó la ficha
     * @return resultado del juego (IN_PROGRESS, DRAW, RED_WINS, YELLOW_WINS)
>>>>>>> c40613905afa72172cf579325da90ebf647682ad
     */
    GameResult evaluate(Board board, DiscColor lastColor, int lastRow, int lastCol);

    /**
     * Establece la siguiente regla en la cadena.
<<<<<<< HEAD
     * Permite aplicar el patrón Chain of Responsibility:
     * si esta regla no detecta victoria, delega la comprobación en la siguiente.
=======
>>>>>>> c40613905afa72172cf579325da90ebf647682ad
     */
    void setNext(WinRule next);
}
