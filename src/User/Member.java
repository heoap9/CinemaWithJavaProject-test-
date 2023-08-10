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




}
