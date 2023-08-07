package Movie;

import java.util.Scanner;

public class DefaultMovie {
    String moviename;
    int movieprice = 10000;
    boolean[][] movieseat;
    int row;
    int column;

    int cnt = 0;


    public DefaultMovie(String moviename, int movieprice) {
        this.moviename = moviename;
        this.movieprice = movieprice;
    }

    public void booking() {
        movieseat = new boolean[row][column];

        for (int i = 0; i < movieseat[i].length; i++) {
            for (int j = 0; j < movieseat[i].length; j++) {
                if (movieseat.equals(null)) {            //예매 되지 않은 빈좌석 카운트
                    cnt++;

                }
                    System.out.println("□");
            }
            System.out.println("남은 좌석 :" + cnt + "/ 100");

        }
    }

    public void bookseat(int row, int column){             //행과 열 각각 입력 받아 예매

        Scanner scanner = new Scanner(System.in);


        if(movieseat[row][column]){
            movieseat[row][column] = true;
            System.out.println("예매에 성공 했습니다.");
        }



        /*System.out.println("행을 선택해주세요 : " + row);
        String stra = scanner.nextLine();
        int a = Integer.parseInt(stra);


        System.out.println("열을 선택해주세요 :" + column);

        String strb = scanner.nextLine();
        int b = Integer.parseInt(strb);*/
    }


}