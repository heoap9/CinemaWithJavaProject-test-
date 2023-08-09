package user;

import java.util.Iterator;

public class FindGuest {
    /**
     * @param id //main에서 입력받은 계정의 id값을 사용하며
     *           //set 컬렉션에 저장된 member 객체를 비교하며 계정이 있는지를 검사한다
     * @param pw //set컬렉션에 저장된 member 객체가 저장되어 있다면 비밀번호도 검사하여
     *           //컬렉션에 저장된 정보를
     * @return   //맴버 주소값을 반환하여 main에서 로그인 정보로 사용한다
     */
    public static Member FindAccount(String id, String pw) {
        Iterator<Member> iterator = MakeMember.set.iterator(); // 리터레이터 초기화
        //set 컬렉션 사용을 간단하게 사용하기 위해 사용한 리터레이터

        while (iterator.hasNext()) { //컬렉션에 저장된 정보가 존재할때까지 확인한다
            Member member = iterator.next(); //set 컬렉션에 저장된 값을 불러오며 member주소를 가리키게 한다

            if (member.id.equals(id)) { //불러온 값을 매개 id 값으로 받은 값을 비교하여
                if (member.pw.equals(pw)) { // 비밀번호도 일치한다면?
                    System.out.println("로그인성공!"+member.id+"님 환영합니다!");
                    return member; //불러온 계정 정보를 리턴한다
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
