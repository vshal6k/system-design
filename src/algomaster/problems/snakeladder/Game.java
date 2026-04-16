package algomaster.problems.snakeladder;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final Board board;
    private final List<PlayerState> playerStates = new ArrayList<>();
    private int playerIndex;
    private final Dice dice;
    private GameStatus gameStatus;

    public Game(Board board, List<Player> players, Dice dice) {
        validatePlayers(players);
        this.board = board;
        this.dice = dice;
        this.gameStatus = GameStatus.IN_PROGRESS;
        this.playerIndex = 0;
        initialisePlayerStates(players);
    }

    private void validatePlayers(List<Player> players){
        if(players.size() < 2) throw new IllegalArgumentException("Minimum two players are required to start the game.");
    }

    private void initialisePlayerStates(List<Player> players){
        for (Player player : players) {
            playerStates.add(new PlayerState(player));
        }
    }

    public void makeMove() {
        StringBuilder log = new StringBuilder();
        if (this.gameStatus != GameStatus.IN_PROGRESS) {
            // Game is over, so move cannot be processed.
            throw new IllegalStateException("Game is over. Please start a new game to play.");
        }

        log.append(playerStates.get(playerIndex).getPlayerName() + " is rolling a dice.\n");

        int diceRollValue = dice.produceNumber();
        log.append("Dice produced " + diceRollValue + ".\n");

        int currentPlayerNewPosition = board.move(playerStates.get(playerIndex).getPosition(), diceRollValue, log);

        // Player position update, if the position overshoots board the position is not
        // updated.
        if (currentPlayerNewPosition > board.getSize())
            currentPlayerNewPosition = playerStates.get(playerIndex).getPosition();
        else
            playerStates.get(playerIndex).setPosition(currentPlayerNewPosition);

        log.append(playerStates.get(playerIndex).getPlayerName() + " is at " + currentPlayerNewPosition + "\n");

        if (checkWin(currentPlayerNewPosition)) {
            // current player has won, so turn rotation is skipped.
            this.gameStatus = GameStatus.OVER;
            log.append("Game is over. " + playerStates.get(playerIndex).getPlayerName() + " wins.\n");
            System.out.print(log);
            return;
        }

        //Print the log
        System.out.print(log);

        // Turn Rotation Logic
        rotateTurn(diceRollValue);

    }

    private boolean checkWin(int currentPlayerNewPosition) {
        return currentPlayerNewPosition == board.getSize();
    }

    private void rotateTurn(int diceRollValue) {
        int size = playerStates.size();
        if (diceRollValue != dice.getRange()) {
            playerIndex = (playerIndex + 1) % size;
        }
    }

    public void display() {
        board.printBoard();
        for (int i = 0; i < playerStates.size(); i++) {
            System.out.println(playerStates.get(i).getPlayerName() + " is at " + playerStates.get(i).getPosition());
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

        while(game.gameStatus != GameStatus.OVER){
            game.makeMove();
            System.out.println("====================");
        }

    }

}
