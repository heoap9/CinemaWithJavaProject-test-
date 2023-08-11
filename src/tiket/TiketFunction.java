package tiket;

import menu.Menu;
import user.Member;
import movie.*;

import static movie.MovieFunction.seatSelect;

public class TiketFunction {
    /**
     * 티켓을 환불하는 메서드로
     * 사용자의 특정 티켓의 환불처리(구매의 역순으로 명령이 진행되며)
     * 고객이 보유한 tiket의 요소를 삭제하게 한다
     * @param member 사용중인 사용자의 주소값을 가져온다
     * @param a 티켓의 인덱스값을 가져와서 사용하게 되는 메서드 이다
     */
    public static void refund(Member member,int a){
        Tiket tiket = member.tiketsList.get(a);
        Movie movie = tiket.movieIndex;
        movie.movieseat[tiket.row][tiket.low] = false;
        movie.movieseatprec++;
        member.setMemberMoney('+',movie.movieprice,"영화 예매 취소\t");
        member.tiketsList.remove(a);
        System.out.println("환불완료오!");
    }
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
}
