package algomaster.problems.notificationsystem.notification;

import java.util.UUID;

import algomaster.problems.notificationsystem.entities.User;
import algomaster.problems.notificationsystem.enums.Channel;

public abstract class Notification {
    private final String notificationId;
    private final User recipient;
    private final Channel channel;
    private final String subject;
    private final String body;

    public String getNotificationId() {
        return notificationId;
    }

    public User getRecipient() {
        return recipient;
    }

    public Channel getChannel() {
        return channel;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }

    public boolean send() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Notification sent to " + recipient.getUserName() + " through " + channel);
        return true;

    }

    protected Notification(NotificationBuilder notificationBuilder) {
        this.notificationId = UUID.randomUUID().toString();
        this.body = notificationBuilder.body;
        this.channel = notificationBuilder.channel;
        this.recipient = notificationBuilder.recipient;
        this.subject = notificationBuilder.subject;
    }

    public static class NotificationBuilder {
        private final User recipient;
        private final Channel channel;
        private final String body;
        private String subject;

        public NotificationBuilder(User recipient, Channel channel, String body) {
            this.recipient = recipient;
            this.channel = channel;
            this.body = body;
        }

        public NotificationBuilder subject(String subject) {
            this.subject = subject;
            return this;
        }

        public Notification build() {
            if (body == null)
                throw new IllegalArgumentException("Body cannot be null");
            if (recipient == null)
                throw new IllegalArgumentException("Receipient cannot be null");
            if (channel == null)
                throw new IllegalArgumentException("Channel cannot be null");

            Notification notification;

            switch (channel) {
                case EMAIL:
                    notification = new EmailNotification(this);
                    break;
                case PUSH:
                    notification = new PushNotification(this);
                    break;
                case SMS:
                    notification = new SMSNotification(this);
                    break;
                default:
                    notification = null;
                    break;
            }

            return notification;
        }
    }

    @Override
    public String toString() {
        return "Notification [recipient=" + recipient.getUserName() + ", channel=" + channel
                + ", subject=" + subject + ", body=" + body + "]";
    }

}
