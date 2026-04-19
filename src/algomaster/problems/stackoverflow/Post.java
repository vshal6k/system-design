package algomaster.problems.stackoverflow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import algomaster.problems.stackoverflow.dataclasses.Comment;
import algomaster.problems.stackoverflow.dataclasses.Event;
import algomaster.problems.stackoverflow.enums.EventType;
import algomaster.problems.stackoverflow.enums.VoteType;

public abstract class Post extends Content {
    private List<Comment> comments = new ArrayList<>();
    private Map<String, VoteType> voters = new HashMap<>();
    private AtomicInteger voteCount = new AtomicInteger();
    private List<PostObserver> postObservers = new ArrayList<>();

    public Post(String body, User author) {
        super(body, author);
    }

    public void addPostObserver(PostObserver postObserver) {
        postObservers.add(postObserver);
    }

    public void notifyPostObservers(Event event) {
        for (PostObserver postObserver : postObservers) {
            postObserver.onPostEvent(event);
        }
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public void vote(User user, VoteType voteType) {
        if (!voters.containsKey(user.getId())) {
            voters.put(user.getId(), voteType);
            notifyPostObservers(new Event(getEventType(voteType), user, this));
            if (VoteType.UPVOTE.equals(voteType))
                voteCount.incrementAndGet();
            else
                voteCount.decrementAndGet();

        } else
            throw new IllegalStateException("User can vote only once per post");
    }

    public abstract EventType getEventType(VoteType voteType);

    // Only for demo
    public void displayComments() {
        comments.stream().forEach(comment -> System.out.println(comment.getBody()));
    }

}
