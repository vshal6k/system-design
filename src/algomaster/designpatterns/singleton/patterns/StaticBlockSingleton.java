package algomaster.designpatterns.singleton.patterns;

public class StaticBlockSingleton {
    //Similar to Eager initialisation, but useful for handling exceptions while instance creation
    //Same drawback as Eager initialisation
    private static StaticBlockSingleton instance;

    private StaticBlockSingleton(){};

    static{
        try {
            instance = new StaticBlockSingleton();
        } catch (Exception e) {
            System.out.println("Exception in instance creation.");
        }
    }

    public static StaticBlockSingleton getInstance(){
        return instance;
    }
}
