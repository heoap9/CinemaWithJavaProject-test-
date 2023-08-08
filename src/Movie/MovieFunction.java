package Movie;

import Menu.Menu;
import User.Member;

public class MovieFunction {

    public static boolean BuyTiket(Member member, Movie movie,String input) { //티켓 구매시 처리되는 명령

        if (member.money >= movie.movieprice) { //고객이 소유한 금액이 영화 티켓의 가격보다 적다면 반환값을 false로 처리함 (아래 else 문을 참고
            if(!seatSelect(movie,input)){ //고객이 선택할 좌석을 선택하며 반환값 (입석되어있는 좌석을 선택했다면) false로 처리
                return false;
            }
            movie.movieseatprec --; //입석수 차감
            member.haveticket += input+','+movie.moviename; //고객에게 티켓을 발급한다.
            member.money -= movie.movieprice; //영화의 가격만큼 고객의 금액을 차감한다
            Menu.movieMenu(movie); //입석이 완료된 좌석을 표시함
            return true;
        } else {
            System.out.println("소지하고 있는 금액이 부족합니다");
            return false;
        }
    }

    public static int getCharwithInt(char c) { //입력값이 만약 A10 이거나 A0를 사용하게되면 고객이 보여지는 메뉴와는 다른 선택방식으로
                                                //입력되어 원하지 않는 좌석이 입력되는 문제가 있음 (무조건  A0 으로 입력된다!)
        //문자열을 정수형으로 반환하는 함수이며
        //좌석 입석 시 String 으로 입력받기 때문에 입력된 두번째 문자를 int로 반환하여 처리함
        if (c >= '1' && c <= '9') {
            if (c == '0') {
                System.out.println("좌석을 벗어났습니다");
                return -1;
            }
            return (c - '0') - 1; // 문자 '1'-'0' 를 하게되면 1이 되는 마법이다!
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
