package algomaster.problems.notificationsystem.senderregistry;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import algomaster.problems.notificationsystem.enums.Channel;
import algomaster.problems.notificationsystem.sender.Sender;

public class SenderRegistry {
    private Map<Channel, Sender> senders = new ConcurrentHashMap<>();

    public void registerSender(Channel channel, Sender sender) {
        senders.put(channel, sender);
    }

    public Sender getSender(Channel channel) {
        Sender sender = senders.get(channel);
        if (sender == null)
            throw new IllegalArgumentException("No sender registered for channel");
        return sender;
    }

}
