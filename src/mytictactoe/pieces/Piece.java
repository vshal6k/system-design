package mytictactoe.pieces;

public enum Piece {
    X("X"),O("O"),EMPTY("_");

    private String symbol;

    private Piece(String symbol){
        this.symbol = symbol;
    }

    public String getSymbol(){
        return this.symbol;
    }
}
