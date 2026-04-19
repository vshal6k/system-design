package algomaster.problems.stackoverflow.domainmodel;

import algomaster.problems.stackoverflow.enums.EventType;
import algomaster.problems.stackoverflow.enums.VoteType;

public class Answer extends Post {

    public Answer(String body, User author) {
        super(body, author);
    }

    @Override
    public EventType getEventType(VoteType voteType) {
        if (VoteType.UPVOTE.equals(voteType))
            return EventType.UPVOTE_ANSWER;
        else
            return EventType.DOWNVOTE_ANSWER;
    }
    
}
