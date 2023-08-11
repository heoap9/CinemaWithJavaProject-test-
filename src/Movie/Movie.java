package movie;

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

    int numRows; // 올림을 위한 +9
    final int numCols = 10;


    //참조 타입

    public Movie(String moviename) {
        this.moviename = moviename;
        this.movietime = "09:00";
        this.movieprice = 10000;
        this.movieseatpreset = 60; // 변수 이름 수정
        this.movieseatprec = movieseatpreset;
        this.numRows = (movieseatpreset + 9) / 10;
        this.movieseat = new boolean[numRows][numCols]; // 배열 생성 및 초기화 추가

    }

    public Movie(String moviename, int movieprice) {
        this.moviename = moviename;
        this.movieprice = movieprice;
        this.movietime = "09:00";
        this.movieseatpreset = 60; // 변수 이름 수정
        this.movieseatprec = movieseatpreset;
        this.numRows = (movieseatpreset + 9) / 10;
        this.movieseat = new boolean[numRows][numCols]; // 배열 생성 및 초기화 추가
    }
    public Movie(String moviename, int movieprice,String movietime) {
        this.moviename = moviename;
        this.movieprice = movieprice;
        this.movietime = movietime;
        this.movieseatpreset = 60; // 변수 이름 수정
        this.movieseatprec = movieseatpreset;
        this.numRows = (movieseatpreset + 9) / 10;
        this.movieseat = new boolean[numRows][numCols]; // 배열 생성 및 초기화 추가
    }

    @Override
    public int hashCode(){ //id 값을 비교하여 같은 값이 저장된다면 저장시키지 않는다.
        return moviename.hashCode();
    }

    @Override
    public boolean equals(Object obj) { //id의 문자열 자체를 비교하여 값이 다르다면 저장시키지 않는다.
        if (this == obj) {
            return true;
        }
        if (obj instanceof Movie target) {
            return moviename.equals(target.moviename);
        }
        return false;
    }



}