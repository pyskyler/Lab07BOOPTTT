import java.util.ArrayList;
import java.util.Objects;

/**
 * A model for a tic-tac-toe game.
 */
public class TTTGameModel {
    public final char X = 'X';
    public final char O = 'O';
    private final int ROW = 3;
    private final int COL = 3;
    private char[][] board = new char[ROW][COL];
    private char currentPlayer;
    private String winMessage;
    private int turnsCompleted = 0;

    // Constructor
    /**
     * Constructs a new game model.
     */
    public TTTGameModel() {
        resetGame();
    }

    // Public methods
    /**
     * Plays a move at the specified row and column.
     * @param row the row of the move
     * @param col the column of the move
     * @return true if the move was played, false if the move was invalid
     */
    public boolean playMove(int row, int col) {
        if (board[row][col] == ' ') {
            // make move
            board[row][col] = currentPlayer;
            turnsCompleted++;
            return true;
        }
        return false;
    }

    /**
     * Switches the current player.
     */
    public void switchPlayer() {
        if (currentPlayer == X) {
            currentPlayer = O;
        } else {
            currentPlayer = X;
        }
    }


    /**
     * Checks if the game has ended. Sets the win message if the game has ended.
     * @return true if the game has ended, false otherwise
     */
    public boolean checkGameEnd() {
        if (turnsCompleted >= 3) {
            // If there is a win or tie announce it
            if (isWin(currentPlayer)) {
                winMessage = "Player " + currentPlayer + " wins!";
                return true;
            } else if (turnsCompleted == 9) {
                winMessage = "It ended in a tie! You both win!";
                return true;
            } else if (turnsCompleted >= 7) {
                if (isTie()) {
                    winMessage = "It ended in a tie! You both win!";
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Resets the game to the initial state.
     */
    public void resetGame() {
        clearBoard();
        currentPlayer = X;
        turnsCompleted = 0;
    }

    // Getters
    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public String getWinMessage() {
        return winMessage;
    }

    // Private methods
    private boolean isWin(char player) {// checks to see if there is a win state on the current board for the specified player (X or O) This method in turn calls three additional methods that break down the 3 kinds of wins that are possible.
        return (isColWin(player) | isRowWin(player) | isDiagonalWin(player));
    }

    private boolean isColWin(char player) {// checks for a col win for specified player
        for (int i = 0; i < COL; i++)
        {
            if (Objects.equals(board[0][i], player) && Objects.equals(board[1][i], player)
                    && Objects.equals(board[2][i], player)) {
                return true;
            }
        }
        return false;
    }

    private boolean isRowWin(char player) { // checks for a row win for the specified player
        for (int i = 0; i < ROW; i++)
        {
            if (Objects.equals(board[i][0], player) && Objects.equals(board[i][1], player)
                    && Objects.equals(board[i][2], player)) {
                return true;
            }
        }
        return false;
    }

    private boolean isDiagonalWin(char player) { // checks for a diagonal win for the specified player
        if (Objects.equals(board[0][0], player) && Objects.equals(board[1][1], player)
                && Objects.equals(board[2][2], player)) {
            return true;
        }
        else if (Objects.equals(board[0][2], player) && Objects.equals(board[1][1], player)
                && Objects.equals(board[2][0], player)) {
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
                if (Objects.equals(board[i][j], " ")){
                    openTiles.add(new int[]{i, j});
                }
            }
        }

        for (int[] tile : openTiles) {
            board[tile[0]][tile[1]] = X;
            if (isWin(X)) {
                isTie = false;
            }
            board[tile[0]][tile[1]] = O;
            if (isWin(O)) {
                isTie = false;
            }
            board[tile[0]][tile[1]] = ' ';
        }

        return isTie;
    }

    private void clearBoard() { // sets all the board elements to a space
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL;j++) {
                board[i][j] = ' ';
            }
        }
    }
}
