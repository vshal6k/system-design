package algomaster.problems.stackoverflow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import algomaster.problems.stackoverflow.dataclasses.Comment;
import algomaster.problems.stackoverflow.dataclasses.Tag;
import algomaster.problems.stackoverflow.enums.VoteType;

public class StackOverflowService {
    private Map<String, User> users = new HashMap<>();
    private Map<String, Question> questions = new HashMap<>();
    private Map<String, Answer> answers = new HashMap<>();
    private PostObserver reputationManager = new ReputationManager();

    private User getUser(String userId) {
        if (userId == null)
            throw new IllegalArgumentException("User Id cannot be null");

        User user = users.get(userId);

        if (user == null)
            throw new IllegalArgumentException("User not found");

        return user;
    }

    private Question getQuestion(String questionId) {
        if (questionId == null)
            throw new IllegalArgumentException("Question Id cannot be null");

        Question question = questions.get(questionId);

        if (question == null)
            throw new IllegalArgumentException("Question not found");

        return questions.get(questionId);
    }

    private Answer getAnswer(String answerId) {
        if (answerId == null)
            throw new IllegalArgumentException("Answer Id cannot be null");

        Answer answer = answers.get(answerId);

        if (answer == null)
            throw new IllegalArgumentException("Answer not found");

        return answers.get(answerId);
    }

    public Post findPostById(String id) {
        if (id == null)
            throw new IllegalArgumentException("Id cannot be null");

        Question question = questions.get(id);
        if (question != null)
            return question;

        Answer answer = answers.get(id);
        if (answer != null)
            return answer;

        throw new IllegalArgumentException("Post not found");
    }

    public User createUser(String name) {
        User user = new User(name);
        users.put(user.getId(), user);
        return user;
    }

    public Question postQuestion(String authorUserId, String title, String body, Set<Tag> tags) {
        User author = getUser(authorUserId);
        Question question = new Question(body, author, title, tags);
        question.addPostObserver(reputationManager);
        questions.put(question.getId(), question);
        return question;
    }

    public Answer postAnswer(String authorUserId, String questionId, String body) {
        User author = getUser(authorUserId);
        Question question = getQuestion(questionId);
        Answer answer = new Answer(body, author);
        question.addAnswer(answer);
        answer.addPostObserver(reputationManager);
        answers.put(answer.getId(), answer);
        return answer;
    }

    public void acceptAnswer(String userId, String questionId, String answerId) {
        User user = getUser(userId);
        Question question = getQuestion(questionId);
        Answer answer = answers.get(answerId);

        if(!question.hasAnswer(answer)) throw new IllegalArgumentException("Question and answer are not related");

        if(!user.equals(question.getAuthor())) throw new IllegalArgumentException("Answers can only be accepted by question authors");

        question.acceptAnswer(answer);
        
    }

    public void voteOnPost(String userId, String postId, VoteType voteType){
        User user = getUser(userId);
        Post post = findPostById(postId);
        post.vote(user, voteType);
    }

    public void addCommentOnPost(String userId, String postId, String comment){
        User author = getUser(userId);
        Post post = findPostById(postId);
        post.addComment(new Comment(comment, author));
    }

    public List<Question> searchQuestions(List<SeachStrategy> searchStrategies){
        List<Question> questions = this.questions.entrySet().stream().map(entry -> entry.getValue()).toList();
        List<Question> filteredQuestions = new ArrayList<>();
        for (SeachStrategy seachStrategy : searchStrategies) {
            filteredQuestions.addAll(seachStrategy.filter(questions));
        }
        return filteredQuestions;
    }

}
