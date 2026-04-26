package algomaster.problems.splitwise.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class Group {
    private final String groupId;
    private final String groupName;
    private final Map<String, PaymentActivity> activities = new ConcurrentHashMap<>();
    private final Map<String, User> users = new ConcurrentHashMap<>();

    public Group(String groupName, List<User> users) {
        this.groupId = UUID.randomUUID().toString();
        this.groupName = groupName;
        addUsers(users);
    }

    public List<User> getUsers() {
        return new ArrayList<>(users.values());
    }

    public String getGroupId() {
        return groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    private void addUsers(List<User> users) {
        for (User user : users) {
            this.users.put(user.getUserId(), user);
        }
    }

    public void addActivity(PaymentActivity paymentActivity) {
        activities.put(paymentActivity.getId(), paymentActivity);
    }

}
