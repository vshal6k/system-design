package algomaster.designpatterns.visitor.documentelementvisitor;

public class Heading implements DocumentElement{
    private String text;
    private String level;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLevel() {
        return level;
    }
    
    public void setLevel(String level) {
        this.level = level;
    }

    public Heading(String text, String level) {
        this.text = text;
        this.level = level;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitHeading(this);
    }

}
