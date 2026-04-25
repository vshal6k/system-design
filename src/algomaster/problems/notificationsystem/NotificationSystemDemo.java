package algomaster.problems.notificationsystem;

import algomaster.problems.notificationsystem.entities.User;
import algomaster.problems.notificationsystem.enums.Channel;
import algomaster.problems.notificationsystem.sender.EmailSender;
import algomaster.problems.notificationsystem.sender.PushSender;
import algomaster.problems.notificationsystem.sender.SMSSender;
import algomaster.problems.notificationsystem.senderregistry.SenderRegistry;

public class NotificationSystemDemo {
    public static void main(String[] args) throws InterruptedException {

        SenderRegistry senderRegistry = new SenderRegistry();
        senderRegistry.registerSender(Channel.EMAIL, new EmailSender());
        senderRegistry.registerSender(Channel.SMS, new SMSSender());
        senderRegistry.registerSender(Channel.PUSH, new PushSender());

        try (NotificationSystem notificationSystem = new NotificationSystem(senderRegistry);) {
            User vishal = new User("Vishal");
            User kanan = new User("Kanan");

            notificationSystem.sendNotification(kanan, Channel.EMAIL, "Request For Food", "Please give me food");

            notificationSystem.sendNotification(vishal, Channel.PUSH, "Request For Laptop", "Please give me laptop");

            notificationSystem.sendNotification(kanan, Channel.EMAIL, "Request For Food", "Please give me food");

            notificationSystem.sendNotification(vishal, Channel.PUSH, "Request For Laptop", "Please give me laptop");

            notificationSystem.sendNotification(kanan, Channel.EMAIL, "Request For Food", "Please give me food");

            notificationSystem.sendNotification(vishal, Channel.PUSH, "Request For Laptop", "Please give me laptop");

            notificationSystem.sendNotification(kanan, Channel.EMAIL, "Request For Food", "Please give me food");

            notificationSystem.sendNotification(vishal, Channel.PUSH, "Request For Laptop", "Please give me laptop");

            notificationSystem.sendNotification(kanan, Channel.EMAIL, "Request For Food", "Please give me food");

            notificationSystem.sendNotification(vishal, Channel.PUSH, "Request For Laptop", "Please give me laptop");

            notificationSystem.sendNotification(kanan, Channel.EMAIL, "Request For Food", "Please give me food");

            notificationSystem.sendNotification(vishal, Channel.PUSH, "Request For Laptop", "Please give me laptop");

            Thread.sleep(10000);
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
