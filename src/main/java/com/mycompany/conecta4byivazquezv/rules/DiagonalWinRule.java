package com.mycompany.conecta4byivazquezv.rules;

<<<<<<< HEAD
import com.mycompany.conecta4byivazquezv.model.Board;      // Modelo del tablero
import com.mycompany.conecta4byivazquezv.model.DiscColor;  // Enum con los colores de las fichas
import com.mycompany.conecta4byivazquezv.model.GameResult; // Resultado posible del juego

/**
 * Regla de victoria para comprobar diagonales en el tablero. Evalúa tanto
 * diagonales descendentes (\) como ascendentes (/). Extiende BaseWinRule para
 * integrarse en la cadena de comprobaciones.
=======
import com.mycompany.conecta4byivazquezv.model.Board;
import com.mycompany.conecta4byivazquezv.model.DiscColor;
import com.mycompany.conecta4byivazquezv.model.GameResult;

/**
 * Regla de victoria para comprobar diagonales en el tablero.
 * Evalúa tanto diagonales descendentes (\) como ascendentes (/).
>>>>>>> c40613905afa72172cf579325da90ebf647682ad
 */
public final class DiagonalWinRule extends BaseWinRule {

    @Override
    public GameResult evaluate(Board board, DiscColor color, int row, int col) {
<<<<<<< HEAD
        // Comprobamos diagonal descendente (\)
        if (checkDiagonal(board, color, row, col, 1, 1)) {
            // Si hay 4 en línea, devolvemos el resultado según el color del jugador
            return (color == DiscColor.RED) ? GameResult.RED_WINS : GameResult.YELLOW_WINS;
        }

        // Comprobamos diagonal ascendente (/)
=======
        // Diagonal descendente (\)
        if (checkDiagonal(board, color, row, col, 1, 1)) {
            return (color == DiscColor.RED) ? GameResult.RED_WINS : GameResult.YELLOW_WINS;
        }

        // Diagonal ascendente (/)
>>>>>>> c40613905afa72172cf579325da90ebf647682ad
        if (checkDiagonal(board, color, row, col, -1, 1)) {
            return (color == DiscColor.RED) ? GameResult.RED_WINS : GameResult.YELLOW_WINS;
        }

<<<<<<< HEAD
        // Si no hay victoria diagonal, delegamos en la siguiente regla de la cadena
=======
        // Si no hay victoria diagonal, pasa al siguiente en la cadena
>>>>>>> c40613905afa72172cf579325da90ebf647682ad
        return next(board, color, row, col);
    }

    /**
<<<<<<< HEAD
     * Comprueba si hay al menos 4 fichas consecutivas en una diagonal a partir
     * de la posición indicada.
     *
     * @param board tablero completo, necesario para consultar las fichas
     * @param color color de la ficha recién colocada (rojo o amarillo), se pasa
     * porque debemos comprobar que las fichas consecutivas sean del mismo
     * jugador
     * @param row fila inicial donde se colocó la última ficha
     * @param col columna inicial de la última ficha
     * @param rowDir dirección de fila (+1 descendente, -1 ascendente)
     * @param colDir dirección de columna (+1 derecha, -1 izquierda)
     * @return true si hay 4 o más consecutivas del mismo color, false en caso
     * contrario
     */
    private boolean checkDiagonal(Board board, DiscColor color, int row, int col, int rowDir, int colDir) {
        int count = 1; // empezamos contando la ficha recién colocada

        // Avanzar en la dirección indicada (ej. hacia abajo-derecha(descendente) o arriba-derecha(ascendente))
        int currentRow = row + rowDir;
        int currentCol = col + colDir;
        while (currentRow >= 0 && currentRow < Board.ROWS
                && currentCol >= 0 && currentCol < Board.COLS
                && board.getGrid()[currentRow][currentCol].getColor() == color) {
=======
     * Comprueba si hay al menos 4 fichas consecutivas en una diagonal
     * a partir de la posición indicada.
     *
     * @param board tablero
     * @param color color de la ficha a comprobar
     * @param row fila inicial
     * @param col columna inicial
     * @param rowDir dirección de fila (+1 descendente, -1 ascendente)
     * @param colDir dirección de columna (+1 derecha, -1 izquierda)
     * @return true si hay 4 o más consecutivas, false en caso contrario
     */
    private boolean checkDiagonal(Board board, DiscColor color, int row, int col, int rowDir, int colDir) {
        int count = 1; // incluye la ficha recién colocada

        // Avanzar en la dirección indicada
        int currentRow = row + rowDir;
        int currentCol = col + colDir;
        while (currentRow >= 0 && currentRow < Board.ROWS &&
               currentCol >= 0 && currentCol < Board.COLS &&
               board.getGrid()[currentRow][currentCol].getColor() == color) {
>>>>>>> c40613905afa72172cf579325da90ebf647682ad
            count++;
            currentRow += rowDir;
            currentCol += colDir;
        }

<<<<<<< HEAD
        // Retroceder en la dirección opuesta (ej. hacia arriba-izquierda(ascendente) o abajo-izquierda (descendente))
        currentRow = row - rowDir;
        currentCol = col - colDir;
        while (currentRow >= 0 && currentRow < Board.ROWS
                && currentCol >= 0 && currentCol < Board.COLS
                && board.getGrid()[currentRow][currentCol].getColor() == color) {
=======
        // Retroceder en la dirección opuesta
        currentRow = row - rowDir;
        currentCol = col - colDir;
        while (currentRow >= 0 && currentRow < Board.ROWS &&
               currentCol >= 0 && currentCol < Board.COLS &&
               board.getGrid()[currentRow][currentCol].getColor() == color) {
>>>>>>> c40613905afa72172cf579325da90ebf647682ad
            count++;
            currentRow -= rowDir;
            currentCol -= colDir;
        }

<<<<<<< HEAD
        // Si el total de fichas consecutivas es 4 o más, hay victoria
=======
>>>>>>> c40613905afa72172cf579325da90ebf647682ad
        return count >= 4;
    }
}
