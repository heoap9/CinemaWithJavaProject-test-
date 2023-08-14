package user;

import tiket.Tiket;

import java.util.*;

public class Member {
    public String id;
    public String pw;
    public int money;

    /**
     * 티켓 정보를 저장하기 위한 list
     * linkedlist으로 없어지거나 새로 동적 할당을 할 수 있다
     */
    public List<Tiket> tiketsList = new LinkedList<Tiket>();


    /**
     * 사용자의 적립금 사용,출금에 대한 컬랙션
     * linkedlist으로 없어지거나 새로 동적 할당을 할 수 있다
     */

    public List<String> moneyHistory = new LinkedList<String>();


    /**
     * 모든 사용자가 저장되는 컬렉션
     * 다만 메모리 상에 사용자 정보가 저장되어 있어 유의해야 한다
     *
     */
    public static Set<Member> set = new HashSet<Member>();



    public Member(String id, String pw){
        this.id = id;
        this.pw = pw;
    }
    /**
     * id의 hash코드 값을 비교하여 중복되는 저장값을 반환한ㄷ ㅏ
     * @return
     */
    @Override
    public int hashCode(){ //id 값을 비교하여 같은 값이 저장된다면 저장시키지 않는다.

        return id.hashCode();
    }

    @Override
    public boolean equals(Object obj) { //id의 문자열 자체를 비교하여 값이 다르다면 저장시키지 않는다.
        if (this == obj) {
            return true;
        }
        if (obj instanceof Member target) {
            return id.equals(target.id);
        }
        return false;
    }

    public void setMemberMoney(char op,int money,String useing){ //입출금 내역을 판단하여,사용처와 사용내역을 저장한다
        int i = 0;
        if(op == '+'){
            this.moneyHistory.add(useing+"\t"+"\t입금"+money+"원");
            this.money += money;
        }
        if(op == '-'){
            this.moneyHistory.add(useing+"출금"+money+"원");
            this.money -= money;
        }
    }

    public void printMemberMoneyHistory(){
        List list = this.moneyHistory;
        for(int i = 0; i< list.size(); i++){
            System.out.println( (i+1) +":" +list.get(i) );
        }
        System.out.println("현재"+this.id+"님의 보유 금액은 "+this.money+"원 입니다");
    }

    public static void MemberMoneyInput(Member member, Scanner scanner){
        String input = scanner.nextLine();
        int inputmoney = 0;

        while(true){
            try{
                inputmoney = Integer.parseInt(input);
                break;
            }catch (NumberFormatException e){
                System.out.println("숫자가 아닌 문자를 입력하셨습니다");
            }
            System.out.println("다시 입력해주세요 -->");
            input = scanner.nextLine();
        }
        member.setMemberMoney('+',inputmoney,"적립금 입금\t");
        System.out.println(member.id +"님의 보유 금액은\t "+member.money+"원 입니다");

    }






}
