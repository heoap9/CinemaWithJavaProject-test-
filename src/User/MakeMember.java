package User;

import java.util.HashSet;
import java.util.*;

public class MakeMember {
    public static Set<Member> set = new HashSet<Member>();


    /**
     * @param member 컬렉션 구조를 사용하여
     *               id값이 같다면 저장되지 않게 구현한 계정 생성 메서드 이다
     * @return 계정이 저장됬다면  return 1, 아니라면  return 0
     */
    public static boolean setMember(Member member){
        member.money += 3000;
        if(set.add (member)){
            return true;
        }else{
            return false;
        }
    }



}
