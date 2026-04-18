package algomaster.problems.stackoverflow;

public abstract class Content {
    private final int id;
    protected final User author;
    private final String title;
    private final String body;

    public Content(int id, User author, String title, String body) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
    
}
