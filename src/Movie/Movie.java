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
    int numCols;

    //참조 타입
    public Movie(String moviename, int movieprice,String movietime,int movieseatpreset) {

        this.numCols = setColums(movieseatpreset);
        this.numRows = setRowls(movieseatpreset,numCols);

        this.moviename = moviename;
        this.movieprice = movieprice;
        this.movietime = movietime;
        this.movieseatpreset = numCols * numRows;
        this.movieseatprec = this.movieseatpreset;

        this.movieseat = new boolean[this.numRows][this.numCols]; // 배열 생성 및 초기화 추가

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

    public static int setColums(int seatCount){
        return (int) Math.ceil(Math.sqrt(seatCount));
    }
    public static int setRowls(int seatCount,int numColumns) {
        return  (int) Math.ceil((double) seatCount / numColumns);

    }


}