package algomaster.problems.stackoverflow.domainmodel;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import algomaster.problems.stackoverflow.enums.EventType;
import algomaster.problems.stackoverflow.enums.VoteType;
import algomaster.problems.stackoverflow.event.Event;

public class Question extends Post {
    private final String title;
    private Answer acceptedAnswer;
    private final Set<Tag> tags;
    private final ConcurrentHashMap<String, Answer> answers = new ConcurrentHashMap<>();

    public Question(String body, User author, String title, Set<Tag> tags) {
        super(body, author);
        this.title = title;
        this.tags = Set.copyOf(tags);
    }

    public void addAnswer(Answer answer) {
        answers.put(answer.getId(), answer);
    }

    public boolean hasAnswer(Answer answer) {
        return answers.containsKey(answer.getId());
    }

    public synchronized void acceptAnswer(User user, Answer answer) {
        if (!this.hasAnswer(answer))
            throw new IllegalArgumentException("Question and answer are not related");

        if (!user.equals(this.getAuthor()))
            throw new IllegalArgumentException("Answers can only be accepted by question authors");

        if (this.acceptedAnswer != null) {
            throw new IllegalStateException("Question already has an accepted solution.");
        }

        this.acceptedAnswer = answer;
        notifyPostObservers(new Event(EventType.ACCEPT_ANSWER, this.getAuthor(), answer));
    }

    @Override
    public EventType getEventType(VoteType voteType) {
        if (VoteType.UPVOTE.equals(voteType))
            return EventType.UPVOTE_QUESTION;
        else
            return EventType.DOWNVOTE_QUESTION;
    }

    public String getTitle() {
        return title;
    }

    public Collection<Tag> getTags() {
        return Collections.unmodifiableCollection(tags);
    }

}
