import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MemberService memberService = new MemberService();
        MenuService menuService = new MenuService();
        boolean adminLogin = false;
        boolean userLogin = false;
        String p1;

        while (true) {
            if (userLogin) {
                System.out.println("1. 메뉴판 조회 | 2. 장바구니 담기 | 3. 주문/결제 | 4. 주문 내역 확인 | 5. 회원 탈퇴 | 6. 로그아웃");
                System.out.print("원하시는 메뉴의 번호를 입력하시오 : ");
                p1 = scanner.nextLine();

                if (p1.equals("1")) {
                    System.out.println("메뉴판을 조회합니다.");
                    menuService.getMenu();
                } else if (p1.equals("2")) {
                    System.out.println("준비 중입니다.");
                } else if (p1.equals("3")) {
                    System.out.println("준비 중입니다.");
                } else if (p1.equals("4")) {
                    System.out.println("준비 중입니다.");
                } else if (p1.equals("5")) {
                    System.out.println("회원 탈퇴를 시작합니다.");
                    System.out.print("현재 로그인 된 계정의 비밀번호를 입력하시오 : ");
                    String pw = scanner.nextLine();
                    if (memberService.cancel(pw)) {
                        System.out.println("회원 탈퇴를 완료하였습니다.");
                        userLogin = false;
                    } else {
                        System.out.println("비밀번호가 틀렸습니다. 다시 한번 확인해주세요.");
                    }
                } else if (p1.equals("6")) {
                    System.out.println("로그아웃 합니다.");
                    memberService.logOut();
                    userLogin = false;
                } else {
                    System.out.println("잘못된 입력입니다.");
                }
            } else if (adminLogin) {
                System.out.println("1. 메뉴 등록 | 2. 메뉴 수정 | 3. 메뉴 삭제 | 4. 전체 매출 조회 | 5. 로그아웃");
                System.out.print("원하시는 메뉴의 번호를 입력하시오 : ");
                p1 = scanner.nextLine();

                if (p1.equals("1")) {
                    System.out.println("메뉴를 등록합니다.");
                    System.out.print("메뉴의 이름을 입력하시오 : ");
                    String name = scanner.nextLine();
                    System.out.print("메뉴의 가격을 입력하시오 : ");
                    int price = scanner.nextInt();
                    scanner.nextLine();
                    Menu menu = new Menu(name, price);
                    menuService.addMenu(menu);
                    System.out.println("메뉴 등록을 완료했습니다!");
                } else if (p1.equals("2")) {
                    System.out.println("메뉴를 수정합니다.");
                    menuService.getMenu();
                    System.out.print("수정하시려는 메뉴의 이름을 입력하시오 : ");
                    String name = scanner.nextLine();
                    if (menuService.findName(name)) {
                        System.out.println("1. 상품명 | 2. 가격 | 3. 상품명과 가격");
                        System.out.print("수정하려는 부분을 선택하시오 : ");
                        String p2 = scanner.nextLine();

                        if (p2.equals("1")) {
                            System.out.print("변경된 상품명을 입력하시오 : ");
                            menuService.modifyMenu(name, scanner.nextLine());
                            System.out.println("수정 완료했습니다!");
                        } else if (p2.equals("2")) {
                            System.out.print("변경된 가격을 입력하시오 : ");
                            menuService.modifyMenu(name, scanner.nextInt());
                            scanner.nextLine();
                            System.out.println("수정 완료했습니다!");
                        } else if (p2.equals("3")) {
                            System.out.print("변경된 상품명을 입력하시오 : ");
                            String newName = scanner.nextLine();
                            menuService.modifyMenu(name, newName);
                            System.out.print("변경된 가격을 입력하시오 : ");
                            menuService.modifyMenu(newName, scanner.nextInt());
                            scanner.nextLine();
                            System.out.println("수정 완료했습니다!");
                        }
                    } else {
                        System.out.println("잘못된 입력입니다.");
                    }
                } else if (p1.equals("3")) {
                    System.out.println("메뉴를 삭제합니다.");
                    menuService.getMenu();
                    System.out.print("삭제하려는 메뉴의 이름을 입력하시오 : ");
                    String name = scanner.nextLine();
                    if (menuService.findName(name)) {
                        System.out.print("정말 삭제하시겠습니까? (1. Y / 2. N) : ");
                        String c = scanner.nextLine();
                        if (c.equals("1")) {
                            menuService.deleteMenu(name);
                            System.out.println("삭제를 완료했습니다!");
                        } else if (c.equals("2")) {
                            System.out.println("삭제를 취소합니다.");
                        } else {
                            System.out.println("잘못된 입력입니다.");
                        }
                    } else {
                        System.out.println("잘못된 입력입니다.");
                    }
                } else if (p1.equals("4")) {
                    System.out.println("준비 중입니다.");
                } else if (p1.equals("5")) {
                    System.out.println("로그아웃 합니다.");
                    memberService.logOut();
                    adminLogin = false;
                } else {
                    System.out.println("잘못된 입력입니다.");
                }
            } else {
                System.out.println("1. 회원 가입 | 2. 로그인 | 3. 종료");
                System.out.print("원하시는 메뉴의 번호를 입력하시오 : ");
                p1 = scanner.nextLine();

                if (p1.equals("1")) {
                    System.out.println("회원 가입을 시작합니다.");
                    System.out.print("이름을 입력하시오 : ");
                    String name = scanner.nextLine();
                    System.out.print("아이디를 입력하시오 : ");
                    String id = scanner.nextLine();
                    System.out.print("비밀번호를 입력하시오 : ");
                    String pw = scanner.nextLine();
                    User user = new User(name, id, pw);
                    if (memberService.signUp(user)) {
                        System.out.println("회원가입에 성공했습니다! 로그인 해주세요!");
                    } else {
                        System.out.println("이미 존재하는 아이디입니다.");
                    }
                } else if (p1.equals("2")) {
                    System.out.println("로그인을 시작합니다.");
                    System.out.print("아이디를 입력하시오 : ");
                    String id = scanner.nextLine();
                    System.out.print("비밀번호를 입력하시오 : ");
                    String pw = scanner.nextLine();
                    if (memberService.signIn(id, pw)) {
                        System.out.println("로그인에 성공했습니다!");
                        if (memberService.getCurrentMember() instanceof Admin) {
                            adminLogin = true;
                        } else {
                            userLogin = true;
                        }
                    } else {
                        System.out.println("아이디 또는 비밀번호가 틀렸습니다. 다시 한번 확인해주세요.");
                    }
                } else if (p1.equals("3")) {
                    System.out.println("종료합니다.");
                    break;
                } else {
                    System.out.println("잘못된 입력입니다.");
                }
            }
        }
    }
}
