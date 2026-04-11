package algomaster.designpatterns.weatherstation;

public interface Observable {
    public void notifyObservers();
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
}
