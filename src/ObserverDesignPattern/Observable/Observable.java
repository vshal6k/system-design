package ObserverDesignPattern.Observable;

import ObserverDesignPattern.Observer.Observer;

public interface Observable {
    public void addObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void notifyObservers();
}
