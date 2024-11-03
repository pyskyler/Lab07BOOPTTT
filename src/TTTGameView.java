import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * A view for a tic-tac-toe game.
 */
public class TTTGameView extends JFrame {
    private static final int FRAME_WIDTH = 300;
    private static final int FRAME_HEIGHT = 300;
    private static final int ROW = 3;
    private static final int COL = 3;

    private TTTTile[][] guiBoard = new TTTTile[ROW][COL];

    private JPanel mainPanel = new JPanel();

    /** Constructs a frame for the tic-tac-toe game. */
    public TTTGameView()
    {
        setSize(FRAME_WIDTH, FRAME_HEIGHT);

        mainPanel.setLayout(new BorderLayout());

        JPanel gamePanel = new JPanel();
        gamePanel.setLayout(new GridLayout(ROW,COL));

        // create the gui board
        for (int row = 0; row < ROW; row++)
        {
            for (int col = 0; col < COL; col++)
            {
                TTTTile tile = new TTTTile(row, col);
                tile.setText(" ");

                guiBoard[row][col] = tile;

                gamePanel.add(tile);
            }
        }

        mainPanel.add(gamePanel, BorderLayout.CENTER);
        add(mainPanel);
    }

    /**
     * Sets the text of a tile in the view.
     * @param row the row of the tile
     * @param col the column of the tile
     * @param text the text to set
     */
    public void setTile(int row, int col, char text) {
        guiBoard[row][col].setText(String.valueOf(text));
    }

    /**
     * Adds an action listener to each tile in the view.
     * @param e the action listener to add
     */
    public void tileClick(ActionListener e) {
        for (int row = 0; row < ROW; row++)
        {
            for (int col = 0; col < COL; col++)
            {
                guiBoard[row][col].addActionListener(e);
            }
        }
    }

    /**
     * Resets the board to its initial graphical state.
     */
    public void resetBoard() {
        for (int row = 0; row < ROW; row++)
        {
            for (int col = 0; col < COL; col++)
            {
                guiBoard[row][col].setText("");
            }
        }
    }

    /**
     * Shows a message dialog with the given message.
     * @param message the message to show
     */
    public boolean showGameEndMessage(String message) {
        int result = JOptionPane.showConfirmDialog(this, message, "Game Over", JOptionPane.YES_NO_OPTION);
        return (result == JOptionPane.YES_OPTION);

    }
}
