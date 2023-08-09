package Movie;

public class FindMovie {

    public static void printMovie() {
        // 리터레이터 초기화
        //list 컬렉션 사용을 간단하게 사용하기 위해 사용한 리터레이터

        //set 컬렉션에 저장된 값을 불러오며 member주소를 가리키게 한다
        for (int i = 0 ;i<MakeMovie.list.size();i++) { //컬렉션에 저장된 정보가 존재할때까지 확인한다
            System.out.println("\t\t"+(i+1)+"." +MakeMovie.list.get(i).moviename);
        }
    }

    public static Movie FindMovie(Movie movie){

        return
    }

    }

