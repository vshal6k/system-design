package mytictactoe.players;

import mytictactoe.pieces.Piece;

public class Player {
    public String name;
    public Piece piece;

    public Player(String name, Piece piece){
        this.name = name;
        this.piece = piece;
    }
}
