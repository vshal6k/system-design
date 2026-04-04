package algomaster.problems.tictactoe;

import java.util.List;

public class Game implements Observable {
    private Board board;
    private int playerIndex;
    private GameState gameState;
    private List<Player> players;
    private List<WinningStrategy> winningStrategies;
    private List<GameObserver> observers;
    private Player winner;

    public Game(List<Player> players, List<WinningStrategy> winningStrategies) {
        this.players = players;
        this.winningStrategies = winningStrategies;
        this.gameState = GameState.IN_PROGRESS;
        this.playerIndex = 0;
        this.board = new Board(3, 3);
    }

    public void addObserver(GameObserver o) {
        this.observers.add(o);
    }

    public void notifyObservers() {
        for (GameObserver gameObserver : observers) {
            gameObserver.update(this);
        }
    }

    public boolean checkWin(int row, int col, Symbol symbol) {
        return winningStrategies
                .stream()
                .anyMatch(strategy -> strategy.checkWin(board, row, col, symbol));
    }

    public void makeMove(int row, int col) {
        this.board.addSymbol(row, col, players.get(playerIndex).getSymbol());

        this.updateState(row, col);

        if (playerIndex == 0)
            playerIndex = 1;
        else
            playerIndex = 0;
    }

    private void updateState(int row, int col) {
        boolean checkWin = this.checkWin(row, col, players.get(playerIndex).getSymbol());

        if (checkWin) {
            this.winner = players.get(playerIndex);
            if (this.winner.getSymbol().equals(Symbol.X))
                this.gameState = GameState.X_WINS;
            else
                this.gameState = GameState.O_WINS;

            this.notifyObservers();

        } else if (this.board.isFull())
            this.gameState = GameState.DRAW;
    }

    public Player getWinner(){
        return this.winner;
    }

}
