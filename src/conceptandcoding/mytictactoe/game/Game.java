package mytictactoe.game;

import java.util.Scanner;

import mytictactoe.board.Board;
import mytictactoe.pieces.Piece;
import mytictactoe.players.Player;

public class Game {

    private Board board;
    private Player player1;
    private Player player2;
    private int currentTurn;

    public Game() {
        this.board = new Board();
        this.currentTurn = 1;
    }

    private void changeTurn(int currentTurn) {
        if (this.currentTurn == 1)
            this.currentTurn = 2;
        else
            this.currentTurn = 1;
    }

    private void initialisePlayers(Scanner scanner) {
        System.out.print("Enter name for player 1: ");
        String player1Name = scanner.nextLine();
        this.player1 = new Player(player1Name, Piece.X);

        System.out.print("Enter name for player 2: ");
        String player2Name = scanner.nextLine();
        this.player2 = new Player(player2Name, Piece.O);
    }

    public void startGame() {
        System.out.println("Welcome to Vishal's Tic Tac Toe Game");
        Scanner scanner = new Scanner(System.in);

        initialisePlayers(scanner);
        int moves = 0;

        boolean gameOver = false;
        while (!gameOver && moves != 9) {
            board.printBoard();
            System.out.println((this.currentTurn == 1 ? player1.name : player2.name)
                    + "'s turn to fill with "
                    + (this.currentTurn == 1 ? player1.piece : player2.piece));

            System.out.print("Choose Your Box(0-8): ");

            int index = scanner.nextInt();

            int row = index / 3;
            int col = index % 3;

            board.addPiece((this.currentTurn == 1 ? player1.piece : player2.piece), row, col);
            moves++;

            if (board.gameOver()) {
                gameOver = true;
                break;
            }
            changeTurn(this.currentTurn);
        }
        board.printBoard();
        if (gameOver) {
            System.out.println((this.currentTurn == 1 ? player1.name : player2.name) + " Wins");
        } else {
            System.out.println("It is a Draw");
        }
        scanner.close();
    }

    public static void main(String[] args) {
        Game myGame = new Game();
        myGame.startGame();
    }
}
