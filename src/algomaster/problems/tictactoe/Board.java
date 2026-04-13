package algomaster.problems.tictactoe;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int totalRows;
    private int totalCols;
    private List<List<Cell>> grid = new ArrayList<>();
    private int totalCells;
    private int cellsFilled;

    public Board(int totalRows, int totalCols){

        if(totalCols <= 0 || totalRows <= 0) {
            throw new IllegalArgumentException("Please provide a valid value for total number of rows and columns.");
        }

        this.totalRows = totalRows;
        this.totalCols = totalCols;
        this.totalCells = totalCols * totalCols;
        this.cellsFilled = 0;

        for(int i = 0; i < totalRows; i++){
            grid.add(new ArrayList<>());
            for(int j = 0; j < totalCols; j++){
                grid.get(i).add(new Cell());
            }
        }
        
    }

    public int getTotalRows() {
        return totalRows;
    }

    public int getTotalCols() {
        return totalCols;
    }

    public int getTotalCells() {
        return totalCells;
    }

    public int getCellsFilled() {
        return cellsFilled;
    }

    public boolean validateRow(int row){
        if(row >= 0 && row < totalRows) return true;
        else throw new IllegalArgumentException("Please provide a valid value for row.");
    }

    public boolean validateColumn(int column){
        if (column >= 0 && column < totalCols) return true;
        else throw new IllegalArgumentException("Please provide a valid value for column.");
    }

    public Symbol getSymbol(int row, int col){
        validateRow(row);
        validateColumn(col);
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
        validateRow(row);
        validateColumn(col);
        this.grid.get(row).set(col, new Cell(symbol));
        this.cellsFilled++;
    }

    public boolean isFull(){
        return totalCells == cellsFilled;
    }

    public static void main(String[] args) {
        Board myBoard = new Board(5, 5);
        myBoard.printBoard();
        System.out.println(myBoard.isFull());
        myBoard.addSymbol(0, 1, Symbol.O);
        myBoard.printBoard();
        System.out.println(myBoard.getSymbol(0, 0));
    }
    
}
