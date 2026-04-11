package algomaster.designpatterns.bridge.messageformatter;

public class EmailSender implements MessageSender{

    @Override
    public void send(String content) {
        System.out.println("Email: " + content);
    }
    
}
