package algomaster.problems.notificationsystem.sender;

import algomaster.problems.notificationsystem.entities.NotificationRequest;

public class EmailSender implements Sender {

    @Override
    public void send(NotificationRequest notificationRequest) {
        // System.out.println("Email notification sent to " + notificationRequest.getRecipient().getUserName());
        throw new RuntimeException();
    }

}
