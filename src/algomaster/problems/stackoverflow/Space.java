package algomaster.problems.stackoverflow;

import java.util.ArrayList;
import java.util.List;

public class Space {
    private List<Question> questions = new ArrayList<>();

    public void addQuestion(Question question){
        questions.add(question);
    }

    private boolean containAny(String content, List<Tag> tags){
        if(content == null) return false;
        for (Tag tag : tags) {
            if(content.contains(tag.getContent())) return true;
        }
        return false;
    }

    public List<Question> searchQuestions(List<Tag> tags){
        List<Question> filteredQuestions = new ArrayList<>();
        for (Question question : questions) {
            if (containAny(question.getTitle(), tags) || containAny(question.getBody(), tags)) filteredQuestions.add(question);
        }
        return filteredQuestions;
    }

}
