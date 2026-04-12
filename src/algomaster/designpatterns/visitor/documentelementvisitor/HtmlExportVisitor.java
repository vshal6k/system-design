package algomaster.designpatterns.visitor.documentelementvisitor;

public class HtmlExportVisitor implements Visitor{

    @Override
    public void visitParagraph(Paragraph paragraph) {
        System.out.println("<p>" + paragraph.getText() + "</p>");
    }

    @Override
    public void visitHeading(Heading heading) {
        System.out.println("<h" 
                            + heading.getLevel() 
                            + ">" 
                            +  heading.getText() +  "</h" 
                            + heading.getLevel() + ">");
    }

    @Override
    public void visitImage(Image image) {
        System.out.println("<img src=\"" + image.getUrl() + "\" alt=\"" + image.getAltText() + "\" />");
    }
    
}
