package algomaster.problems.stackoverflow;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import algomaster.problems.stackoverflow.dataclasses.Event;
import algomaster.problems.stackoverflow.dataclasses.Tag;
import algomaster.problems.stackoverflow.enums.EventType;
import algomaster.problems.stackoverflow.enums.VoteType;

public class Question extends Post{
    private String title;
    private Answer acceptedAnswer;
    private Set<Tag> tags = new HashSet<>();
    private Map<String, Answer> answers = new HashMap<>();


    public Question(String body, User author, String title, Set<Tag> tags) {
        super(body, author);
        this.title = title;
        this.tags = tags;
    }

    public void addAnswer(Answer answer){
        answers.put(answer.getId(), answer);
    }
    
    public boolean hasAnswer(Answer answer) {
        return answers.containsKey(answer.getId());
    }
    public void acceptAnswer(Answer answer){
        this.acceptedAnswer = answer;
        notifyPostObservers(new Event(EventType.ACCEPT_ANSWER, this.getAuthor(), answer));
    }

    public boolean hasAnyTag(List<Tag> tags){
        return tags.stream().anyMatch(tag -> this.tags.contains(tag));
    }

    public boolean hasAnyKeyWord(List<String> keywords) {
        return keywords.stream().anyMatch(
            keyword -> {
                if(title != null && title.contains(keyword)) return true;
                if(super.body != null && super.body.contains(keyword)) return true;
                return false;
            }
        );
    }

    @Override
    public EventType getEventType(VoteType voteType) {
        if(VoteType.UPVOTE.equals(voteType)) return EventType.UPVOTE_QUESTION;
        else return EventType.DOWNVOTE_QUESTION;
    }

}
