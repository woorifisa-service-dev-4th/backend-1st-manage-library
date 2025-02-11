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

    public void borrow(String userId) {
        if(this.isBorrow) {
            System.out.println("This book is already borrowed.");
            return;
        }
        this.userId = userId;
        this.isBorrow = true;
    }

    public void returnBook() {
        this.userId = null;
        this.isBorrow = false;
    }

}