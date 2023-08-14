package movie;

import tiket.Tiket;

import java.util.*;

import static etc.mapping.mapNumber;

public class MovieCommonUsed {

    public static List<Movie> list = new LinkedList<Movie>();

    /**
     * @param movie //영화의 정보를 넘겨받아 해당되는 객체(movie)의 좌석 정보를 변경 하기 위해 사용한다
     * @param //사용자가 입력한 좌석의 정보를 입력받아 변환 (int)과정을 거쳐 좌석에 할당하기 위해 사용됨
     * @return //반환은 movie 좌석 업데이트가 완료된다면 반환된다
     */
    public static boolean seatSelect(Movie movie,Tiket tiket,Scanner scanner) {
        String input;

        while (true){

            input = scanner.nextLine().trim();

            if(input.length() < 2 || input.length() > 3){
                System.out.println("좌석 입력범위를 초과하셨습니다 다시 입력해주세요");
                System.out.println("입력예시는 A1, A10 대문자 영어 하나와 숫자 한개 혹은 두개를 붙여 입력하셔야 합니다");
                continue;
            }
            else {
                StringBuilder result1 = new StringBuilder();
                result1.append(input.charAt(1));
                if(input.length() >2){
                    result1.append(input.charAt(2));
                }
                String result2 = result1.toString();

                int a1 = input.charAt(0);
                boolean result = a1 < 65 || a1 >90;
                int resultrow = mapNumber(input.charAt(0),65,90,1,26);
                int resultCol = Integer.parseInt(result2);

                if(movie.numRows *movie.numCols < resultrow *resultCol){
                    System.out.println("좌석 입력값이 지금 상영중인 영화의 좌석보다 큽니다");
                    continue;
                }else if(resultrow *resultCol == 0){
                    System.out.println("입력한 값이 좌석의 할당된 범위를 벗어났습니다");
                    continue;
                }
                else if(movie.numRows <resultrow || movie.numCols < resultCol){
                    System.out.println("입력한 값이 좌석의 할당된 범위를 벗어났습니다");
                    continue;
                }else if(result){
                    System.out.println("문자를 잘못 입력하셨습니다,대문자 영어로 입력해주세요");
                    continue;
                }
                if(!movie.movieseat[resultrow - 1][resultCol - 1]){
                    movie.movieseat[resultrow-1][resultCol-1] = true;
                }else {
                    System.out.println("이미 다른 고객이 예매한 좌석입니다");
                    continue;
                }

                tiket.row =resultrow-1;
                tiket.low =resultCol-1;

                tiket.tiketSeatLabel = input;
                for(int i = 0; i<MovieCommonUsed.list.size();i++){
                    if(movie.equals(MovieCommonUsed.list.get(i))){
                        tiket.movieIndex = MovieCommonUsed.list.get(i);
                    }
                }
                tiket.moviename =movie.moviename;
                tiket.movietime =movie.movietime;
                return true;

            }
        }

        }

    public static int setMovie(Movie movie) {

        if (list.add(movie)) {
            List<Movie> list = new LinkedList<Movie>();
            return 1;
        } else {
            return 0;
        }
    }

}

