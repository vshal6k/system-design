package algomaster.problems.notificationsystem.sender;

import algomaster.problems.notificationsystem.entities.NotificationRequest;

public interface Sender {
    public void send(NotificationRequest notificationRequest);
}
