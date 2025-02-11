
import book_system.service.book.BookService;
import book_system.service.user.UserService;
import java.util.Scanner;

public class App {
    private final static UserService userService = new UserService();
    private final static BookService bookService = new BookService();
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        System.out.println("사용자 ID를 입력하세요: ");
        String userId = scanner.nextLine();
        System.out.println("비밀번호를 입력하세요:");
        String password = scanner.nextLine();

        userService.login(userId, password);

        System.out.println("도서 ID를 입력하세요: ");
        int bookId = scanner.nextInt();

        bookService.borrowBook(bookId, userId);

    }
}
