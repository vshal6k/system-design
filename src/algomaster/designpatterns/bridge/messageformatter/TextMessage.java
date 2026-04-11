package algomaster.designpatterns.bridge.messageformatter;

public class TextMessage extends Message{

    public TextMessage(MessageSender messageSender, String content) {
        super(messageSender, content);
    }
    
}
