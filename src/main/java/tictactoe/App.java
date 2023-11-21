package tictactoe;

import java.util.Random;
import java.util.Scanner;
@java.lang.SuppressWarnings("java:S106")

public class App {
    private static final int BOARD_SIZE = 3;
    private static final char PLAYER_X = 'X';
    private static final char PLAYER_O = 'O';

    private static final String WIN_MESSAGE = "You won the game!\nCreated by Shreyas Saha. Thanks for playing!";
    private static final String LOST_MESSAGE = "You lost the game!\nCreated by Shreyas Saha. Thanks for playing!";
    private static final String DRAW_MESSAGE = "It's a draw!\nCreated by Shreyas Saha. Thanks for playing!";
    private static final Random random = new Random();

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        char[][] board = {{'1', '2', '3'}, {'4', '5', '6'}, {'7', '8', '9'}};
        boolean boxEmpty = false;
        byte winner = 0;

        System.out.println("Enter box number to select. Enjoy!\n");

        while (true) {

            printBoard(board);

            if (!boxEmpty) {
                clearBoard(board);
                boxEmpty = true;
            }

            if (winner == 1 || winner == 2 || winner == 3) {
                printResult(winner);
                break;
            }

            playerMove(board, scan);

            if (checkWin(board, PLAYER_X)) {
                winner = 1;
                continue;
            }

            if (isBoardFull(board)) {
                winner = 3;
                continue;
            }

            computerMove(board);

            if (checkWin(board, PLAYER_O)) {
                winner = 2;
            }
        }

        scan.close();

    }

    private static void printBoard(char[][] board) {
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                System.out.print(" " + board[row][col] + " ");
                if (col < BOARD_SIZE - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (row < BOARD_SIZE - 1) {
                System.out.println("-----------");
            }
        }
        System.out.println();
    }
    private static void clearBoard(char[][] board) {
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                board[row][col] = ' ';
            }
        }
    }

    private static void printResult(byte winner) {

        switch (winner) {
            case 1: System.out.println(WIN_MESSAGE);
                break;
            case 2: System.out.println(LOST_MESSAGE);
                break;
            default:System.out.println(DRAW_MESSAGE);
        }
    }

    private static void playerMove(char[][] board, Scanner scanner) {
        while (true) {
            System.out.println("Enter a box number (1-9): ");
            int input = scanner.nextInt();
            if (input >= 1 && input <= 9 && board[(input - 1) / BOARD_SIZE][(input - 1) % BOARD_SIZE] == ' ') {
                board[(input - 1) / BOARD_SIZE][(input - 1) % BOARD_SIZE] = PLAYER_X;
                break;
            } else {
                System.out.println("Invalid input. Enter again.");
            }
        }
    }

    private static void computerMove(char[][] board) {

        while (true) {
            int rand = (random.nextInt(9)) + 1;
            if (board[(rand - 1) / BOARD_SIZE][(rand - 1) % BOARD_SIZE] == ' ') {
                board[(rand - 1) / BOARD_SIZE][(rand - 1) % BOARD_SIZE] = PLAYER_O;
                break;
            }
        }
    }

    private static boolean checkWin(char[][] board, char player) {
        // Check rows, columns, and diagonals for a win
        for (int i = 0; i < BOARD_SIZE; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
                    (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
                return true;
            }
        }
        return (board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
                (board[0][2] == player && board[1][1] == player && board[2][0] == player);
    }

    private static boolean isBoardFull(char[][] board) {
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                if (board[row][col] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}