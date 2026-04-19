package algomaster.problems.stackoverflow;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import algomaster.problems.stackoverflow.dataclasses.Tag;
import algomaster.problems.stackoverflow.enums.VoteType;

public class StackOverFlowDemo {

    public static void main(String[] args) {
        StackOverflowService stackOverflowService = new StackOverflowService();
        User vishal = stackOverflowService.createUser("Vishal");
        User kanan = stackOverflowService.createUser("Kanan");
        User het = stackOverflowService.createUser("Het");
        
        Tag tag1 = new Tag("Gym");
        Tag tag2 = new Tag("Exercise");
        Set<Tag> gymTags = new HashSet<>();
        gymTags.add(tag1);
        gymTags.add(new Tag("Exercise"));

        Question question1 = stackOverflowService.postQuestion(vishal.getId(), "Gym Question", "Is Gym Healthy?", gymTags);

        
        stackOverflowService.addCommentOnPost(kanan.getId(), question1.getId(), "Why always gym?");

        question1.displayComments();

        Answer question1Answer1 = stackOverflowService.postAnswer(kanan.getId(), question1.getId(), "No!");

        stackOverflowService.addCommentOnPost(vishal.getId(), question1Answer1.getId(), "Fat girl!!");

        question1Answer1.displayComments();

        Answer question1Answer2 = stackOverflowService.postAnswer(vishal.getId(), question1.getId(), "Yes!");
        Answer question1Answer3 = stackOverflowService.postAnswer(het.getId(), question1.getId(), "Drink Beer!");

        stackOverflowService.voteOnPost(vishal.getId(), question1.getId(), VoteType.UPVOTE);

        System.out.println(vishal);
        System.out.println(kanan);

        List<SeachStrategy> strategies = new ArrayList<>();
        List<Tag> tagList = new ArrayList<>(gymTags);

        strategies.add(new TagSearchStrategy(tagList));

        stackOverflowService.searchQuestions(strategies).stream().forEach(question -> System.out.println(question.getBody()));
        

        // Question question2 = stackOverflowService.postQuestion(het.getId(), "Programming Question", "Is software development dead?", gymTags);

        // System.out.println(question2);

        // Answer question2Answer1 = stackOverflowService.postAnswer(kanan.getId(), question2.getId(), "No!");
        // Answer question2Answer2 = stackOverflowService.postAnswer(vishal.getId(), question2.getId(), "Prepare for UPSC Bro!!");
        // Answer question2Answer3 = stackOverflowService.postAnswer(het.getId(), question2.getId(), "Do CFA!!");
        
    }
}
