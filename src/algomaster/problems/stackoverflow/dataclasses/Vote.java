package algomaster.problems.stackoverflow.dataclasses;

import algomaster.problems.stackoverflow.Post;
import algomaster.problems.stackoverflow.User;
import algomaster.problems.stackoverflow.enums.VoteType;

public class Vote {
    private final User voter;
    private final VoteType voteType;
    private final Post post;

    public Vote(User voter, VoteType voteType, Post post) {
        this.voter = voter;
        this.voteType = voteType;
        this.post = post;
    }

    public User getVoter() {
        return voter;
    }

    public VoteType getVoteType() {
        return voteType;
    }

    public Post getContent() {
        return post;
    }

}
