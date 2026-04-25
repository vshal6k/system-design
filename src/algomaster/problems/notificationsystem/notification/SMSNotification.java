package algomaster.problems.notificationsystem.notification;

public class SMSNotification extends Notification {

    protected SMSNotification(NotificationBuilder notificationBuilder) {
        super(notificationBuilder);
    }

    @Override
    public boolean send() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("SMS Notification sent to " + super.recipient.getUserName() + " through " + super.channel);
        return true;
    }

}
