package User;

import java.util.Scanner;

public class MemberFunction {
    public static void MemberMoneyInput(Member member,String input){
        int inputmoney = Integer.parseInt(input);
        member.money += inputmoney;
    }
}