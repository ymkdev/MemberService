import java.util.Scanner;

public class Main {
    public static int isLogin = 0;
    public static void main(String[] args) {


        UserService userService = new UserService();

        User user = new User();
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("1: 회원가입 / 2: 로그인 / 3 회원정보 수정 / 4: 탈퇴 / 0: 종료");
            System.out.print("입력: ");
            String num = scanner.nextLine();
            if (num.equals("0")){
                isLogin = 0;
                System.out.println("종료되었습니다.");
                break;
            }
            else if (num.equals("1")){
                if (isLogin==0){
                    System.out.println("가입하실 아이디와 비밀번호를 (띄어쓰기로 구분하여) 입력하세요.");
                    String joinIdPw = scanner.nextLine();
                    String[] parts = joinIdPw.split(" ");
                    String id = parts[0];
                    String pw = parts[1];
                    user.setId(id);
                    user.setPw(pw);
                    userService.join(user);
                }
                else
                    System.out.println("먼저 로그아웃부터 하세요.");
            }
            else if (num.equals("2")){
                if (isLogin==0){
                    System.out.println("로그인하실 아이디와 비밀번호를 (띄어쓰기로 구분하여) 입력하세요.");
                    String joinIdPw = scanner.nextLine();
                    String[] parts = joinIdPw.split(" ");
                    String id = parts[0];
                    String pw = parts[1];
                    user.setId(id);
                    user.setPw(pw);
                    userService.login(user);
                }
                else
                    System.out.println("이미 로그인 중입니다.");
            }
            else if (num.equals("3")){
                if (isLogin==1){
                    System.out.println("수정하실 비밀번호를 입력하세요.");
                    String newPw = scanner.nextLine();
                    user.setPw(newPw);
                    userService.changePassword(user);
                }
                else
                    System.out.println("로그인 상태가 아닙니다.");

            }
            else if (num.equals("4")){
                if (isLogin==1){
                    isLogin = 0;
                    userService.delete(user);
                }
                else
                    System.out.println("로그인 상태가 아닙니다.");
            }
            else{
                System.out.println("1, 2, 3, 4, 0만 입력 가능합니다");
            }


        }



    }
}
