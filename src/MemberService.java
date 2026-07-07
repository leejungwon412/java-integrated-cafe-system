import java.util.ArrayList;

public class MemberService {
    ArrayList<Member> members = new ArrayList<>();
    Member currentMember = new Member();

    public boolean signUp(Member member) {
        for (int i = 0; i < members.size(); i++) {
            if (member.getId().equals(members.get(i).getId())) {
                return false;
            }
        }
        members.add(member);
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
}
