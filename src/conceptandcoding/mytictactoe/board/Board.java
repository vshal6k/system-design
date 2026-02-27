package mytictactoe.board;

import java.util.ArrayList;
import mytictactoe.pieces.Piece;

public class Board {
    private static final int rows = 3;
    private static final int columns = 3;

    private ArrayList<ArrayList<Piece>> grid = new ArrayList<>();

    public Board() {
        for (int i = 0; i < Board.rows; i++) {
            ArrayList<Piece> newRow = new ArrayList<>();
            for (int j = 0; j < Board.columns; j++) {
                newRow.add(Piece.EMPTY);
            }
            grid.add(newRow);
        }
    }

    public void printBoard() {
        System.out.println();

        int index = 0;
        for (int i = 0; i < Board.rows; i++) {
            for (int j = 0; j < Board.columns; j++) {
                Piece currentPiece = this.grid.get(i).get(j);
                System.out.print(currentPiece.getSymbol() + "(" +index++ + ")");
                if (j != Board.columns - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public void addPiece(Piece piece, int i, int j) {
        grid.get(i).set(j, piece);
    }

    public boolean gameOver() {

        // 🔹 Check rows
        for (int i = 0; i < Board.rows; i++) {
            Piece first = grid.get(i).get(0);
            if (first == Piece.EMPTY)
                continue;

            boolean win = true;
            for (int j = 1; j < Board.columns; j++) {
                if (grid.get(i).get(j) != first) {
                    win = false;
                    break;
                }
            }
            if (win)
                return true;
        }

        // 🔹 Check columns
        for (int j = 0; j < Board.columns; j++) {
            Piece first = grid.get(0).get(j);
            if (first == Piece.EMPTY)
                continue;

            boolean win = true;
            for (int i = 1; i < Board.rows; i++) {
                if (grid.get(i).get(j) != first) {
                    win = false;
                    break;
                }
            }
            if (win)
                return true;
        }

        // 🔹 Check main diagonal (top-left → bottom-right)
        Piece firstDiag = grid.get(0).get(0);
        if (firstDiag != Piece.EMPTY) {
            boolean win = true;
            for (int i = 1; i < Board.rows; i++) {
                if (grid.get(i).get(i) != firstDiag) {
                    win = false;
                    break;
                }
            }
            if (win)
                return true;
        }

        // 🔹 Check anti-diagonal (top-right → bottom-left)
        Piece secondDiag = grid.get(0).get(Board.columns - 1);
        if (secondDiag != Piece.EMPTY) {
            boolean win = true;
            for (int i = 1; i < Board.rows; i++) {
                if (grid.get(i).get(Board.columns - 1 - i) != secondDiag) {
                    win = false;
                    break;
                }
            }
            if (win)
                return true;
        }

        return false; // no winner yet
    }

    public static void main(String[] args) {
        Board myBoard = new Board();
        myBoard.addPiece(Piece.X, 1, 2);
        myBoard.printBoard();
    }

}
