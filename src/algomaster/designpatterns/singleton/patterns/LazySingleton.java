package algomaster.designpatterns.singleton.patterns;

public class LazySingleton {
    //Lazy initialization, instance is initialised only when first requested
    //Thread unsafe as concurrent threads may create multiple instances
    private static LazySingleton instance;

    private LazySingleton(){};

    public static LazySingleton getInstance(){
        if(instance == null) instance = new LazySingleton();
        return instance;
    }
}
