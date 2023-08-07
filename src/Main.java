// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

import  Movie.DefaultMovie;
import  User.Member;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        System.out.println("췌아!");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();


        switch (input.charAt(0)){
            case'1':  /*회원메뉴 구축*/ //가입,로그인
                       /*예매*/ //회원 로그인이 완료 된 상태에서 가능

                break;
            case'2': /*영화 메뉴*/ //영화 조회 상영편,영화제목 남은 좌석수
                break;

            case'4': /*종료*/
                System.out.println("종료합니다");
                break;
            default:
                System.out.println("잘못입력하셨습니다");



        }



    }
}