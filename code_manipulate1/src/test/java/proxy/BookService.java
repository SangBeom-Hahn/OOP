package proxy;

import org.example.Book;

public class BookService {
    public void rent(Book book) {
        System.out.println(book.title);
    }

    public void returnBook(Book book) {
        System.out.println("return : " + book.title);
    }
}
