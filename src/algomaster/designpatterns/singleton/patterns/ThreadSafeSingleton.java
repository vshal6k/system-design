package algomaster.designpatterns.singleton.patterns;

public class ThreadSafeSingleton {
    //Lazy initialization, instance is initialised only when first requested
    //Thread safe, but not performant because even after instance is created, threads read sequentially
    private static volatile ThreadSafeSingleton instance;

    private ThreadSafeSingleton(){};

    public static synchronized ThreadSafeSingleton getInstance(){
        if(instance == null) instance = new ThreadSafeSingleton();
        return instance;
    }

}
    