package algomaster.problems.stackoverflow.domainmodel;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import algomaster.problems.stackoverflow.enums.EventType;
import algomaster.problems.stackoverflow.enums.VoteType;
import algomaster.problems.stackoverflow.event.Event;
import algomaster.problems.stackoverflow.event.PostObserver;


public abstract class Post extends Content {
    private final List<Comment> comments = new CopyOnWriteArrayList<>();
    private final ConcurrentHashMap<String, VoteType> voters = new ConcurrentHashMap<>();
    private final AtomicInteger voteCount = new AtomicInteger();
    private final CopyOnWriteArrayList<PostObserver> postObservers = new CopyOnWriteArrayList<>();

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

    public synchronized void vote(User user, VoteType voteType) {
        String userId = user.getId();

        if(voters.get(userId) == voteType) return;

        int scoreChange = 0;
        if(voters.containsKey(userId)){
            //User is changing theri vote
            scoreChange = (voteType == VoteType.UPVOTE)? 2: -2;
        }else{
            //User is voting for the first time
            scoreChange = (voteType == VoteType.UPVOTE)? 1: -1;
        }

        voteCount.addAndGet(scoreChange);
        voters.put(userId, voteType);
        notifyPostObservers(new Event(getEventType(voteType), user, this));
    }

    public abstract EventType getEventType(VoteType voteType);

    // Only for demo
    public void displayComments() {
        comments.stream().forEach(comment -> System.out.println(comment.getBody()));
    }

}
