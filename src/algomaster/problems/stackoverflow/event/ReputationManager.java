package algomaster.problems.stackoverflow.event;

import algomaster.problems.stackoverflow.domainmodel.Post;
import algomaster.problems.stackoverflow.domainmodel.User;

public class ReputationManager implements PostObserver{
    public static final int QUESTION_UPVOTE_REP = 5;
    public static final int ANSWER_UPVOTE_REP = 10;
    public static final int QUESTION_DOWNVOTE_REP = -5;
    public static final int ANSWER_DOWNVOTE_REP = -5;
    public static final int ANSWER_ACCEPTED_REP = 10;

    @Override
    public void onPostEvent(Event event) {
        Post targetPost = event.getTarget();
        User targetUser = targetPost.getAuthor();

        switch (event.getEventType()) {
            case UPVOTE_ANSWER:
                targetUser.updateReputation(ANSWER_UPVOTE_REP);
                break;
            case DOWNVOTE_ANSWER:
                targetUser.updateReputation(ANSWER_DOWNVOTE_REP);
                break;
            case UPVOTE_QUESTION:
                targetUser.updateReputation(QUESTION_UPVOTE_REP);
                break;
            case DOWNVOTE_QUESTION:
                targetUser.updateReputation(QUESTION_DOWNVOTE_REP);
                break;
            case ACCEPT_ANSWER:
                targetUser.updateReputation(ANSWER_ACCEPTED_REP);
                break;
        }
    }
    
}
