package algomaster.problems.notificationsystem;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import algomaster.problems.notificationsystem.entities.NotificationRequest;
import algomaster.problems.notificationsystem.entities.User;
import algomaster.problems.notificationsystem.enums.Channel;
import algomaster.problems.notificationsystem.sender.Sender;
import algomaster.problems.notificationsystem.senderregistry.SenderRegistry;

public class NotificationSystem implements AutoCloseable {
    public static final int MAX_RETRIES = 3;
    public static final long RETRY_DELAY = 3;

    private volatile boolean closed = false;
    private final SenderRegistry senderRegistry;
    private final ScheduledExecutorService retryScheduler;
    private final ExecutorService workerPool;

    public NotificationSystem(SenderRegistry senderRegistry) {
        closed = false;
        this.senderRegistry = senderRegistry;
        retryScheduler = Executors.newScheduledThreadPool(3);
        workerPool = Executors.newFixedThreadPool(3);
    }

    private void sendWithRetry(NotificationRequest request, int attempt) {
        Sender sender = senderRegistry.getSender(request.getChannel());

        try {
            sender.send(request);
        } catch (Exception e) {
            System.out.println("Error While Sending " + request.toString() + " Attempt: " + attempt  + 1);
            if (attempt >= MAX_RETRIES)
                return;

            if(closed) return;

            retryScheduler.schedule(
                    () -> workerPool.submit(
                            () -> sendWithRetry(request, attempt + 1)),
                    RETRY_DELAY, TimeUnit.SECONDS);
        }

    }

    private NotificationRequest createNotification(User recipient, Channel channel, String subject, String body) {
        NotificationRequest.NotificationBuilder builder = new NotificationRequest.

                NotificationBuilder(recipient, channel, body);

        if (subject != null)
            builder.subject(subject);

        return builder.build();
    }

    public void sendNotification(User recipient, Channel channel, String subject, String body) {
        if (closed)
            throw new IllegalStateException("Notification system is closed.");

        NotificationRequest notification = createNotification(recipient, channel, subject, body);
        workerPool.submit(() -> sendWithRetry(notification, 0));

    }

    @Override
    public void close() throws Exception {
        if (closed)
            throw new IllegalStateException("Notification system is closed.");

        closed = true;
        retryScheduler.shutdown();
        workerPool.shutdown();

        try {
            retryScheduler.awaitTermination(10, TimeUnit.SECONDS);
            workerPool.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            retryScheduler.shutdownNow();
            workerPool.shutdownNow();
        }

    }
}
