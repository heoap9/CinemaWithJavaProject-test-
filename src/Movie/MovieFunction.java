package movie;

import menu.Menu;
import tiket.Tiket;
import user.Member;
import java.util.*;
import user.MakeMember;
import user.Userinfo;

public class MovieFunction {

    /*public static  boolean returnTiket(Member member, Movie movie,String input){
        //고객이 보유하고 있는 티켓을 확인하여 영화이름을 대조,
        //해당되는 영화의 좌석을 false값으로 다시 만들어 둔 뒤
        //고객의 티켓을 삭제,환불 처리를 진행한다

        String userTicket = member.haveticket;
        String usermovie = movie.moviename;
        String userid = member.id;
        int remoney = member.money;
        int moviem = movie.movieprice;

        String value = "y";
        String no = "n";
        //유저의 티켓에서
        //영화 제목에서 확인
        //그 영화의 저장된 객체를 따라가서 해당된 좌석을 false로 전환 하고
        //유저의 티켓을 삭제 해야 함

        Scanner scanner = new Scanner(System.in);

        if(userTicket == null){
            System.out.println("예매 내역이 없습니다.");
            return false;
        }

        Userinfo.userView(member);      //예매 되어 있는 고객의 티켓 정보를 보여줌.

        System.out.println("예매를 취소 하시겠습니까? y / n");
        String input1 = scanner.nextLine();

        if(input1.equals(value)){          //y / n 입력 값을 받아서 아래 내용이 실행 되게 함.

            if(MakeMember.set.contains(userTicket)){
                System.out.println("예매한 영화명을 입력하세요: ");
                String cancelMovieName = scanner.nextLine();

                if (cancelMovieName.equals()) {
                    movie.movieseat = new boolean[];
                    System.out.println(userid + "님의 예매 취소가 완료되었습니다.");
                    ++movie.movieseatprec; // 상영관의 남은 좌석 수를 다시 추가
                    remoney += moviem; // 고객의 소지금에 환불금을 더해서 리턴
                    member.money = remoney;

                    return true;

                }  else if (input.equals(no)){
                    System.out.println("취소하셨습니다.");
                    System.out.println(userid + "님의 예매 내역 " + userTicket);

                   }
        }

    }*/

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
            //member.haveticket += movie.moviename+','+ input + ','; //고객에게 티켓을 발급한다.
            member.money -= movie.movieprice; //영화의 가격만큼 고객의 금액을 차감한다
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
     * @param movie //영화의 정보를 넘겨받아 해당되는 객체(movie)의 좌석 정보를 변경 하기 위해 사용한다
     * @param input //사용자가 입력한 좌석의 정보를 입력받아 변환 (int)과정을 거쳐 좌석에 할당하기 위해 사용됨
     * @return //반환은 movie 좌석 업데이트가 완료된다면 반환된다
     */
    public static boolean seatSelect(Movie movie, String input,Tiket tiket) {
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
            tiket.row =rowprec;
            tiket.low =lowprec;
            StringBuilder result1 = new StringBuilder();
            result1.append(input.charAt(0));
            result1.append(input.charAt(1));

            tiket.tiketSeatLabel = result1.toString();
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
}
