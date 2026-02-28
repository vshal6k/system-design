package algomaster.association.socialnetwork;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {
    private String name;
    private Set<User> followers = new HashSet<>();
    private Set<User> following = new HashSet<>();
    private List<Message> messages = new ArrayList<>();

    public User(String name) {
        this.name = name;
    }

    public void follow(User user){
        if(!this.equals(user) && !this.following.contains(user)){
            this.following.add(user);
            user.followers.add(this);
        }
    }

    public String getName() {
        return name;
    }

    public Set<User> getFollowers() {
        return followers;
    }

    public Set<User> getFollowing() {
        return following;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void sendMessage(String content, LocalDateTime timeStamp){
        this.messages.add(new Message(content, timeStamp, this));
    }

    

}
