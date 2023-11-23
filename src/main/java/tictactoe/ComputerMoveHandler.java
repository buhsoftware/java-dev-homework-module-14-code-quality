package tictactoe;

import java.util.Random;
import utils.GameConst;
public class ComputerMoveHandler {
    private ComputerMoveHandler() {
    }

    private static final Random random = new Random();

    public static void makeMove(GameBoard gameBoard) {
        while (true) {
            int rand = (random.nextInt(GameConst.MAX_BOARD_CELL)) + 1;
            if (gameBoard.getBoard()[(rand - 1) / GameConst.BOARD_SIZE][(rand - 1) % GameConst.BOARD_SIZE] == ' ') {
                gameBoard.getBoard()[(rand - 1) / GameConst.BOARD_SIZE][(rand - 1) % GameConst.BOARD_SIZE] = GameConst.PLAYER_O;
                break;
            }
        }
    }
}