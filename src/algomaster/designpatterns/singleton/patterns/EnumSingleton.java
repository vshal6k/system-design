package algomaster.designpatterns.singleton.patterns;

public enum EnumSingleton {
    //Thread Safe, Performant, Lazy Initialization, Reflection Safe
    //Cannot extend other classes
    //Other methods are Serialization and Reflection unsafe
    INSTANCE;

    public static void main(String[] args) {
        EnumSingleton instance = EnumSingleton.INSTANCE;
    }
}
