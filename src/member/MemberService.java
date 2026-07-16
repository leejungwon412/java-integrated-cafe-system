package member;

import java.io.*;
import java.util.ArrayList;

public class MemberService {
    ArrayList<Member> members = new ArrayList<>();
    Member currentMember = null;

    public boolean signUp(User user) {
        for (int i = 0; i < members.size(); i++) {
            if (user.getId().equals(members.get(i).getId())) {
                return false;
            }
        }
        members.add(user);
        return true;
    }

    public boolean signIn(String id, String pw) {
        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).getId().equals(id) && members.get(i).getPw().equals(pw)) {
                currentMember = members.get(i);
                return true;
            }
        }
        return false;
    }

    public void logOut() {
        currentMember = null;
    }

    public boolean cancel(String pw) {
        String memberPw = currentMember.getPw();
        if (memberPw.equals(pw)) {
            members.remove(currentMember);
            return true;
        }
        return false;
    }

    public Member getCurrentMember() {
        return currentMember;
    }

    public int getCurrentBalance() {
        return currentMember.getBalance();
    }

    public void saveMembers() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("members.txt"));
        for (int i = 0; i < members.size(); i++) {
            String type = (members.get(i) instanceof Admin) ? "ADMIN" : "USER";
            String line = members.get(i).getName() + "," + members.get(i).getId() + "," + members.get(i).getPw() + "," + members.get(i).getBalance() + "," + type;
            bw.write(line);
            bw.newLine();
        }
        bw.close();
    }

    public void loadMembers() throws IOException {
        File file = new File("members.txt");
        if (!file.exists()) {
            members.add(new Admin("관리자", "ad", "ad", 1000000000));
            return;
        }
        BufferedReader br = new BufferedReader(new FileReader("members.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            if (data[4].equals("ADMIN")) {
                Admin admin = new Admin(data[0], data[1], data[2], Integer.parseInt(data[3]));
                members.add(admin);
            } else {
                User user = new User(data[0], data[1], data[2], Integer.parseInt(data[3]));
                members.add(user);
            }
        }
        br.close();
    }
}
