package algomaster.problems.stackoverflow;

import java.time.LocalDateTime;

import algomaster.problems.stackoverflow.enums.EventType;
import algomaster.problems.stackoverflow.enums.VoteType;

public class Answer extends Post {
    private boolean isAccepted;

    public Answer(String body, User author) {
        super(body, author);
    }

    public void setAccepted(boolean isAccepted) {
        this.isAccepted = isAccepted;
    }

    @Override
    public EventType getEventType(VoteType voteType) {
        if (VoteType.UPVOTE.equals(voteType))
            return EventType.UPVOTE_ANSWER;
        else
            return EventType.DOWNVOTE_ANSWER;
    }
    
}
