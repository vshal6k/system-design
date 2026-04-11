package algomaster.designpatterns.weatherstation;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements Observable{
    private int temparature;
    private List<Observer> observers = new ArrayList<>();

    public int getTemparature() {
        return temparature;
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    @Override
    public void registerObserver(Observer o) {
        this.observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        this.observers.remove(o);
    }
    
    public void setTemparature(int temparature){
        this.temparature = temparature;
        notifyObservers();
    }
}
