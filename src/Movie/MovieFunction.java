package movie;

import menu.Menu;
import tiket.Tiket;
import user.Member;
import java.util.*;
import user.MakeMember;
import user.Userinfo;

public class MovieFunction {

    /**
     * @param member //사용자의 정보를 넘겨받아,사용자의 소유 금액 및 티켓 발급을 위한 매개값으로 사용한다
     * @param movie //영화 정보를 넘겨받아 해당되는 정보를 가지고 처리한다(영화이름,영화 가격 등)
     * @param input //사용자가 어떠한 좌석을 선택하는지 입력받는다
     * @return //정상적으로 티켓 발급이 되었는지를 확인하여 리턴한다
     */
    public static boolean BuyTiket(Member member, Movie movie,String input) { //티켓 구매시 처리되는 명령

        if (member.money >= movie.movieprice) { //고객이 소유한 금액이 영화 티켓의 가격보다 적다면 반환값을 false로 처리함 (아래 else 문을 참고
            Tiket tiket = new Tiket();
            seatSelect(movie,input,tiket);
            member.tiketsList.add(tiket);
            movie.movieseatprec --; //입석수 차감
            member.setMemberMoney('-', movie.movieprice, "영화 예매 :"+ movie.moviename);
            Menu.movieMenu(movie); //입석이 완료된 좌석을 표시함
            return true;
        } else {
            System.out.println("소지하고 있는 금액이 부족합니다");
            return false;
        }
    }

    /**
     * @param c //특정 문자를 입력받기 위해 사용한다
     * @return //반환값은 int값으로 변환되어 리턴된다
     */
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

    /**
     * 알파벳의 아스키코드를 0~25까지 재정의하여 반환한다.
     * boolean의 좌석 좌표를 찾아가기 위한 지정 범위이다
     * @param x
     * @param in_min
     * @param in_max
     * @param out_min
     * @param out_max
     * @return
     */
    public static int mapNumber(int  x, int in_min,int in_max,int out_min,int out_max){
        return (x -in_min)*(out_max-out_min)/(in_max -in_min)+out_min;
    }
    /**
     * @param movie //영화의 정보를 넘겨받아 해당되는 객체(movie)의 좌석 정보를 변경 하기 위해 사용한다
     * @param input //사용자가 입력한 좌석의 정보를 입력받아 변환 (int)과정을 거쳐 좌석에 할당하기 위해 사용됨
     * @return //반환은 movie 좌석 업데이트가 완료된다면 반환된다
     */
    public static boolean seatSelect(Movie movie, String input,Tiket tiket) {

        while (input.length() < 2 || input.length() > 3){
            System.out.println("좌석을 다시 입력해주세요");
            Scanner scanner = new Scanner(System.in);
            input = scanner.nextLine();
        }

        StringBuilder result1 = new StringBuilder();
        result1.append(input.charAt(1));
        if(input.length() >2){
            result1.append(input.charAt(2));
        }
        String result2 = result1.toString();

        int a1 = input.charAt(0);
        boolean result = a1 < 65 || a1 >90;
        int resultrow = mapNumber(input.charAt(0),65,90,1,26);
        int resultCol = Integer.parseInt(result2);

        while (movie.numRows *movie.numCols < resultrow *resultCol
                || resultrow *resultCol == 0||
                movie.numRows <resultrow || movie.numCols < resultCol ||
                result){
                System.out.println("좌석을 다시 입력해주세요");
                Scanner scanner = new Scanner(System.in);
                input = scanner.nextLine();

            result1 = new StringBuilder();
            result1.append(input.charAt(1));
            if(input.length() >2){
                result1.append(input.charAt(2));
            }
            result2 = result1.toString();

            a1 = input.charAt(0);
            result = a1 < 65 || a1 >90;
            resultrow = mapNumber(input.charAt(0),65,90,1,26);
            resultCol = Integer.parseInt(result2);
            }
        movie.movieseat[resultrow-1][resultCol-1] = true;
        tiket.row =resultrow;
        tiket.low =resultCol;

        tiket.tiketSeatLabel = result2;
        for(int i = 0; i<MakeMovie.list.size();i++){
            if(movie.equals(MakeMovie.list.get(i))){
                tiket.movieIndex = MakeMovie.list.get(i);
            }
        }
        tiket.moviename =movie.moviename;
        tiket.movietime =movie.movietime;
        return true;
        }
    }

