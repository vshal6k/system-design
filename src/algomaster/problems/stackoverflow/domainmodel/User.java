package algomaster.problems.stackoverflow.domainmodel;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class User {
    private final String id;
    private final String name;
    private final AtomicInteger reputation;
    
    public User(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.reputation = new AtomicInteger(0);
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
    
    public String getId(){
        return id;
    }
    
    public String getName() {
        return name;
    }

    public int getReputation() {
        return reputation.intValue();
    }

}
