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


    /**
     * @param findinput 입력값을 인덱스값으로 변환하여 입력받은
     * @return 인덱스 값을 반환하여 movie의 주소값을 반환함!
     */
    public static Movie SelectFindMovie(String findinput) {
        char inputChar = findinput.charAt(0);
        int index = Character.getNumericValue(inputChar) - 1;

        if (index < 0 || index >= MakeMovie.list.size()) {
            return null;
        }

        return MakeMovie.list.get(index);
    }
    public static Movie allFindMovie(Movie movie){

    }

    }

