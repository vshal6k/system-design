package algomaster.problems.tictactoe;

public interface Observable {
    public void notifyObservers();
    public void addObserver(GameObserver o);
}
