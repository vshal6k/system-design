package algomaster.designpatterns.bridge.messageformatter;

public abstract class Message {
    protected MessageSender messageSender;
    protected String content;

    public MessageSender getMessageSender() {
        return messageSender;
    }

    public String getContent() {
        return content;
    }

    public Message(MessageSender messageSender, String content){
        this.messageSender = messageSender;
        this.content = content;
    }

    public void send(){
        this.messageSender.send(content);
    }
}
