package algomaster.problems.notificationsystem.entities;

import java.util.UUID;

import algomaster.problems.notificationsystem.enums.Channel;

public class NotificationRequest {
    private final String notificationId;
    protected final User recipient;
    protected final Channel channel;
    private final String subject;
    private final String body;

    public String getNotificationId() {
        return notificationId;
    }

    @Override
	public String toString() {
		return "NotificationRequest [recipient=" + recipient.getUserName() + ", channel="
				+ channel + ", subject=" + subject + ", body=" + body + "]";
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

    protected NotificationRequest(NotificationBuilder notificationBuilder) {
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

        public NotificationRequest build() {
            if (body == null)
                throw new IllegalArgumentException("Body cannot be null");
            if (recipient == null)
                throw new IllegalArgumentException("Receipient cannot be null");
            if (channel == null)
                throw new IllegalArgumentException("Channel cannot be null");

            return new NotificationRequest(this);
        }
    }

}
