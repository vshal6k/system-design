package algomaster.problems.notificationsystem.sender;

import algomaster.problems.notificationsystem.entities.NotificationRequest;

public class SMSSender implements Sender {

    @Override
    public void send(NotificationRequest notificationRequest) {
        System.out.println("SMS notification sent to " + notificationRequest.getRecipient().getUserName());
    }

}
