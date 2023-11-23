package tictactoe;

import utils.GameConst;

@java.lang.SuppressWarnings("java:S106")
public class GameBoard {

    private final char[][] board;

    public GameBoard() {
        this.board = new char[GameConst.BOARD_SIZE][GameConst.BOARD_SIZE];
        clearBoard();
    }

    public void printBoard(boolean initMode) {
        for (int row = 0; row < GameConst.BOARD_SIZE; row++) {
            for (int col = 0; col < GameConst.BOARD_SIZE; col++) {
                System.out.printf(" %s ", initMode?(char)(col + 1 + row*GameConst.BOARD_SIZE +'0'):board[row][col]);
                if (col < GameConst.BOARD_SIZE - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (row < GameConst.BOARD_SIZE - 1) {
                System.out.println("-----------");
            }
        }
        System.out.println();
    }

    public void clearBoard() {
        for (int row = 0; row < GameConst.BOARD_SIZE; row++) {
            for (int col = 0; col < GameConst.BOARD_SIZE; col++) {
                board[row][col] = ' ';
            }
        }
    }

    public char[][] getBoard() {
        return board;
    }
}