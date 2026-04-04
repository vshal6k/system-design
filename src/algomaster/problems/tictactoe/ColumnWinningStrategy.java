package algomaster.problems.tictactoe;

public class ColumnWinningStrategy implements WinningStrategy{

    @Override
    public boolean checkWin(Board board, int row, int col, Symbol symbol) {
        for(int j = 0; j<col; j++){
            boolean allElementsIdentical = true;
            for(int i = 0; i < row; i++){
                if(board.getSymbol(i, j) != board.getSymbol(0, j)){
                    allElementsIdentical = false;
                    break;
                }
            }
            if(allElementsIdentical) return true;
        }
        return false;
    }
    
}
