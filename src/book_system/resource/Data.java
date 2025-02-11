package book_system.resource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import book_system.service.user.User;
import book_system.service.book.Book;

public class Data {
    private final String USER_FILE_PATH = "src/book_system/resource/user.csv";
    private final String BOOK_FILE_PATH = "src/book_system/resource/book.txt";

    public List<User> parseUsers() {
        List<User> users = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(USER_FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] userDetails = line.split(",");
                int id = Integer.parseInt(userDetails[0]);
                String password = userDetails[1];
                String name = userDetails[2];
                User user = new User(id, password, name);
                users.add(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }

    public List<Book> parseBooks() {
        List<Book> books = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(BOOK_FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] bookDetails = line.split(",");
                int id = Integer.parseInt(bookDetails[0]);
                String title = bookDetails[1];
                Book book = new Book(id, title);
                books.add(book);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return books;
    }
}