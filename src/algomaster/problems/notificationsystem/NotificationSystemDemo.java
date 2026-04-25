package algomaster.problems.notificationsystem;

import algomaster.problems.notificationsystem.entities.User;
import algomaster.problems.notificationsystem.enums.Channel;

public class NotificationSystemDemo {
    public static void main(String[] args) throws InterruptedException {
        NotificationSystem notificationSystem = new NotificationSystem();
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

        notificationSystem.closeSystem();

    }
}
