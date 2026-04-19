package algomaster.problems.stackoverflow;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class User {
    private final String id;
    private final String name;
    private AtomicInteger reputation = new AtomicInteger();
    
    public User(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }

    public String getId(){
        return id;
    }

    public void updateReputation(int reputationChange){
        reputation.addAndGet(reputationChange);
    }

    @Override
    public boolean equals(Object object){
        if(object instanceof User user && user.id.equals(this.id)){
            return true;
        }else return false;
    }

    @Override
    public int hashCode(){
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", reputation=" + reputation + "]";
    }

}
