package observerdesignpattern.observer;

public class ObserverImpl implements Observer{
    String name;

    public ObserverImpl(String name){
        this.name = name;
    }

    @Override
    public void update() {
        System.out.println(name + " Updated");
    }
}
