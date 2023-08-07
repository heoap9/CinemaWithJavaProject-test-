package User;

public class Member {
    public String id;
    public String pw;
    public int money;

    public Member(String id, String pw){
        this.id = id;
        this.pw = pw;
    }

    public Member(String id,String pw,int money){
        this.id = id;
        this.pw = pw;
        this.money = money;
    }

    @Override
    public int hashCode(){

        return id.hashCode()+pw.hashCode()+money;
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Member target) {
            return target.id.equals(id);
        }else{
            return false;
        }
    }




}
