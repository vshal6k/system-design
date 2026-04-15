package algomaster.problems.snakeladder;

public class Ladder {
    private final int start;
    private final int end;

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public Ladder(int start, int end) {
        if (end <= start)
            throw new IllegalArgumentException("Ladder should start at a lower number and end at a higher number");
        this.start = start;
        this.end = end;
    }
}
