package Observable;

import Observer.NotificationAlertObserver;

public interface StockObservable {
    public void addObserver(NotificationAlertObserver notificationAlertObserver);
    public void removeObserver(NotificationAlertObserver notificationAlertObserver);
    public void notifyObservers();
    public void setQuantity(int quantity);
}
