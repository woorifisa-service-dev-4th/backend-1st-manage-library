package book_system.service.book;

public class Book {
    private final int id;
    private String userId;
    private final String title;
    private Boolean isBorrow;

    public Book(int id, String title) {
        this.id = id;
        this.title = title;
        this.isBorrow = false;
    }

    public int getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public boolean checkBorrow() {
        return this.isBorrow;
    }

    public boolean borrow(String userId) {
        if(this.isBorrow) {
            System.out.println("이미 대출된 책입니다.");
            return false;
        }
        this.userId = userId;
        this.isBorrow = true;
        return true;
    }

    public boolean returnBook(String userId) {
        if (this.userId != userId) {
            System.out.println("존재하지 않는 대출 정보입니다.");
            return false;
        }
        this.userId = null;
        this.isBorrow = false;
        return true;
    }

}