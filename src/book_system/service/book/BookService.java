package book_system.service.book;

import java.util.List;

import book_system.resource.Data;

public class BookService {
    
    private final static List<Book> books = new Data().parseBooks();

    public void showBooks() {
        System.out.println("도서 목록");
        books.forEach(book -> System.out.println(book.getTitle()));
    }

    public void borrowBook(int bookId, String userId) {
        Book book = books.stream()
            .filter(b -> b.getId() == bookId)
            .findFirst()
            .orElse(null);
        
        if(book == null) {
            System.out.println("Book not found");
            return;
        }
        book.borrow(userId);
        System.out.println("Book borrowed");
    }

    public void returnBook(int bookId) {
        Book book = books.stream()
            .filter(b -> b.getId() == bookId)
            .findFirst()
            .orElse(null);
        
        if(book == null) {
            System.out.println("Book not found");
            return;
        }
        book.returnBook();
        System.out.println("Book returned");
    }

}
