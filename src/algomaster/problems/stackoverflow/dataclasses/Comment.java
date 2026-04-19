package algomaster.problems.stackoverflow.dataclasses;

import java.time.LocalDateTime;

import algomaster.problems.stackoverflow.Content;
import algomaster.problems.stackoverflow.User;

public class Comment extends Content{

    public Comment(String body, User author) {
        super(body, author);
    }
    
}
