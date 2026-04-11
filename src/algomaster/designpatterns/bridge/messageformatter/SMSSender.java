package algomaster.designpatterns.bridge.messageformatter;

public class SMSSender implements MessageSender{

    @Override
    public void send(String content) {
        System.out.println("SMS: " + content);
    }
    
}
