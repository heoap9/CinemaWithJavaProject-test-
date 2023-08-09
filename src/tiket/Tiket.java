package tiket;

import movie.Movie;
import user.Member;
public class Tiket {

    public String tiketSeatLabel; //티켓 라벨링 저장

    public int row;
    public int low;

    public String moviename;

    public int movieIndex; //Movie인덱스를 가져옴

    public Tiket(String tiketSeatLabel, int row, int low, String movie, int movieIndex){
        this.tiketSeatLabel = tiketSeatLabel;
        this.low = low;
        this.row = row;
        this.moviename =movie;
        this.movieIndex =movieIndex;

    }

    public Tiket() {

    }

    public static boolean setTiket(Member member, String tiketSeatLabel, int row, int low, String movie, int movieIndex){
        Tiket tiket = new Tiket(tiketSeatLabel,row,low,movie,movieIndex);
        member.list.add(tiket);
        return true;
    }
}
