package member;

public class Member {
    private String name;
    private String id;
    private String pw;
    private int balance;

    public Member() {

    }

    public Member(String name, String id, String pw, int balance) {
        this.name = name;
        this.id = id;
        this.pw = pw;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getPw() {
        return pw;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int totalPrice) {
        this.balance -= totalPrice;
    }
}
