package algomaster.problems.notificationsystem.notification;

public class PushNotification extends Notification {

    protected PushNotification(NotificationBuilder notificationBuilder) {
        super(notificationBuilder);
    }

    @Override
    public boolean send() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Push Notification sent to " + super.recipient.getUserName() + " through " + super.channel);
        return true;
    }

}
