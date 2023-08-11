package etc;

public class mapping {
    /**
     * 매핑 함수로
     * 특정 범위의 int숫자를 0부터 재정의하여 사용한다
     * boolean의 좌석 좌표를 찾아가기 위한 지정 범위이다
     * @param x
     * @param in_min
     * @param in_max
     * @param out_min
     * @param out_max
     * @return
     */
    public static int mapNumber(int  x, int in_min,int in_max,int out_min,int out_max){
        //A = 65, Z = 90
        //boolean -> 좌석 찾아들어가기

        return (x -in_min)*(out_max-out_min)/(in_max -in_min)+out_min;
    }
}
