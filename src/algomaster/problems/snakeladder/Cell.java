package algomaster.problems.snakeladder;

public class Cell {
    private final int number;
    private int ladderEnd = -1;
    private int snakeEnd = -1;

    public Cell(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public int getLadderEnd() {
        return ladderEnd;
    }

    public void setLadderEnd(int ladderEnd) {
        this.ladderEnd = ladderEnd;
    }

    public int getSnakeEnd() {
        return snakeEnd;
    }

    @Override
    public String toString() {
        return "(" + number + " LE: " + ladderEnd + " SE: " + snakeEnd + ")";
    }

    public void setSnakeEnd(int snakeEnd) {
        this.snakeEnd = snakeEnd;
    }

}
