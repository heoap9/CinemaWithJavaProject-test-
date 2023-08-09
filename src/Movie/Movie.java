package Movie;

/**
 * 영화 정보를 저장하기 위한 클래스!
 *  저장되는 정보는 영화이름,시간,가격,좌석,좌석에 배정된 초기값,남은 입석수 등이 제공된다
 */
public class Movie {
    public String moviename;
    public String movietime;
    public int movieprice;
    public boolean[][] movieseat;
    public int movieseatpreset;
    public int movieseatprec;


    //참조 타입

    public Movie(String moviename) {
        this.moviename = moviename;
        this.movietime = "09:00";
        this.movieprice = 10000;
        this.movieseatpreset = 60; // 변수 이름 수정
        this.movieseatprec = movieseatpreset;
        this.movieseat = new boolean[movieseatpreset /10][10]; // 배열 생성 및 초기화 추가

    }

    public Movie(String moviename, int movieprice) {
        this.moviename = moviename;
        this.movieprice = movieprice;
        this.movieseatpreset = 60; // 변수 이름 수정
        this.movieseatprec = movieseatpreset;
        this.movieseat = new boolean[movieseatpreset /10][10]; // 배열 생성 및 초기화 추가
    }



}