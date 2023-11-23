package utils;

public final class GameConst {
    private static final String ADDITIONAL_INFO = "\nCreated by Shreyas Saha. Thanks for playing!";
    public static final int BOARD_SIZE = 3;
    public static final char PLAYER_O = 'O';
    public static final char PLAYER_X = 'X';
    public static final int MAX_BOARD_CELL = BOARD_SIZE*BOARD_SIZE;

    private GameConst() {
    }

    public static final String WIN_MESSAGE = "You won the game!" + ADDITIONAL_INFO;
    public static final String LOST_MESSAGE = "You lost the game!" + ADDITIONAL_INFO;
    public static final String DRAW_MESSAGE = "It's a draw!" + ADDITIONAL_INFO;
}
