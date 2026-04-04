package algomaster.problems.tictactoe;

public class RowWinningStrategy implements WinningStrategy {

    @Override
    public boolean checkWin(Board board, int row, int col, Symbol symbol) {
        //What is the algorithm?
        //Go through each row
        //Check whether the row has all identical elements
        //If yes return true, else check the next row
        //Return false if no row has all elements same
        for(int i = 0; i < row; i++){
            boolean allElementsIdentical = true;
            //Assume that all elements are identical to the first element
            for(int j = 0; j < col; j++){
                if(board.getSymbol(i, j) != board.getSymbol(i, 0)){
                    allElementsIdentical = false;
                    break;
                }
            }
            if(allElementsIdentical){
                return true;
            }
        }
        return false;
    }
    
}
