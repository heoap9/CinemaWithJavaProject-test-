package User;

import java.util.Iterator;

public class FindGuest {
    /**
     * @param id //main에서 입력받은 계정의 id값을 사용하며
     *           //set 컬렉션에 저장된 ㄱ
     * @param pw
     * @return
     */
    public static Member FindAccount(String id, String pw) {
        Iterator<Member> iterator = MakeGuest.set.iterator(); // 리터레이터 초기화

        while (iterator.hasNext()) {
            Member member = iterator.next();

            if (member.id.equals(id)) {
                if (member.pw.equals(pw)) {
                    System.out.println("로그인성공!"+member.id+"님 환영합니다!");
                    return member;
                } else {
                    System.out.println("비밀번호를 틀리셨습니다");
                    return null; // 비밀번호가 틀렸을 경우 반환값 처리
                }
            }
        }

        System.out.println("찾는 회원 정보가 없어요");
        return null; // 회원을 찾지 못한 경우 반환값 처리
    }
}
