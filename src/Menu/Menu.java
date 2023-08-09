package Menu;

import Movie.Movie;
import User.Member;
import User.*;

import java.util.Scanner;

public class Menu {
    /**
     * @param member //계정 정보를 전달받아
     *               //로그인 및 비로그인 시 예매 정보를 출력한다
     */
    public static void mainMenu(Member member){ /*로그인을 했을 경우와 아닌경우를 비교하여 다른 메인화면을 띄운다*/

        if(member == null){ //참조된 계정 정보 (main에서 사용되고 있는 계정정보를 입력받아서 다른 분기와, 화면을 제공한다
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
            System.out.println("│           4.적립금 입금          │");
            System.out.println("│           4.로그아웃             │");
            System.out.println("│                                │");
            System.out.println("└────────────────────────────────┘");
        }
        System.out.print("메뉴 선택 ->  ");
    }
    public static void movieTiketprintwithUser(Member member){ /*해당 유저가 가진 티켓의 정보를 출력함*/
        //출력
        Userinfo.userView(member);
    }
    public static void loginMenu(){ /*로그인 화면*/
        System.out.println("┌───────────── 로그인 ────────────┐");
        System.out.println("│                                │");
        System.out.println("│            1.로그인             │");
        System.out.println("│            2.회원가입           │");
        System.out.println("│            3.종료               │");
        System.out.println("│                                │");
        System.out.println("└────────────────────────────────┘");
        System.out.print("메뉴 선택 ->  ");
    }



    public static void movieMenu(Movie movie) { /* 영화 좌석을 보여주는 메뉴 */
        System.out.println(movie.moviename);    //영화 이름 출력
        for(int i = 0; i<movie.movieseat[0].length;i++){ //열의 값을 출력함
            System.out.printf("\t"+(i+1));
        }
        System.out.println();
        char alpha[] = {'A','B','C','D','E','F'}; //행의 값을 출력함
        for (int i = 0; i < movie.movieseat.length; i++) { //좌석의 입석수를 확인하며 콘솔창에 입석을 표기함
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

        System.out.println("남은 좌석 :" + movie.movieseatprec + "/" + movie.movieseatpreset); //남은 좌석을 표기한다
    }

}




