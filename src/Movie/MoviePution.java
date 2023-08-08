package Movie;

import Menu.Menu;
import User.Member;

public class MoviePution {

    public static boolean BuyTiket(Member member, Movie movie,String input) {
        if (member.money >= movie.movieprice) {
            if(!seatSelect(movie,input)){
                return false;
            }
            movie.movieseatprec --;
            member.haveticket += input+','+movie.moviename;
            member.money -= movie.movieprice;
            Menu.movieMenu(movie);
            return true;
        } else {
            System.out.println("소지하고 있는 금액이 부족합니다");
            return false;
        }
    }

    public static int getCharwithInt(char c) { //입력값이 만약 A10 이거나 A0를 사용하게되면 고객이 보여지는 메뉴와는 다른 선택방식으로
                                                //입력되어 원하지 않는 좌석이 입력되는 문제가 있음
                                                //즉 좌석에 할당되어 있는 값만 입력 할 수 있게 해야 함!

        if (c >= '1' && c <= '9') {
            if(c == '0'){
                System.out.println("좌석을 벗어났습니다");
                return -1;
            }
            return (c - '0')-1;
        }
        return -1;
    }


    public static boolean seatSelect(Movie movie, String input) {
        int rowprec = 0;//행
        int lowprec = 0;//열

        if (input.charAt(0) == 'A') {
            lowprec = getCharwithInt(input.charAt(1));

        } else if (input.charAt(0) == 'B') {
            lowprec = getCharwithInt(input.charAt(1));
            rowprec = 1;
        } else if (input.charAt(0) == 'C') {
            lowprec = getCharwithInt(input.charAt(1));
            rowprec = 2;
        } else if (input.charAt(0) == 'D') {
            lowprec = getCharwithInt(input.charAt(1));
            rowprec = 3;
        } else if (input.charAt(0) == 'E') {
            lowprec = getCharwithInt(input.charAt(1));
            rowprec = 4;
        } else if (input.charAt(0) == 'F') {
            lowprec = getCharwithInt(input.charAt(1));
            rowprec = 5;
        }
        int result = rowprec *lowprec;
        if(result > movie.movieseatpreset) {
            System.out.println("해당 상영관의 좌석 범위를 벗어났습니다");
            return false;
        }else {
            if(movie.movieseat[rowprec][lowprec]){
                System.out.println("이미 해당 좌석에 다른 고객이 예매 중입니다");
                return false;
            }
            movie.movieseat[rowprec][lowprec] = true;
            return true;
        }
    }
}
