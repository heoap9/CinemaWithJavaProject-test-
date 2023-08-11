package user;

public class MemberFunction {
    public static void MemberMoneyInput(Member member,String input){
        int inputmoney = Integer.parseInt(input);
        member.setMemberMoney('+',inputmoney,"적립금 입금\t");
        System.out.println(member.id +"님의 보유 금액은\t "+member.money+"원 입니다");
    }
}
