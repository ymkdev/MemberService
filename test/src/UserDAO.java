import java.util.Map;
import java.util.HashMap;

public class UserDAO {
    private Map<String, String> db = new HashMap<>();

    //추가
    public void addUser(User user){
        db.put(user.getId(), user.getPw());
        System.out.println(user.getId()+"님 가입을 환영합니다.");
    }

    //조회
    public String getUser(String userId){
        return db.get(userId);
    }

    //수정
    public void updateUser(User user){
        db.put(user.getId(), user.getPw());
    }

    //삭제
    public void removeUser(User user){
        db.remove(user.getId());
    }
}
