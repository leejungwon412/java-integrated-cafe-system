import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MemberService memberService = new MemberService();
        boolean login = false;
        String menu;

        while (true) {
            if (login) {
                System.out.println("1. 로그아웃 | 2. 회원 탈퇴 | 3. 종료");
                System.out.print("원하시는 메뉴의 번호를 입력하시오 : ");
                menu = scanner.nextLine();

                if (menu.equals("1")) {
                    System.out.println("로그아웃 합니다.");
                    memberService.logOut();
                    login = false;
                } else if (menu.equals("2")) {
                    System.out.println("회원 탈퇴를 시작합니다.");
                    System.out.print("현재 로그인 된 계정의 비밀번호를 입력하시오 : ");
                    String pw = scanner.nextLine();
                    if (memberService.cancel(pw)) {
                        System.out.println("회원 탈퇴를 완료하였습니다.");
                        login = false;
                    } else {
                        System.out.println("비밀번호가 틀렸습니다. 다시 한번 확인해주세요.");
                    }
                } else if (menu.equals("3")) {
                    System.out.println("종료합니다.");
                    break;
                } else {
                    System.out.println("잘못된 입력입니다.");
                }
            } else {
                System.out.println("1. 회원 가입 | 2. 로그인 | 3. 종료");
                System.out.print("원하시는 메뉴의 번호를 입력하시오 : ");
                menu = scanner.nextLine();

                if (menu.equals("1")) {
                    System.out.println("회원 가입을 시작합니다.");
                    System.out.print("이름을 입력하시오 : ");
                    String name = scanner.nextLine();
                    System.out.print("아이디를 입력하시오 : ");
                    String id = scanner.nextLine();
                    System.out.print("비밀번호를 입력하시오 : ");
                    String pw = scanner.nextLine();
                    Member member = new Member(name, id, pw);
                    if (memberService.signUp(member)) {
                        System.out.println("회원가입에 성공했습니다! 로그인 해주세요!");
                    } else {
                        System.out.println("이미 존재하는 아이디입니다.");
                    }
                } else if (menu.equals("2")) {
                    System.out.println("로그인을 시작합니다.");
                    System.out.print("아이디를 입력하시오 : ");
                    String id = scanner.nextLine();
                    System.out.print("비밀번호를 입력하시오 : ");
                    String pw = scanner.nextLine();
                    if (memberService.signIn(id, pw)) {
                        login = true;
                        System.out.println("로그인에 성공했습니다! ");
                    } else {
                        System.out.println("아이디 또는 비밀번호가 틀렸습니다. 다시 한번 확인해주세요.");
                    }
                } else if (menu.equals("3")) {
                    System.out.println("종료합니다.");
                    break;
                } else {
                    System.out.println("잘못된 입력입니다.");
                }
            }
        }
    }
}
