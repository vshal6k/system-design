package algomaster.designpatterns.visitor.documentelementvisitor;

public interface DocumentElement {
    public void accept(Visitor visitor);
}
