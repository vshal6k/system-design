package algomaster.problems.stackoverflow;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class InteractiveContent extends Content {
    private int votes;

    private List<Comment> comments = new ArrayList<>();
    private Set<User> voters = new HashSet<>();

    public void validateVoter(User voter){
        if(voters.contains(voter)){
            throw new IllegalStateException("User can vote only once per post.");
        }
    } 

    public void upVote(User voter) {
        validateVoter(voter);
        voters.add(voter);
        votes++;
        super.author.increaseReputation();
    }

    public void downVote(User voter) {
        validateVoter(voter);
        voters.add(voter);
        votes--;
        super.author.decreaseReputation();
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public InteractiveContent(int id, User author, String title, String body) {
        super(id, author, title, body);
    }

}
