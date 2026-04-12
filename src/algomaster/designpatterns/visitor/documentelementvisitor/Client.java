package algomaster.designpatterns.visitor.documentelementvisitor;

import java.util.List;

public class Client {
    public static void main(String[] args) {
        List<DocumentElement> doc = List.of(
            new Heading("My Document", "1"),
            new Paragraph("This is the first paragraph with some text."),
            new Image("photo.jpg", "A photo"),
            new Paragraph("Another paragraph here.")
        );

        WordCountVisitor counter = new WordCountVisitor();
        for (DocumentElement el : doc) el.accept(counter);
        
        System.out.println("Word count: " + counter.getWordCount());

        HtmlExportVisitor exporter = new HtmlExportVisitor();
        for (DocumentElement el : doc) el.accept(exporter);
    }
}
