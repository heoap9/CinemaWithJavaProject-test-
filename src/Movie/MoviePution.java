package Movie;

import Menu.Menu;
import User.Member;

public class MoviePution {

    public static int BuyTiket(Member member, Movie movie,String input) {
        if (member.money >= movie.movieprice) {
            Menu.movieMenu(movie);
            seatSelect(movie,input);
            movie.movieseatprec --;
            Menu.movieMenu(movie);
            member.haveticket += input+','+movie.moviename;
            return 1;
        } else {
            System.out.println("소지하고 있는 금액이 부족합니다");
            return 0;
        }
    }

    public static int getCharwithInt(char c) {
        if (c >= '0' && c <= '9') {
            if(c == '0'){
                return c - '0';
            }
            return (c - '0')-1;
        }
        return -1;
    }


    public static int seatSelect(Movie movie, String input) {
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
            return -1;
        }else {
            if(movie.movieseat[rowprec][lowprec]){
                System.out.println("이미 해당 좌석에 다른 고객이 예매 중입니다");
                return -1;
            }
            movie.movieseat[rowprec][lowprec] = true;
            return 1;
        }
    }
}
