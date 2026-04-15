package algomaster.problems.snakeladder;

public class Snake {
    private final int start;
    private final int end;

    public Snake(int start, int end) {
        if (end >= start)
            throw new IllegalArgumentException("Snake should start at a higher number and end at a lower number.");
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

}
