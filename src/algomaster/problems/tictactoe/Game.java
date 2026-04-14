package algomaster.problems.tictactoe;

import java.util.ArrayList;
import java.util.List;

public class Game implements Observable {
    private Board board;
    private List<Player> players;
    private List<WinningStrategy> winningStrategies;
    private GameState gameState;
    private List<GameObserver> observers = new ArrayList<>();
    private Player currentPlayer;
    private Player winner;

    public Game(int totalRows, int totalCols, List<Player> players, List<WinningStrategy> winningStrategies) {
        this.players = players;
        this.currentPlayer = players.get(0);
        this.winningStrategies = winningStrategies;
        this.gameState = GameState.IN_PROGRESS;
        this.board = new Board(totalRows, totalCols);
        display();
    }

    public void addObserver(GameObserver o) {
        this.observers.add(o);
    }

    public void notifyObservers() {
        for (GameObserver gameObserver : observers) {
            gameObserver.update(this);
        }
    }

    private boolean checkWin(int row, int col) {
        // helper method to check whether a player has won after their recent move at
        // row, col
        return winningStrategies
                .stream()
                .anyMatch(strategy -> strategy.checkWin(board, row, col));
    }

    public void makeMove(int row, int col) {
        if (this.gameState.equals(GameState.IN_PROGRESS)
                && this.board.addSymbol(row, col, currentPlayer.getSymbol())) {
            this.updateState(row, col);
            display();
        } else {
            System.out.println("Game is over. Please start a new game.");
            return;
        }
    }

    private void updateState(int row, int col) {
        boolean checkWin = this.checkWin(row, col);

        if (checkWin) {
            // Current Player Won
            this.winner = currentPlayer;
            if (currentPlayer.getSymbol().equals(Symbol.X))
                this.gameState = GameState.X_WINS;
            else
                this.gameState = GameState.O_WINS;

            this.notifyObservers();
        } else if (this.board.isFull())
            // Current Player's move resulted in a draw
            this.gameState = GameState.DRAW;
        else {
            // Game is still in progress after current player's move, change the current
            // player
            if (this.currentPlayer.equals(players.get(0)))
                this.currentPlayer = players.get(1);
            else
                this.currentPlayer = players.get(0);
        }
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Player getWinner() {
        return winner;
    }

    public void display() {
        if (this.gameState.equals(GameState.IN_PROGRESS)) {
            System.out.println(this.currentPlayer.getName() + "'s turn to play with " + this.currentPlayer.getSymbol());
        } else if (this.gameState.equals(GameState.DRAW)) {
            System.out.println("Game is draw.");
        } else {
            System.out.println(this.currentPlayer.getName() + " wins");
        }
        this.board.printBoard();
        System.out.println("--------------------------------");
    }

    public boolean isInProgress(){
        return GameState.IN_PROGRESS.equals(gameState);
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public static void main(String[] args) {
        Player vishal = new Player(Symbol.X, "Vishal", 0);
        Player kanan = new Player(Symbol.O, "Kanan", 1);
        List<Player> players = List.of(vishal, kanan);
        Scoreboard scoreboard = new Scoreboard(players);

        List<WinningStrategy> winningStrategies = List.of(new RowWinningStrategy(), new ColumnWinningStrategy());

        Game myGame = new Game(3, 3, players, winningStrategies);
        myGame.addObserver(scoreboard);

        myGame.display();
        myGame.makeMove(0, 0);
        myGame.display();
        myGame.makeMove(1, 0);
        myGame.display();
        myGame.makeMove(0, 1);
        myGame.display();
        myGame.makeMove(1, 1);
        myGame.display();
        myGame.makeMove(0, 2);
        myGame.display();

        myGame.makeMove(2, 0);

        Game myGameAgain = new Game(3, 3, players, winningStrategies);
        myGameAgain.addObserver(scoreboard);

        myGameAgain.display();
        myGameAgain.makeMove(0, 0);
        myGameAgain.display();
        myGameAgain.makeMove(1, 0);
        myGameAgain.display();
        myGameAgain.makeMove(0, 1);
        myGameAgain.display();
        myGameAgain.makeMove(1, 1);
        myGameAgain.display();
        myGameAgain.makeMove(0, 2);
        myGameAgain.display();

        myGameAgain.makeMove(2, 0);

        scoreboard.printScores();
    }

}
