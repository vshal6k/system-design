package algomaster.problems.tictactoe;

public interface WinningStrategy {
    public boolean checkWin(Board board, int row, int col);
}
