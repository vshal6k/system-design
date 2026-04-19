package algomaster.problems.stackoverflow;

import java.util.ArrayList;
import java.util.List;

public class KeyWordSearchStrategy implements SeachStrategy{
    private List<String> keywords; 

    public KeyWordSearchStrategy(List<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public List<Question> filter(List<Question> questions) {
        List<Question> filteredQuestions = new ArrayList<>();
        for (Question question : questions) {
            if (question.hasAnyKeyWord(keywords)) filteredQuestions.add(question);
        }
        return filteredQuestions;
    }
    
}
