package algomaster.problems.snakeladder;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final int dimension;
    private final List<Snake> snakes;
    private final List<Ladder> ladders;
    private final List<Cell> cells = new ArrayList<>();

    public Board(int dimension, List<Snake> snakes, List<Ladder> ladders) {
        this.dimension = dimension;
        this.snakes = snakes;
        this.ladders = ladders;
        initializeCells(dimension * dimension, snakes, ladders);
        validateCells();
    }

    private void initializeCells(int size, List<Snake> snakes, List<Ladder> ladders) {
        for (int i = 0; i < size; i++) {
            cells.add(new Cell(i + 1));
        }
        for (Snake snake : snakes) {
            int start = snake.getStart();
            int end = snake.getEnd();
            validateSnakeStartEnd(start, end);
            cells.get(start - 1).setSnakeEnd(end);
        }
        for (Ladder ladder : ladders) {
            int start = ladder.getStart();
            int end = ladder.getEnd();
            validateLadderStartEnd(start, end);
            cells.get(start - 1).setLadderEnd(end);
        }
    }

    private void validateCells(){
        for (Cell cell : cells) {
            if(cell.getLadderEnd() != -1 && cell.getSnakeEnd() != -1)
                throw new IllegalArgumentException("A snake and ladder start at the same cell.");
        }
    }

    private void validateSnakeStartEnd(int start, int end) {
        if (!validateStartEnd(start, end))
            throw new IllegalArgumentException("Provide a valid value for snake start and end position.");
    }

    private void validateLadderStartEnd(int start, int end) {
        if (!validateStartEnd(start, end))
            throw new IllegalArgumentException("Provide a valid value for ladder start and end position.");
    }

    private boolean validateStartEnd(int start, int end) {
        int size = dimension * dimension;
        return (start > 0 && start <= size && end > 0 && end <= size);
    }

    public void printBoard() {
        int index = 0;
        StringBuilder board = new StringBuilder();
        boolean reverse = false;

        for (int i = 0; i < dimension; i++) {

            StringBuilder row = new StringBuilder();
            StringBuilder rowReversed = new StringBuilder();

            for (int j = 0; j < dimension; j++) {
                String cellContent = cells.get(index++).toString();
                row.append(cellContent + " ");
                rowReversed.insert(0, cellContent + " ");
            }

            if (reverse)
                board.insert(0, rowReversed + "\n");
            else
                board.insert(0, row + "\n");

            reverse = !reverse;
        }
        System.out.println(board);
    }

    public int getSize() {
        return dimension * dimension;
    }

    public int move(int start, int distance, StringBuilder log) {
        int size = dimension * dimension;
        int end = start + distance;
        log.append("Player moved by " + distance + " position.\n");
        while (end <= size && (cells.get(end - 1).getSnakeEnd() != -1 || cells.get(end - 1).getLadderEnd() != -1)) {
            // end is on the board and snake or ladder is present
            int snakeEnd = cells.get(end - 1).getSnakeEnd();
            int ladderEnd = cells.get(end - 1).getLadderEnd();
            end = (snakeEnd != -1) ? snakeEnd : ladderEnd;
            if(snakeEnd != -1){
                log.append("Snake ate the player and ejected it at " + snakeEnd + "\n");
                end = snakeEnd;
            }else{
                log.append("Player climbed the ladder and reached " + ladderEnd + "\n");
                end = ladderEnd;
            }
        }
        return end;
    }

    public static void main(String[] args) {
        Snake snake1 = new Snake(8, 6);
        Snake snake2 = new Snake(9, 2);
        List<Snake> snakes = List.of(snake1, snake2);

        Ladder ladder1 = new Ladder(3, 8);
        Ladder ladder2 = new Ladder(2, 3);
        List<Ladder> ladders = List.of(ladder1, ladder2);

        Board board = new Board(10, snakes, ladders);
        // board.printBoard();
        System.out.println(board.move(1, 1, new StringBuilder()));
    }

}
