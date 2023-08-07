package User;

import java.util.HashSet;
import java.util.*;

public class MakeGuest {
    public static Set<Member> set = new HashSet<Member>();
    public static int setMember(Member member){
        if(set.add (member)){
            return 1;
        }else{
            return 0;
        }
    }



}
