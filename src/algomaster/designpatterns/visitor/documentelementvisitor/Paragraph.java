package algomaster.designpatterns.visitor.documentelementvisitor;

public class Paragraph implements DocumentElement{
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Paragraph(String text) {
        this.text = text;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitParagraph(this);
    }
    
}
