package Movie;

import User.Member;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class MakeMovie {
    public static List<Movie> list = new LinkedList<Movie>();


    /**
     * @param movie 컬렉션 구조를 사용하여
     *               id값이 같다면 저장되지 않게 구현한 영화 생성 메서드 이다
     * @return      영화가 저장됬다면  return 1, 아니라면  return 0
     */
    public static int setMovie(Movie movie){
        if(list.add (movie)){
            return 1;
        }else{
            return 0;
        }
    }
}
