package tiket;

import movie.Movie;
import user.Member;
public class Tiket {

    public String tiketSeatLabel; //티켓 라벨링 저장

    public int row;
    public int low;

    public String moviename;

    public Movie movieIndex; //Movie인덱스를 가져옴
    public String movietime;

    public Tiket(String tiketSeatLabel, int row, int low, String movie, Movie movieIndex){
        this.tiketSeatLabel = tiketSeatLabel;
        this.low = low;
        this.row = row;
        this.moviename =movie;
        this.movieIndex =movieIndex;

    }

    public Tiket() {

    }

    public static boolean setTiket(Member member, String tiketSeatLabel, int row, int low, String movie, Movie movieIndex){
        Tiket tiket = new Tiket(tiketSeatLabel,row,low,movie,movieIndex);
        member.tiketsList.add(tiket);
        return true;
    }
}
