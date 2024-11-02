import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

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

                guiBoard[row][col] = tile;

                gamePanel.add(tile);
            }
        }

        mainPanel.add(gamePanel, BorderLayout.CENTER);
        add(mainPanel);
    }

    public void setTile(int row, int col, String text) {
        guiBoard[row][col].setText(text);
    }

    public void tileClick(ActionListener e) {
        for (int row = 0; row < ROW; row++)
        {
            for (int col = 0; col < COL; col++)
            {
                guiBoard[row][col].addActionListener(e);
            }
        }
    }
}
