package algomaster.problems.tictactoe;

import java.util.List;

public class TicTacToeSystem {
    private Scoreboard scoreboard;
    private Game currentGame;
    private static final TicTacToeSystem instance = new TicTacToeSystem();

    private TicTacToeSystem() {
    };

    public void createScoreBoard(Player player1, Player player2){
        if(this.scoreboard == null) this.scoreboard = new Scoreboard(player1, player2);
    }

    public void createGame(Player player1, Player player2, List<WinningStrategy> winningStrategies) {
        this.currentGame = new Game(List.of(player1, player2), winningStrategies);  
        this.currentGame.addObserver(scoreboard);      
    }

    public static TicTacToeSystem getInstance() {
        return TicTacToeSystem.TIC_TAC_TOE_IN_SYSTEM_INSTANCE;
    }

    public void makeMove(int row, int col) {
        this.currentGame.makeMove(row, col);
    }

    public void printScoreBoard() {
        this.scoreboard.printScores();
    }

    public static void main(String[] args) {
        TicTacToeSystem ticTacToeSystem = TicTacToeSystem.getInstance();

        List<WinningStrategy> winningStrategies = List.of(new RowWinningStrategy(), new ColumnWinningStrategy());

        Player player1 = new Player(Symbol.O, "Vishal");
        Player player2 = new Player(Symbol.X, "Kanan");

        ticTacToeSystem.createGame(player1, player2, winningStrategies);

        ticTacToeSystem.makeMove( 0, 0);
        ticTacToeSystem.makeMove( 0, 1);
        ticTacToeSystem.makeMove( 0, 2);
        ticTacToeSystem.makeMove( 1, 0);
        ticTacToeSystem.makeMove( 1, 1);
        ticTacToeSystem.makeMove( 1, 2);
        ticTacToeSystem.makeMove( 2, 0);
        ticTacToeSystem.makeMove( 2, 1);
        ticTacToeSystem.makeMove( 2, 2);

        ticTacToeSystem.printScoreBoard();

        ticTacToeSystem.createGame(player1, player2, winningStrategies);

        ticTacToeSystem.makeMove( 0, 0);
        ticTacToeSystem.makeMove( 0, 1);
        ticTacToeSystem.makeMove( 0, 2);
        ticTacToeSystem.makeMove( 1, 0);
        ticTacToeSystem.makeMove( 1, 1);
        ticTacToeSystem.makeMove( 1, 2);
        ticTacToeSystem.makeMove( 2, 0);
        ticTacToeSystem.makeMove( 2, 1);
        ticTacToeSystem.makeMove( 2, 2);

        ticTacToeSystem.printScoreBoard();

    }

}
