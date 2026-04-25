package algomaster.problems.notificationsystem;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import algomaster.problems.notificationsystem.entities.User;
import algomaster.problems.notificationsystem.enums.Channel;
import algomaster.problems.notificationsystem.notification.Notification;

public class NotificationSystem {
    private final Queue<Notification> notificationSendQueue = new ConcurrentLinkedQueue<>();
    public static final int MAX_RETRIES = 3;
    public static final long RETRY_DELAY = 3000;
    private final ExecutorService executorService = Executors.newFixedThreadPool(3);

    private final Runnable notificationSendingTask = () -> {
        if (notificationSendQueue.isEmpty())
            return;

        Notification notification = notificationSendQueue.poll();
        int retryCount = 0;
        while (retryCount < NotificationSystem.MAX_RETRIES + 1) {
            if (retryCount > 0) {
                System.out.println("Notification: " + notification.toString() + " Retry Count:" + retryCount);
                try {
                    Thread.sleep(RETRY_DELAY);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            if (notification.send())
                break;
            retryCount++;
        }

    };

    private Notification createNotification(User recipient, Channel channel, String subject, String body) {
        Notification.NotificationBuilder builder = new Notification.NotificationBuilder(recipient, channel, body);

        if (subject != null)
            builder.subject(subject);

        return builder.build();
    }

    public void sendNotification(User recipient, Channel channel, String subject, String body) {
        Notification notification = createNotification(recipient, channel, subject, body);
        notificationSendQueue.add(notification);
        executorService.submit(notificationSendingTask);
    }

    public synchronized void closeSystem() {
        if (!this.executorService.isShutdown()) {
            this.executorService.shutdown();
        } else
            throw new IllegalStateException("Notification system is closed already.");
    }
}
