package algomaster.problems.stackoverflow;

import java.util.ArrayList;
import java.util.List;

import algomaster.problems.stackoverflow.dataclasses.Tag;

public class TagSearchStrategy implements SeachStrategy {
    private List<Tag> tags;

    public TagSearchStrategy(List<Tag> tags) {
        this.tags = tags;
    }

    @Override
    public List<Question> filter(List<Question> questions) {
        List<Question> filteredQuestions = new ArrayList<>();
        for (Question question : questions) {
            if (question.hasAnyTag(tags))
                filteredQuestions.add(question);
        }
        return filteredQuestions;
    }

}
