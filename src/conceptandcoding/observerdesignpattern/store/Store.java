package observerdesignpattern.store;

import observerdesignpattern.observable.Chair;
import observerdesignpattern.observable.Phone;
import observerdesignpattern.observer.Observer;
import observerdesignpattern.observer.ObserverImpl;

public class Store {
    public static void main(String[] args) {

        //store has Samsung and Bajaj chair
        Chair bajajChair = new Chair("Bajaj");
        Phone samsungPhone = new Phone("Samsung S13");


        //Vishal named person wants to be notified over email for chair
        Observer vishalObserver = new ObserverImpl("Vishal");
        bajajChair.addObserver(vishalObserver);

        //Kanan named person wants to be notified over email for phone
        Observer kananObserver = new ObserverImpl("Kanan");
        samsungPhone.addObserver(kananObserver);

        //Het - email - chair
        Observer hetObserver = new ObserverImpl("Het");
        bajajChair.addObserver(hetObserver);

        //Ram - message - chair
        Observer ramObserver = new ObserverImpl("Ram");
        bajajChair.addObserver(ramObserver);

        bajajChair.notifyObservers();
        
        bajajChair.removeObserver(ramObserver);
        bajajChair.notifyObservers();
        
        samsungPhone.notifyObservers();
    }
}
