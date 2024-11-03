import javax.swing.*;

/**
 * A Tic-Tac-Toe game application.
 */
public class TTTApp {
    /**
     * Runs the Tic-Tac-Toe game.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TTTGameModel model = new TTTGameModel();
        TTTGameView view = new TTTGameView();
        TTTGameController controller = new TTTGameController(model, view);
        view.setVisible(true);
        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
