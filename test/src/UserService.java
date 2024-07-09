public class UserService {

    UserDAO userDAO = new UserDAO();

    public void join(User user){
        userDAO.addUser(user);
    }

    public void login(User user){
        String pw = userDAO.getUser(user.getId());
        if (pw==null)
            System.out.println("해당 id가 없습니다.");
        else if (pw.equals(user.getPw())) {
            System.out.println("환영합니다~ 로그인 성공!");
            Main.isLogin = 1;
        }
        else
            System.out.println("잘못된 패스워드입니다.");
    }

    public void changePassword(User user){
        userDAO.updateUser(user);
        System.out.println("패스워드가 변경됐습니다.");
    }

    public void delete(User user){
        userDAO.removeUser(user);
        System.out.println("회원 삭제 되었습니다.");
    }
}
