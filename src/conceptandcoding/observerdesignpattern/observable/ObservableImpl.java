package observerdesignpattern.observable;

import java.util.ArrayList;
import java.util.List;

import observerdesignpattern.observer.Observer;

public class ObservableImpl implements Observable {
    private List<Observer> subscribers = new ArrayList<>();

    @Override
    public void addObserver(Observer observer) {
        subscribers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        subscribers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : subscribers) {
            observer.update();
        }
    }

}
