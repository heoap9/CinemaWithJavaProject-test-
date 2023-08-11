package tiket;

import user.Member;
import movie.*;

public class TiketRefund {
    public static void refund(Member member,int a){
        Tiket tiket = member.tiketsList.get(a);
        Movie movie = tiket.movieIndex;
        movie.movieseat[tiket.row][tiket.low] = false;
        movie.movieseatprec++;
        member.setMemberMoney('+',movie.movieprice,"영화 예매 취소\t");
        member.tiketsList.remove(a);
        System.out.println("환불완료오!");
    }
}
