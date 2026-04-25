package algomaster.problems.notificationsystem.sender;

import algomaster.problems.notificationsystem.entities.NotificationRequest;

public class PushSender implements Sender {

    @Override
    public void send(NotificationRequest notificationRequest) {
        System.out.println("Push notification sent to " + notificationRequest.getRecipient().getUserName());
    }

}
