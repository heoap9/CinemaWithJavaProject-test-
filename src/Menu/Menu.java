package Menu;

import Movie.Movie;
import User.Member;
import User.*;

import java.util.Scanner;

public class Menu {
    public static void mainMenu(Member member){

        if(member == null){
            System.out.println("┌─────────── 하이영화관 ───────────┐");
            System.out.println("│                                │");
            System.out.println("│           1.로그인              │");
            System.out.println("│           2.상영중인 영화        │");
            System.out.println("│           3.종료                │");
            System.out.println("│                                │");
            System.out.println("└────────────────────────────────┘");
        }else{
            System.out.println("┌────"+member.id+"님 환영합니다 ───┐");
            System.out.println("│                                │");
            System.out.println("│           1.영화 예매            │");
            System.out.println("│           2.영화 예매 취소        │");
            System.out.println("│           3.영화 예매 확인        │");
            System.out.println("│           4.로그아웃             │");
            System.out.println("│                                │");
            System.out.println("└────────────────────────────────┘");
        }
        System.out.print("메뉴 선택 ->  ");
    }
    public static void movieTiketprintwithUser(Member member){
        //출력
        Userinfo.userView(member);
    }
    public static void loginMenu(){
        System.out.println("┌───────────── 로그인 ────────────┐");
        System.out.println("│                                │");
        System.out.println("│            1.로그인             │");
        System.out.println("│            2.회원가입           │");
        System.out.println("│            3.종료               │");
        System.out.println("│                                │");
        System.out.println("└────────────────────────────────┘");
        System.out.print("메뉴 선택 ->  ");
    }


    /** 영화 좌석을 보여주는 메뉴 **/
    public static void movieMenu(Movie movie) {
        System.out.println(movie.moviename);

        char alpha[] = {'A','B','C','D','E','F'};
        for (int i = 0; i < movie.movieseat.length; i++) {
            System.out.print(alpha[i]);
            for (int j = 0; j < movie.movieseat[i].length; j++) {

                if (!movie.movieseat[i][j]) {
                    System.out.print("\t□");
                } else {
                    System.out.print("\t■");
                }
            }
            System.out.println();

        }

        System.out.println("남은 좌석 :" + movie.movieseatprec + "/" + movie.movieseatpreset);
    }

}




