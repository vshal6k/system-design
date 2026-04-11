package algomaster.designpatterns.bridge.messageformatter;

public abstract class MessageDecorator extends Message{

    protected Message message;

    public MessageDecorator(Message message) {
        super(message.getMessageSender(), message.getContent());
        this.message = message;
    }
    
}
