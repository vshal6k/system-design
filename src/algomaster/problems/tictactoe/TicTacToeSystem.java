package algomaster.problems.tictactoe;

import java.util.List;

public class TicTacToeSystem {
    private Scoreboard scoreboard;
    private Game currentGame;
    private List<Player> players;

    public TicTacToeSystem(List<Player> players){
        this.scoreboard = new Scoreboard(players);
        this.players = players;
    }

    public void createGame(int row, int col, List<WinningStrategy> winningStrategies){
        if(this.currentGame != null && this.currentGame.isInProgress()){
            System.out.println("Current game is in progress.");
        }else{
            this.currentGame = new Game(row, col, players, winningStrategies);
            this.currentGame.addObserver(scoreboard);
        } 
    }

    public void makeMove(int row, int col){
        if(this.currentGame != null) this.currentGame.makeMove(row, col);
    }

    public void printScoreBoard(){
        if(this.currentGame != null) this.scoreboard.printScores();
    }

    public static void main(String[] args) {
        Player vishal = new Player(Symbol.X, "Vishal", 0);
        Player kanan = new Player(Symbol.O, "Kanan", 1);
        List<Player> players = List.of(vishal, kanan);
        List<WinningStrategy> winningStrategies = List.of(new RowWinningStrategy(), new ColumnWinningStrategy());

        TicTacToeSystem ticTacToeSystem = new TicTacToeSystem(players);
        ticTacToeSystem.createGame(3, 3, winningStrategies);

        
        ticTacToeSystem.makeMove(0, 0);
        ticTacToeSystem.makeMove(1, 0);
        ticTacToeSystem.makeMove(0, 1);
        ticTacToeSystem.makeMove(1, 1);
        ticTacToeSystem.makeMove(0, 2);

        ticTacToeSystem.printScoreBoard();

        ticTacToeSystem.createGame(3, 3, winningStrategies);
        ticTacToeSystem.makeMove(0, 0);
        ticTacToeSystem.makeMove(1, 0);
        ticTacToeSystem.makeMove(0, 1);
        ticTacToeSystem.makeMove(1, 1);
        ticTacToeSystem.makeMove(0, 2);
        ticTacToeSystem.printScoreBoard();

        ticTacToeSystem.createGame(3, 3, winningStrategies);
        ticTacToeSystem.makeMove(0, 0);
        ticTacToeSystem.makeMove(0, 1);
        ticTacToeSystem.makeMove(0, 2);
        ticTacToeSystem.makeMove(1, 0);
        ticTacToeSystem.makeMove(1, 1);
        ticTacToeSystem.makeMove(1, 2);
        ticTacToeSystem.makeMove(2, 1);
        ticTacToeSystem.makeMove(2, 0);
        ticTacToeSystem.makeMove(2, 2);
        ticTacToeSystem.printScoreBoard();
        
    }

}
