package algomaster.problems.stackoverflow;

import java.util.ArrayList;
import java.util.List;

public class Question extends InteractiveContent{
    private Answer solution;
    private List<Answer> answers = new ArrayList<>();
    private List<Tag> tags = new ArrayList<>();

    public Question(int id, User author, String title, String body) {
        super(id, author, title, body);
    }

    public void addAnswer(Answer answer){
        answers.add(answer);
    }

    public void addTag(Tag tag){
        tags.add(tag);
    }

    public void setSolution(Answer answer, User user){
        if(!super.author.equals(user)){
            throw new IllegalArgumentException("Owners can only decide solution for a question.");
        }
        this.solution = answer;
        answer.author.increaseReputation();
    }

}
