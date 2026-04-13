package algomaster.problems.tictactoe;

public class RowWinningStrategy implements WinningStrategy {

    @Override
    public boolean checkWin(Board board, int row, int col) {

        if(board.getSymbol(row, col).equals(Symbol.EMPTY)) return false;

        int totalCols = board.getTotalCols();

        //Row Winning Strategy 
        //Player has just put a symbol at row,col
        //Iterate through the row with index row, becuase row is where player put the current piece
        // and check if all the elements are same as board[row][col]

        for(int j = 0; j < totalCols; j++){
            if(board.getSymbol(row, j) != board.getSymbol(row, col)){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Board board = new Board(3, 3);
        board.addSymbol(0, 0, Symbol.X);
        board.addSymbol(0, 1, Symbol.X);
        board.addSymbol(0, 2, Symbol.X);

        System.out.println(new RowWinningStrategy().checkWin(board, 1, 0));
    }
    
}
