package tictactoe;

import java.util.Scanner;
import utils.GameConst;
@java.lang.SuppressWarnings({"java:S106"})
public class PlayerMoveHandler {
    private PlayerMoveHandler() {
    }

    public static void makeMove(GameBoard gameBoard, Scanner scanner) {
        while (true) {
            System.out.printf("%nEnter a box number (1-%d): ", GameConst.MAX_BOARD_CELL);
            int input = scanner.nextInt();
            if (input >= 1 && input <= GameConst.MAX_BOARD_CELL && gameBoard.getBoard()[(input - 1) / GameConst.BOARD_SIZE][(input - 1) % GameConst.BOARD_SIZE] == ' ') {
                gameBoard.getBoard()[(input - 1) / GameConst.BOARD_SIZE][(input - 1) % GameConst.BOARD_SIZE] = GameConst.PLAYER_X;
                break;
            } else {
                System.out.println("Invalid input. Enter again.");
            }
        }
    }
}