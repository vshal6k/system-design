package algomaster;
import java.util.Arrays;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean isAvailable;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = true;
    }

    public boolean borrowBook(){
        if(isAvailable){
            isAvailable = false;
            return true;
        }else return false;
    }

    public void returnBook(){
        isAvailable = true;
    }

    public void displayInfo(){
        System.out.println("Book Information");
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("isbn: " + isbn);
        System.out.println("isAvailable: " + isAvailable);
    }

    public static void main(String[] args) {
        Book book = new Book("My Experiments With Truth", "Bapu", "na");

        book.displayInfo();
        book.borrowBook();
        System.out.println(book.isAvailable);
        book.returnBook();
        System.out.println(book.isAvailable);
        
    }
    
}
