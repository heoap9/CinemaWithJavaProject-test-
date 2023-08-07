package User;

import java.util.HashSet;
import java.util.*;

public class MakeGuest {
    Set<Member> set = new HashSet<Member>();

    public void setMember (Member member){
        set.add (new Member(member.id, member.pw,member.money));
    }



}
