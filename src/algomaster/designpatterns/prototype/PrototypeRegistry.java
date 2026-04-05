package algomaster.designpatterns.prototype;

import java.util.HashMap;
import java.util.Map;

public class PrototypeRegistry {
    private Map<String, Prototype> prototypes = new HashMap<>();

    public void registerPrototype(String key, Prototype prototype){
        prototypes.put(key, prototype);
    }

    public Prototype getPrototypeInstance(String key){
        if(prototypes.get(key) == null) throw new IllegalArgumentException();
        return prototypes.get(key).clone();
    }
}
