
import book_system.service.book.BookService;
import book_system.service.user.UserService;
import java.util.Scanner;

public class App {
    private final static UserService userService = new UserService();
    private final static BookService bookService = new BookService();
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        String userId = null;
        String password = null;
        while(true) {
            System.out.println("사용자 ID를 입력하세요: ");
            userId = scanner.nextLine();
            System.out.println("비밀번호를 입력하세요:");
            password = scanner.nextLine();
            boolean loginStatus = userService.login(userId, password);

            if(loginStatus) {
                System.out.println("로그인 성공");
                break;
            } else {
                System.out.println("로그인 실패");
            }
        }

        boolean systemStatus = true;

        while (systemStatus) {
            System.out.println("도서 목록 조회-----(1)");
            System.out.println("대출-------------(2)");
            System.out.println("반납-------------(3)");
            System.out.println("종료-------------(4)");
            int menu = scanner.nextInt();

            switch (menu) {
                case 1: {
                    bookService.showBooks();
                    break;
                }
                case 2: {
                    System.out.println("대출할 도서 ID를 입력하세요: ");
                    int bookId = scanner.nextInt();

                    bookService.borrowBook(bookId, userId);
                    break;
                }
                case 3: {
                    System.out.println("반납할 도서 ID를 입력하세요: ");
                    int bookId = scanner.nextInt();

                    bookService.returnBook(bookId, userId);
                    break;
                }
                case 4: {
                    systemStatus = false;
                    break;
                }
                default: {
                    System.out.println("메뉴를 잘못 입력했습니다. 다시 선택해주세요.");
                    break;
                }
            }
        }

        scanner.close();


    }
}
