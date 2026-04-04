package algomaster.problems.tictactoe;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private List<List<Cell>> grid = new ArrayList<>();
    private int totalCells;
    private int cellsFilled;

    public Board(int row, int col){
        for(int i = 0; i < row; i++){
            grid.add(new ArrayList<>());
            for(int j = 0; j < col; j++){
                grid.get(i).add(new Cell());
            }
        }
        this.totalCells = row*col;
        this.cellsFilled = 0;
    }

    public Symbol getSymbol(int row, int col){
        return this.grid.get(row).get(col).getSymbol();
    }

    public void printBoard(){
        for (List<Cell> list : grid) {
            for (Cell cell : list) {
                System.out.print(cell.getSymbol().toString() + " ");
            }
            System.out.println();
        }
    }

    public void addSymbol(int row, int col, Symbol symbol){
        
    }

    public boolean isFull(){
        return totalCells == cellsFilled;
    }

}
