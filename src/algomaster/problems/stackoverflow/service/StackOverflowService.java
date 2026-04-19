package algomaster.problems.stackoverflow.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import algomaster.problems.stackoverflow.domainmodel.Answer;
import algomaster.problems.stackoverflow.domainmodel.Comment;
import algomaster.problems.stackoverflow.domainmodel.Post;
import algomaster.problems.stackoverflow.domainmodel.Question;
import algomaster.problems.stackoverflow.domainmodel.Tag;
import algomaster.problems.stackoverflow.domainmodel.User;
import algomaster.problems.stackoverflow.enums.VoteType;
import algomaster.problems.stackoverflow.event.PostObserver;
import algomaster.problems.stackoverflow.event.ReputationManager;

public class StackOverflowService {
    private final ConcurrentHashMap<String, User> users = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Question> questions = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Answer> answers = new ConcurrentHashMap<>();
    private final PostObserver reputationManager = new ReputationManager();

    private User getUser(String userId) {
        if (userId == null)
            throw new IllegalArgumentException("User Id cannot be null");

        User user = users.get(userId);

        if (user == null)
            throw new NoSuchElementException("User not found");

        return user;
    }

    private Question getQuestion(String questionId) {
        if (questionId == null)
            throw new IllegalArgumentException("Question Id cannot be null");

        Question question = questions.get(questionId);

        if (question == null)
            throw new NoSuchElementException("Question not found");

        return questions.get(questionId);
    }

    private Answer getAnswer(String answerId) {
        if (answerId == null)
            throw new IllegalArgumentException("Answer Id cannot be null");

        Answer answer = answers.get(answerId);

        if (answer == null)
            throw new NoSuchElementException("Answer not found");

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

        throw new NoSuchElementException("Post not found");
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
        Answer answer = getAnswer(answerId);

        question.acceptAnswer(user, answer);
        
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

    public List<Question> searchQuestions(List<SearchStrategy> searchStrategies){
        List<Question> questions = this.questions.entrySet().stream().map(entry -> entry.getValue()).toList();
        for (SearchStrategy seachStrategy : searchStrategies) {
            questions = seachStrategy.filter(questions);
        }
        return questions;
    }

}
