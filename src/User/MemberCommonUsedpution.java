package user;

import java.util.HashSet;
import java.util.*;

public class MemberCommonUsedpution {
    public static Set<Member> set = new HashSet<Member>();

    /**
     * 회원가입을 진행하는 메서드,
     * @param scanner 불러온 클래스 내에서 입력 객체를 받아와 사용한다
     * @return 계정이 저장됬다면  return 1, 아니라면  return 0
     */
    public static boolean setMember(Scanner scanner){

        System.out.println("회원가입");
        System.out.println();
        System.out.println("LOGIN");
        System.out.print("ID : ");
        String id = scanner.nextLine();
        System.out.print("PASSWORD : ");
        String pw = scanner.nextLine();

        Member member = new Member(id,pw);

        member.setMemberMoney('+',3000,"신규회원 가입 보상");
        return set.add(member);
    }

    /**
     * 로그인 시 사용자의 id와 pw를 입력받아 저장되어 있는 정보에서 비교하여 출력한다
     *
     * @return   //맴버 주소값을 반환하여 main에서 로그인 정보로 사용한다
     */
    public static Member FindAccount(Scanner scanner) {
        System.out.println("로그인");
        System.out.println();
        System.out.println("LOGIN");
        System.out.print("ID : ");
        String id = scanner.nextLine();
        System.out.print("PASSWORD : ");
        String pw = scanner.nextLine();

        //set 컬렉션에 저장된 값을 불러오며 member주소를 가리키게 한다
        for (Member member : MemberCommonUsedpution.set) { //컬렉션에 저장된 정보가 존재할때까지 확인한다
            if (member.id.equals(id)) { //불러온 값을 매개 id 값으로 받은 값을 비교하여
                if (member.pw.equals(pw)) { // 비밀번호도 일치한다면?
                    System.out.println("로그인성공!" + member.id + "님 환영합니다!");
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
