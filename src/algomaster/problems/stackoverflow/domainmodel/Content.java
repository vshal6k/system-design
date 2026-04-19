package algomaster.problems.stackoverflow.domainmodel;

import java.time.LocalDateTime;
import java.util.UUID;

public abstract class Content {
    private final String id;
    protected final String body;
    private final User author;
    private final LocalDateTime creationTime;

    public Content(String body, User author) {
        this.id = UUID.randomUUID().toString();
        this.body = body;
        this.author = author;
        this.creationTime = LocalDateTime.now();
    }

    public String getId(){
        return id;
    }

    public String getBody(){
        return body;
    }

    public User getAuthor(){
        return author;
    }
}
