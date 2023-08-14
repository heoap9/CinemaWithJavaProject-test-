package etc;

public class mapping {
    /**
     * 매핑 함수로
     * 특정 범위의 int숫자를 0부터 재정의하여 사용한다
     * boolean의 좌석 좌표를 찾아가기 위한 지정 범위이다
     * @param x 매핑할 변수
     * @param in_min 매핑할 변수의 최소값
     * @param in_max 매핑할 변수의 최댓값
     * @param out_min 매핑된 초기값
     * @param out_max 매핑된 최대값
     * @return 매핑된 변수를 반환시킨다
     * 들어온 변수의 범위를 매핑시켜 범위를 재지정하여 반환한다
     * 매핑의 형태는 처음 들어온 값이 65이고 in_min 이 65,
     * out_min이 0 out_max가 10이라면
     * 반환되는 값은 0이다
     *
     */
    public static int mapNumber(int  x, int in_min,int in_max,int out_min,int out_max){
        //A = 65, Z = 90
        //boolean -> 좌석 찾아들어가기

        return (x -in_min)*(out_max-out_min)/(in_max -in_min)+out_min;
    }
}
