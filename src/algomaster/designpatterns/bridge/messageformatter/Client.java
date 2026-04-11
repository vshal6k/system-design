package algomaster.designpatterns.bridge.messageformatter;

public class Client {
    public static void main(String[] args) {
        MessageSender email = new EmailSender();
        MessageSender sms = new SMSSender();

        Message m1 = new TextMessage(sms, "Hello World!");
        m1.send();

        Message m1_urgent = new UrgentMessageDecorator(m1);
        m1_urgent.send();

        Message m2 = new TextMessage(email, "Hello Folks!");
        m2.send();

        Message m2_urgent = new UrgentMessageDecorator(m2);
        m2_urgent.send();

    }
}
