package algomaster.designpatterns.singleton.patterns;

public class DoubleCheckedSingleton {
    //Lazy initialisation, Performant, Thread Safe
    private static volatile DoubleCheckedSingleton instance;
    private static Object lock = new Object();

    private DoubleCheckedSingleton() {
    };

    public static DoubleCheckedSingleton getInstance() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new DoubleCheckedSingleton();
                }
            }
        }
        return instance;
    }

}
