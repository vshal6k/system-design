package mycarrentalsystem.usermanagement;

import java.util.HashMap;

public class InMemoryUserRepository implements UserRepository {
    private HashMap<String, User> users = new HashMap<>();

    public void registerUser(String userName, User user) {
        users.put(userName, user);
    }

    public User findUser(String userName) {
        return users.get(userName);
    }

}
