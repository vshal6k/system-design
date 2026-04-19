package algomaster.problems.stackoverflow.service;

import java.util.List;

import algomaster.problems.stackoverflow.domainmodel.Question;

public interface SeachStrategy {
    List<Question> filter(List<Question> questions);
}
