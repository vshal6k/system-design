package algomaster.designpatterns.bridge.messageformatter;

public class UrgentMessageDecorator extends MessageDecorator{

    public UrgentMessageDecorator(Message message) {
        super(message);
    }

    @Override
    public void send(){
        String content = "[URGENT] " + super.message.getContent();
        super.messageSender.send(content);
    }
    
}
