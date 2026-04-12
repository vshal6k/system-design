package algomaster.designpatterns.visitor.documentelementvisitor;

public interface Visitor {
    public void visitParagraph(Paragraph paragraph);
    public void visitHeading(Heading heading);
    public void visitImage(Image image);
}
