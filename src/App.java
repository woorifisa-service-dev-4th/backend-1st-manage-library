
import book_system.service.book.BookService;
import book_system.service.user.UserService;
import java.util.Scanner;

public class App {
    private final static UserService userService = new UserService();
    private final static BookService bookService = new BookService();
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your user id:");
        String userId = scanner.nextLine();
        System.out.println("Enter your password:");
        String password = scanner.nextLine();

        userService.login(userId, password);

        System.out.println("Enter the number of the book you want to borrow:");
        int bookId = scanner.nextInt();

        bookService.borrowBook(bookId, userId);

    }
}
