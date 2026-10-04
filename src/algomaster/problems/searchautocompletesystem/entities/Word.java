package algomaster.problems.searchautocompletesystem.entities;

public class Word {
    private int count;
    private String value;

    public int getCount() {
        return count;
    }

    public String getValue() {
        return value;
    }

    public Word(int count, String value) {
        this.count = count;
        this.value = value;
    }
}
