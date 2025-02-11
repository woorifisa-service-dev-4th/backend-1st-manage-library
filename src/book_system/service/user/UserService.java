package book_system.service.user;

import java.util.List;

import book_system.resource.Data;

public class UserService {
    private final static List<User> users = new Data().parseUsers();
    
    public boolean login(String userId, String password) {

        User user = users.stream()
        .filter(u -> u.getId().equals(userId))
        .findFirst()
        .orElse(null);
    
        if(user == null) {
            System.out.println("User not found");
            return false;
        }
        if(!user.checkPassword(password)) {
            System.out.println("Password is incorrect");
            return false;
        }
        System.out.println(user.getName() + "님 환영합니다!!");
        return true;
    }
}
