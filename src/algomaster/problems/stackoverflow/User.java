package algomaster.problems.stackoverflow;

public class User {
    private final int id;
    private final String name;
    private int reputation;
    
    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object object){
        if(object instanceof User user && user.id == this.id){
            return true;
        }else return false;
    }

    public void addQuestion(Space space, Question question){
        space.addQuestion(question);
    }

    public void addAnswer(Question question, Answer answer){
        question.addAnswer(answer);
    }

    public void addComment(InteractiveContent interactiveContent, Comment comment){
        interactiveContent.addComment(comment);
    }

    public void upVote(InteractiveContent interactiveContent){
        interactiveContent.upVote(this);
    }

    public void downVote(InteractiveContent interactiveContent){
        interactiveContent.downVote(this);
    }

    public void setSolution(Question question, Answer answer){
        question.setSolution(answer, this);
    }

    public void increaseReputation(){
        reputation++;
    }

    public void decreaseReputation(){
        reputation--;
    }

}
