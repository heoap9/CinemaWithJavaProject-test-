package movie;

import tiket.Tiket;

import java.util.*;

import static etc.mapping.mapNumber;

public class MovieFunction {



    /**
     * @param movie //영화의 정보를 넘겨받아 해당되는 객체(movie)의 좌석 정보를 변경 하기 위해 사용한다
     * @param input //사용자가 입력한 좌석의 정보를 입력받아 변환 (int)과정을 거쳐 좌석에 할당하기 위해 사용됨
     * @return //반환은 movie 좌석 업데이트가 완료된다면 반환된다
     */
    public static boolean seatSelect(Movie movie, String input,Tiket tiket) {

        while (input.length() < 2 || input.length() > 3){
            System.out.println("좌석을 다시 입력해주세요");
            Scanner scanner = new Scanner(System.in);
            input = scanner.nextLine();
        }

        StringBuilder result1 = new StringBuilder();
        result1.append(input.charAt(1));
        if(input.length() >2){
            result1.append(input.charAt(2));
        }
        String result2 = result1.toString();

        int a1 = input.charAt(0);
        boolean result = a1 < 65 || a1 >90;
        int resultrow = mapNumber(input.charAt(0),65,90,1,26);
        //A~ Z

        int resultCol = Integer.parseInt(result2);

        while (movie.numRows *movie.numCols < resultrow *resultCol
                || resultrow *resultCol == 0||
                movie.numRows <resultrow || movie.numCols < resultCol ||
                result){
                System.out.println("좌석을 다시 입력해주세요");
                Scanner scanner = new Scanner(System.in);
                input = scanner.nextLine();

            while (input.length() < 2 || input.length() > 3){
                System.out.println("좌석을 다시 입력해주세요");
                scanner = new Scanner(System.in);
                input = scanner.nextLine();
            }

            result1 = new StringBuilder();
            result1.append(input.charAt(1));
            if(input.length() >2){
                result1.append(input.charAt(2));
            }
            result2 = result1.toString();

            a1 = input.charAt(0);
            result = a1 < 65 || a1 >90;
            resultrow = mapNumber(input.charAt(0),65,90,1,26);
            resultCol = Integer.parseInt(result2);
            }
        movie.movieseat[resultrow-1][resultCol-1] = true;
        tiket.row =resultrow-1;
        tiket.low =resultCol-1;

        tiket.tiketSeatLabel = input;
        for(int i = 0; i<Movie.list.size();i++){
            if(movie.equals(Movie.list.get(i))){
                tiket.movieIndex = Movie.list.get(i);
            }
        }
        tiket.moviename =movie.moviename;
        tiket.movietime =movie.movietime;
        return true;
        }

    }

