package algomaster.problems.tictactoe;

public class ColumnWinningStrategy implements WinningStrategy {

    @Override
    public boolean checkWin(Board board, int row, int col) {
        if (board.getSymbol(row, col).equals(Symbol.EMPTY))
            return false;

        int totalRows = board.getTotalRows();

        // Column Winning Strategy
        // Player has just put a symbol at row,col
        // Iterate through the column with index col, becuase row,col is where player
        // put the current piece
        // and check if all the elements are same as board[row][col]

        for (int i = 0; i < totalRows; i++) {
            if (board.getSymbol(i, col) != board.getSymbol(row, col)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Board board = new Board(3, 3);
        board.addSymbol(0, 0, Symbol.X);
        board.addSymbol(1, 0, Symbol.X);
        board.addSymbol(2, 0, Symbol.X);

        board.printBoard();

        System.out.println(new ColumnWinningStrategy().checkWin(board, 1, 1));
    }

}
