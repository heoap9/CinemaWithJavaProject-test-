package user;

import movie.Movie;
import tiket.Tiket;
import user.*;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Userinfo {


    //member에 저장된 정보를 가져와 유저의 예매 내용을 출력 하는 메소드
    public static void userView(Member member){

        String Ticket;
        String userid;

        userid = member.id;
        Ticket = member.haveticket;

        String a = Ticket.replace("null", "");    //앞에 저장된 null이 출력 되어 삭제하기 위한 코드 입니다.
        String[] arr = Ticket.split(",");
        for(String token : arr){

            //System.out.println(token);
        }

        System.out.println("==================================");
        System.out.println(userid + "님의 예매 내역");
        System.out.println(a);
        System.out.println("==================================");

    }


}

