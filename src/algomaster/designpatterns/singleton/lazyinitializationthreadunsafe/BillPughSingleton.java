package algomaster.designpatterns.singleton.lazyinitializationthreadunsafe;

public class BillPughSingleton {
    //Lazy laoding, Performant, Thread safe
    private BillPughSingleton(){};

    private static class Holder{
        private static final BillPughSingleton instance = new BillPughSingleton();
    }

    public BillPughSingleton getInstance(){
        return Holder.instance;
    }
}
