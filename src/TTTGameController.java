import java.awt.event.ActionListener;

/**
 * Controller for tic-tac-toe game.
 */
public class TTTGameController {
    private TTTGameModel model;
    private TTTGameView view;

    /**
     * Constructs a controller for the tic-tac-toe game.
     * @param model the model of the game
     * @param view the view of the game
     */
    public TTTGameController(TTTGameModel model, TTTGameView view) {
        this.model = model;
        this.view = view;

        ActionListener playMove = e -> {

            TTTTile tile = (TTTTile) e.getSource();
            int row = tile.getRow();
            int col = tile.getCol();
            System.out.println("Move clicked" + row + " " + col);

            char player = model.getCurrentPlayer();

            //try to play move
            if (model.playMove(row, col)) {
                //show move in view
                view.setTile(row, col, player);

                //check if game is over
                if (model.checkGameEnd()) {
                    // show game end message
                    boolean result = view.showGameEndMessage(model.getWinMessage() + "\nWould you like to play again?");
                    if (result) {
                        view.resetBoard();
                        model.resetGame();
                    } else {
                        System.exit(0);
                    }
                }

                //switch player
                model.switchPlayer();
            }
        };

        view.tileClick(playMove);
    }
}
