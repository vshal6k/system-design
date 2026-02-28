package algomaster.association.socialnetwork;

import java.time.LocalDateTime;

public class Message {
    private String content;
    private LocalDateTime timeStamp;
    private User author;
    
    public Message(String content, LocalDateTime timeStamp, User author) {
        this.content = content;
        this.timeStamp = timeStamp;
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public User getAuthor() {
        return author;
    }
    
}
