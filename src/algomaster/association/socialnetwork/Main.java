package algomaster.association.socialnetwork;

import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        User vishal = new User("Vishal");
        User kanan = new User("Kanan");
        User het = new User("Het");
        User anshit = new User("Anshit");

        kanan.follow(vishal);
        het.follow(vishal);
        anshit.follow(vishal);

        vishal.follow(kanan);
        anshit.follow(kanan);

        vishal.follow(anshit);

        vishal.follow(het);

        vishal.sendMessage("Hello frens!!", LocalDateTime.now());

        kanan.sendMessage("I will be absent today", LocalDateTime.now().plusDays(1));

        het.sendMessage("Kem Palty!!!", LocalDateTime.now().minusDays(2));

        anshit.sendMessage("Haha", LocalDateTime.now().plusDays(5));

        List<User> users = List.of(vishal, kanan, het, anshit);
        users.stream().forEach(user -> {
            System.out.println("User: " + user.getName());

            System.out.println("Followers:");
            user.getFollowers().forEach(follower -> System.out.println(follower.getName()));

            System.out.println("Following:");
            user.getFollowing().forEach(follower -> System.out.println(follower.getName()));

            System.out.println("Messages:");
            user.getMessages().forEach(message -> System.out.println(
                    message.getContent() + " " + message.getAuthor().getName() + " " + message.getTimeStamp().toString()));
        });

    }
}
