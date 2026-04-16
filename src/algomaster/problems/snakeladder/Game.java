package algomaster.problems.snakeladder;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final Board board;
    private final List<Player> players;
    private List<Integer> playerPositions = new ArrayList<>();
    private int playerIndex;
    private final Dice dice;
    private GameStatus gameStatus;

    public Game(Board board, List<Player> players, Dice dice) {
        validatePlayers(players);
        this.board = board;
        this.players = players;
        this.dice = dice;
        this.gameStatus = GameStatus.IN_PROGRESS;
        this.playerIndex = 0;
        initialisePlayerPositions();
    }

    private void validatePlayers(List<Player> players){
        if(players.size() < 2) throw new IllegalArgumentException("Minimum two players are required to start the game.");
    }

    private void initialisePlayerPositions() {
        int playerCount = players.size();
        for (int i = 0; i < playerCount; i++) {
            playerPositions.add(0);
        }
    }

    public void makeMove() {
        if (this.gameStatus != GameStatus.IN_PROGRESS) {
            // Game is over, so move cannot be processed.
            throw new IllegalStateException("Game is over. Please start a new game to play.");
        }
        int diceRollValue = dice.produceNumber();

        int currentPlayerNewPosition = board.move(playerPositions.get(playerIndex), diceRollValue);

        // Player position update, if the position overshoots board the position is not
        // updated.
        if (currentPlayerNewPosition > board.getSize())
            currentPlayerNewPosition = playerPositions.get(playerIndex);
        else
            playerPositions.set(playerIndex, currentPlayerNewPosition);

        if (checkWin(currentPlayerNewPosition)) {
            // current player has won, so turn rotation is skipped.
            this.gameStatus = GameStatus.OVER;
            return;
        }

        // Turn Rotation Logic
        rotateTurn(diceRollValue);

    }

    private boolean checkWin(int currentPlayerNewPosition) {
        return currentPlayerNewPosition == board.getSize();
    }

    private void rotateTurn(int diceRollValue) {
        int size = dice.getRange();
        if (diceRollValue != size) {
            playerIndex = (playerIndex + 1) % size;
        }
    }

    public void display() {
        board.printBoard();
        for (int i = 0; i < players.size(); i++) {
            System.out.println(players.get(i).getName() + " is at " + playerPositions.get(i));
        }
    }

    public static void main(String[] args) {
        Snake snake1 = new Snake(8, 6);
        Snake snake2 = new Snake(9, 2);
        List<Snake> snakes = List.of(snake1, snake2);

        Ladder ladder1 = new Ladder(3, 8);
        Ladder ladder2 = new Ladder(2, 3);
        List<Ladder> ladders = List.of(ladder1, ladder2);

        Board board = new Board(10, snakes, ladders);

        Dice dice = new Dice(6, new RandomNumberProductionStrategy());

        Player player1 = new Player("Vishal");
        Player player2 = new Player("Kanan");
        List<Player> players = List.of(player1, player2);

        Game game = new Game(board, players, dice);

        game.display();

    }

}
