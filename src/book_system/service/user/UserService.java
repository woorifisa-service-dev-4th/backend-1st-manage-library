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
            System.out.println("존재하지 않는 유저입니다");
            return false;
        }
        if(!user.checkPassword(password)) {
            System.out.println("비밀번호가 일치하지 않습니다. 다시 확인해주세요");
            return false;
        }
        System.out.println(user.getName() + "님, 환영합니다!");
        return true;
    }
}
