package tictactoe;
import java.util.Scanner;
import utils.GameConst;

@java.lang.SuppressWarnings("java:S106")
public class TicTacToeGame {
    public static void main(String[] args) {
        boolean initMode = true;
        Scanner scanner = new Scanner(System.in);
        GameBoard gameBoard = new GameBoard();

        System.out.println("Enter box number to select. Enjoy!\n");

        while (true) {
            gameBoard.printBoard(initMode);
            initMode = false;
            PlayerMoveHandler.makeMove(gameBoard, scanner);

            if (checkWin(gameBoard.getBoard(), 'X')) {
                System.out.println(GameConst.WIN_MESSAGE);
                break;
            }

            if (isBoardFull(gameBoard.getBoard())) {
                System.out.println(GameConst.DRAW_MESSAGE);
                break;
            }

            ComputerMoveHandler.makeMove(gameBoard);

            if (checkWin(gameBoard.getBoard(), 'O')) {
                System.out.println(GameConst.LOST_MESSAGE);
                break;
            }
        }

        scanner.close();
    }

    private static boolean checkWin(char[][] board, char player) {
        // Check rows, columns, and diagonals for a win
        for (int i = 0; i < GameConst.BOARD_SIZE; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
                    (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
                return true;
            }
        }
        return (board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
                (board[0][2] == player && board[1][1] == player && board[2][0] == player);
    }

    static boolean isBoardFull(char[][] board) {
        for (int row = 0; row < GameConst.BOARD_SIZE; row++) {
            for (int col = 0; col < GameConst.BOARD_SIZE; col++) {
                if (board[row][col] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}