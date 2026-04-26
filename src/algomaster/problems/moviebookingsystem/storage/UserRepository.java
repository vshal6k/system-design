package algomaster.problems.moviebookingsystem.storage;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import algomaster.problems.moviebookingsystem.entities.User;

public class UserRepository {
    private Map<String, User> users = new ConcurrentHashMap<>();

    public User createUser(String name) {
        User user = new User(name);
        users.put(user.getId(), user);
        return user;
    }

    public User getUser(String userId) {
        User user = users.get(userId);
        if (user == null)
            throw new IllegalArgumentException("User not found.");
        return user;
    }
}
