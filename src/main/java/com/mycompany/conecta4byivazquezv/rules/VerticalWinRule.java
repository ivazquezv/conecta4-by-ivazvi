package com.mycompany.conecta4byivazquezv.rules;

<<<<<<< HEAD
import com.mycompany.conecta4byivazquezv.model.Board;      // Modelo del tablero
import com.mycompany.conecta4byivazquezv.model.DiscColor;  // Enum con los colores de las fichas
import com.mycompany.conecta4byivazquezv.model.GameResult; // Resultado posible del juego

/**
 * Regla de victoria para comprobar alineaciones verticales en el tablero.
 * Forma parte del patrón Chain of Responsibility: si no hay victoria vertical,
 * delega la comprobación a la siguiente regla.
=======
import com.mycompany.conecta4byivazquezv.model.Board;
import com.mycompany.conecta4byivazquezv.model.DiscColor;
import com.mycompany.conecta4byivazquezv.model.GameResult;

/**
 * Regla de victoria para comprobar alineaciones verticales en el tablero.
>>>>>>> c40613905afa72172cf579325da90ebf647682ad
 */
public final class VerticalWinRule extends BaseWinRule {

    @Override
    public GameResult evaluate(Board board, DiscColor color, int row, int col) {
<<<<<<< HEAD
        int consecutiveCount = 0; // contador de fichas consecutivas del mismo color

        // Recorremos todas las filas de la columna indicada (col)
        for (int currentRow = 0; currentRow < Board.ROWS; currentRow++) {
            // Usamos board.getGrid() para acceder a la matriz interna del tablero
            // getGrid() devuelve la estructura bidimensional (celda[row][col])
            // y desde cada celda podemos obtener el color con getColor()
            if (board.getGrid()[currentRow][col].getColor() == color) {
                consecutiveCount++; // sumamos si la ficha es del mismo color
                if (consecutiveCount >= 4) {
                    // Si hay 4 o más consecutivas, declaramos victoria
                    return (color == DiscColor.RED) ? GameResult.RED_WINS : GameResult.YELLOW_WINS;
                }
            } else {
                // Si encontramos otra ficha o una celda vacía, reiniciamos el contador
                consecutiveCount = 0;
            }
        }

        // Si no hay victoria vertical, pasamos la comprobación a la siguiente regla en la cadena
=======
        int consecutiveCount = 0;

        // Recorremos todas las filas de la columna indicada
        for (int currentRow = 0; currentRow < Board.ROWS; currentRow++) {
            if (board.getGrid()[currentRow][col].getColor() == color) {
                consecutiveCount++;
                if (consecutiveCount >= 4) {
                    return (color == DiscColor.RED) ? GameResult.RED_WINS : GameResult.YELLOW_WINS;
                }
            } else {
                consecutiveCount = 0; // reiniciamos si encontramos otra ficha o vacío
            }
        }

        // Si no hay victoria vertical, pasa al siguiente en la cadena
>>>>>>> c40613905afa72172cf579325da90ebf647682ad
        return next(board, color, row, col);
    }
}
