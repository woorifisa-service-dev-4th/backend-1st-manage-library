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
            System.out.println("존재하지 않는 책입니다.");
            return;
        }
        boolean result = book.borrow(userId);

        if (!result) return;

        System.out.println("도서 '"+book.getTitle()+"' 대출이 완료되었습니다.");
    }

    public void returnBook(int bookId, String userId) {
        Book book = books.stream()
            .filter(b -> b.getId() == bookId)
            .findFirst()
            .orElse(null);
        
        if(book == null) {
            System.out.println("존재하지 않는 책입니다.");
            return;
        }
        boolean result = book.returnBook(userId);

        if (!result) return;

        System.out.println("'"+book.getTitle()+"' 반납이 완료되었습니다.");
    }

}
