package algomaster.problems.tictactoe;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int totalRows;
    private int totalCols;
    private List<List<Cell>> grid = new ArrayList<>();
    private int totalCells;
    private int cellsFilled;

    public Board(int totalRows, int totalCols) {

        if (totalCols <= 0 || totalRows <= 0) {
            System.out.println("Please provide a valid value for total number of rows and columns.");
            return;
        }

        this.totalRows = totalRows;
        this.totalCols = totalCols;
        this.totalCells = totalRows * totalCols;
        this.cellsFilled = 0;

        for (int i = 0; i < totalRows; i++) {
            grid.add(new ArrayList<>());
            for (int j = 0; j < totalCols; j++) {
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

    public boolean isValidIndex(int row, int col){
        if (row < 0 || row >= totalRows) {
            System.out.println("Please provide a valid value for row.");
            return false;
        }
        if (col < 0 || col >= totalCols) {
            System.out.println("Please provide a valid value for column.");
            return false;
        }
        return true;
    }

    public boolean isValidMove(int row, int col) {
        if(!isValidIndex(row ,col)) return false;

        if (!this.grid.get(row).get(col).isEmpty()) {
            System.out.println("Please choose an empty cell.");
            return false;
        }
        return true;
    }

    public Symbol getSymbol(int row, int col) {
        Symbol symbol = null;
        if (isValidIndex(row, col)) {
            symbol = this.grid.get(row).get(col).getSymbol();
        }
        return symbol;
    }

    public void printBoard() {
        for (List<Cell> list : grid) {
            for (Cell cell : list) {
                System.out.print(cell.getSymbol().toString() + " ");
            }
            System.out.println();
        }
    }

    public boolean addSymbol(int row, int col, Symbol symbol) {
        if (isValidMove(row, col)) {
            this.grid.get(row).set(col, new Cell(symbol));
            this.cellsFilled++;
            return true;
        } else
            return false;
    }

    public boolean isFull() {
        return totalCells == cellsFilled;
    }

    public static void main(String[] args) {
        Board myBoard = new Board(5, 5);
        // myBoard.printBoard();
        // System.out.println(myBoard.isFull());
        // myBoard.addSymbol(-1, 1, Symbol.O);
        // myBoard.printBoard();
        System.out.println(myBoard.getSymbol(-1, 0));
    }

}
