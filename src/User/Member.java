package user;

import tiket.Tiket;

import java.util.LinkedList;
import java.util.List;

public class Member {
    public String id;
    public String pw;
    public int money;
    public String haveticket;

    public List<Tiket> tiketsList = new LinkedList<Tiket>();
    public List<String> moneyHistory = new LinkedList<String>();


    public Member(String id, String pw){
        this.id = id;
        this.pw = pw;
        this.money = 100000;
    }

    public Member(String id,String pw,int money){
        this.id = id;
        this.pw = pw;
        this.money = 20000;
    }

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




}
