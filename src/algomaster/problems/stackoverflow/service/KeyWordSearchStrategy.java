package algomaster.problems.stackoverflow.service;

import java.util.ArrayList;
import java.util.List;

import algomaster.problems.stackoverflow.domainmodel.Question;

public class KeyWordSearchStrategy implements SeachStrategy{
    private final List<String> keywords; 

    public KeyWordSearchStrategy(List<String> keywords) {
        this.keywords = List.copyOf(keywords);
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
