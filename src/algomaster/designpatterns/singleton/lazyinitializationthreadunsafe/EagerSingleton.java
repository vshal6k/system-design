package algomaster.designpatterns.singleton.lazyinitializationthreadunsafe;

public class EagerSingleton {
    // No lazy initialisation, Thread safe.
    private final static EagerSingleton instance = new EagerSingleton();

    private EagerSingleton() {
    };

    public static EagerSingleton getInstance() {
        return instance;
    }
}
