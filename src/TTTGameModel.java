import java.util.ArrayList;
import java.util.Objects;

public class TTTGameModel {
    public final char X = 'X';
    public final char O = 'O';
    private final int ROW = 3;
    private final int COL = 3;
    private int[][] board;
    private char currentPlayer;
    private char winner;
    private String winMessage;

    // Constructor
    public TTTGameModel() {
        board = new int[ROW][COL];
        currentPlayer = X;
    }

    // Public methods
    public boolean playMove(int row, int col) {
    }

    public boolean checkGameEnd() {
    }

    // Getters

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public int getWinner() {
        return winner;
    }

    public String getWinMessage() {
        return winMessage;
    }

    // Private methods

    private boolean isWin(String player) {// checks to see if there is a win state on the current board for the specified player (X or O) This method in turn calls three additional methods that break down the 3 kinds of wins that are possible.
        return (isColWin(player) | isRowWin(player) | isDiagonalWin(player));
    }

    private boolean isColWin(String player) {// checks for a col win for specified player
        for (int i = 0; i < COL; i++)
        {
            if (Objects.equals(logicBoard[0][i], player) && Objects.equals(logicBoard[1][i], player)
                    && Objects.equals(logicBoard[2][i], player)) {
                return true;
            }
        }
        return false;
    }

    private boolean isRowWin(String player) { // checks for a row win for the specified player
        for (int i = 0; i < ROW; i++)
        {
            if (Objects.equals(logicBoard[i][0], player) && Objects.equals(logicBoard[i][1], player)
                    && Objects.equals(logicBoard[i][2], player)) {
                return true;
            }
        }
        return false;
    }

    private boolean isDiagonalWin(String player) { // checks for a diagonal win for the specified player
        if (Objects.equals(logicBoard[0][0], player) && Objects.equals(logicBoard[1][1], player)
                && Objects.equals(logicBoard[2][2], player)) {
            return true;
        }
        else if (Objects.equals(logicBoard[0][2], player) && Objects.equals(logicBoard[1][1], player)
                && Objects.equals(logicBoard[2][0], player)) {
            return true;
        }
        return false;
    }

    private boolean isTie() { // checks for a tie condition: all spaces on the board are filled

        // test each possible move for each player
        boolean isTie = true;

        ArrayList<int[]> openTiles = new ArrayList<>();

        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL;j++) {
                if (Objects.equals(logicBoard[i][j], " ")){
                    openTiles.add(new int[]{i, j});
                }
            }
        }

        for (int[] tile : openTiles) {
            logicBoard[tile[0]][tile[1]] = "X";
            if (isWin("X")) {
                isTie = false;
            }
            logicBoard[tile[0]][tile[1]] = "O";
            if (isWin("O")) {
                isTie = false;
            }
            logicBoard[tile[0]][tile[1]] = " ";
        }

        return isTie;
    }

    private void resetGame() {
        clearBoard();
        for (int row = 0; row < ROW; row++)
        {
            for (int col = 0; col < COL; col++)
            {
                guiBoard[row][col].setText(" ");
                logicBoard[row][col] = " ";
            }
        }
        turnsCompleted = 0;
        player = ;
        gameCompleted = false;
    }

    private void clearBoard() { // sets all the board elements to a space
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL;j++) {
                logicBoard[i][j] = " ";
            }
        }
    }
}
