package algomaster.problems.tictactoe;

public class Cell {
    private Symbol symbol = Symbol.EMPTY;

    public Cell(Symbol symbol){
        this.symbol = symbol;
    }

    public Cell(){
        this(Symbol.EMPTY);
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public boolean isEmpty(){
        return this.symbol.equals(Symbol.EMPTY);
    }
    
}
