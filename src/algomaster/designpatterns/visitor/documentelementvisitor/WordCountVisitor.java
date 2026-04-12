package algomaster.designpatterns.visitor.documentelementvisitor;

public class WordCountVisitor implements Visitor{
    private int wordCount = 0;

    public int getWordCount(){
        return wordCount;
    }

    @Override
    public void visitParagraph(Paragraph paragraph) {
        wordCount += paragraph.getText().length();
        System.out.println(paragraph.getText().length());
    }

    @Override
    public void visitHeading(Heading heading) {
        wordCount += heading.getText().length();
        System.out.println(heading.getText().length());
    }

    @Override
    public void visitImage(Image image) {
        System.out.println(0);
    }
    
}
