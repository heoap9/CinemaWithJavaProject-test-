package User;

public class Guest {
    public String id;
    public String pw;
    public int money;

    public Guest(String id, String pw){
        this.id = id;
        this.pw = pw;
    }
    Guest(String id,String pw,int money){
        this.id = id;
        this.pw = pw;
        this.money = money;
    }
}
