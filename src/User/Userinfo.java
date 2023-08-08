package User;

import User.*;

public class Userinfo {

    public static void userView(Member member){

        String Ticket;
        Ticket = member.haveticket;
        String a = Ticket.replace("null", "");
        String[] arr = Ticket.split(",");
        for(String token : arr){

            //System.out.println(token);
        }
        System.out.println(a);

    }


}

