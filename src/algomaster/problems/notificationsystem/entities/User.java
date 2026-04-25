package algomaster.problems.notificationsystem.entities;

import java.util.UUID;

public class User {
    private final String userId;
    private final String userName;

    public String getUserId() {
        return userId;
    }

    public User(String userName) {
        this.userId = UUID.randomUUID().toString();
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

}
