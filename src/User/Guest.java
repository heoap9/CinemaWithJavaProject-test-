package User;

public class Guest {
    String id;
    String pw;
    int money;

    Guest(String id,String pw){
        this.id = id;
        this.pw = pw;
    }
    Guest(String id,String pw,int money){
        this.id = id;
        this.pw = pw;
        this.money = money;
    }
}
