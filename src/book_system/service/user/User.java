package book_system.service.user;

public class User {
    private final String id;
    private final String password;
    private final String name;

    public User(String id, String password, String name) {
        this.id = id;
        this.password = password;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    public String getId() {
        return this.id;
    }

}
