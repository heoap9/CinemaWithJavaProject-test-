package menu;

import movie.*;
import user.Member;
import user.*;

import java.util.*;

public class Menu {
    /**
     * @param member //계정 정보를 전달받아
     *               //로그인 및 비로그인 시 예매 정보를 출력한다
     */
    public static void mainMenu(Member member){ /*로그인을 했을 경우와 아닌경우를 비교하여 다른 메인화면을 띄운다*/

        if(member == null){ //참조된 계정 정보 (main에서 사용되고 있는 계정정보를 입력받아서 다른 분기와, 화면을 제공한다
            System.out.println("\n" +
                    "██╗  ██╗██╗ ██████╗ ██╗  ██╗    ████████╗██╗  ██╗███████╗ █████╗ ████████╗███████╗██████╗ \n" +
                    "██║  ██║██║██╔════╝ ██║  ██║    ╚══██╔══╝██║  ██║██╔════╝██╔══██╗╚══██╔══╝██╔════╝██╔══██╗\n" +
                    "███████║██║██║  ███╗███████║       ██║   ███████║█████╗  ███████║   ██║   █████╗  ██████╔╝\n" +
                    "██╔══██║██║██║   ██║██╔══██║       ██║   ██╔══██║██╔══╝  ██╔══██║   ██║   ██╔══╝  ██╔══██╗\n" +
                    "██║  ██║██║╚██████╔╝██║  ██║       ██║   ██║  ██║███████╗██║  ██║   ██║   ███████╗██║  ██║\n" +
                    "╚═╝  ╚═╝╚═╝ ╚═════╝ ╚═╝  ╚═╝       ╚═╝   ╚═╝  ╚═╝╚══════╝╚═╝  ╚═╝   ╚═╝   ╚══════╝╚═╝  ╚═╝\n" +
                    "                                                                                          \n");
            System.out.println("┌───────────────────────────┐");
            System.out.println("│\t\t\t\t\t\t\t│");
            System.out.println("│\t\t1.로그인\t\t\t\t│");
            System.out.println("│\t\t2.상영중인 영화\t\t│");
            System.out.println("│\t\t3.종료\t\t\t\t│");
            System.out.println("│\t\t\t\t\t\t\t│");
            System.out.println("└───────────────────────────┘");
        }else{
            System.out.printf("┌──── %4s님, 환영합니다.\t───┐\n", member.id);
            System.out.println("│\t\t\t\t\t\t\t│");
            System.out.println("│\t\t1.영화 예매\t\t\t│");
            System.out.println("│\t\t2.영화 예매 취소\t\t│");
            System.out.println("│\t\t3.영화 예매 확인\t\t│");
            System.out.println("│\t\t4.적립금 입금\t\t\t│");
            System.out.println("│\t\t5.적립금 사용내역\t\t│");
            System.out.println("│\t\t6.로그 아웃\t\t\t│");
            System.out.println("│\t\t\t\t\t\t\t│");
            System.out.println("└───────────────────────────┘");
        }
        System.out.print("메뉴 선택 ->  ");
    }
    public static void movieTiketprintwithUser(Member member){ /*해당 유저가 가진 티켓의 정보를 출력함*/
        //출력
        //Userinfo.userView(member);
        for(int i = 0; i<member.tiketsList.size();i++){
            System.out.println(
                    "\t\t"+(i+1)+"."+member.tiketsList.get(i).moviename+"\t"+
                            member.tiketsList.get(i).tiketSeatLabel+"좌석\t"+
                            member.tiketsList.get(i).movietime+"시");
        }
    }

    /**
     * 영화 정보 출력
     */
    public static int showMovienameList(Scanner scanner){
        System.out.println("");
        System.out.println("┌─────────── 상영중인 영화 ───────────┐");
        System.out.println("│\t\t\t\t\t\t\t\t\t│");
        Set<String> namelist = new HashSet<>();
        List<String> list = new LinkedList<String>();

        if(MakeMovie.list.size() > 0){

            int addfaild = 0;
            //set 컬렉션에 저장된 값을 불러오며 member주소를 가리키게 한다
            for (int i = 0 ;i<MakeMovie.list.size();i++) { //컬렉션에 저장된 정보가 존재할때까지 확인한다
                if(!namelist.add(MakeMovie.list.get(i).moviename)){
                    addfaild++;
                }
            }
            int i = 1;
            for (String movieName : namelist) {
                System.out.println("\t\t" + (i++) + ". " + movieName);
                list.add(movieName);
            }

        }else{
            System.out.println("\t\t상영중인 영화가 없습니다");
            return  0;
        }
        System.out.println("│\t\t\t\t\t\t\t\t\t│");
        System.out.println("└───────────────────────────────────┘");
            System.out.print("영화 선택 ->  ");
            String input = scanner.nextLine();
            int a = input.charAt(0)-'0';

            for(int i = 0; i < MakeMovie.list.size(); i++)
            {
                if(list.get(a-1).equals(MakeMovie.list.get(i).moviename)){
                    return i;
                }
            }
            return 0;


    }
    public  static  Movie showMovieTimeListandSelect(int input,Scanner scanner){

        if (input < 0 || input >= MakeMovie.list.size()) {
            System.out.println("올바르지 않은 입력입니다.");
            return null;
        }
        String selectedMovieName = MakeMovie.list.get(input).moviename;

        System.out.println("┌──────── 상영중인 영화의 시간 ───────┐");
        System.out.println("│\t\t\t\t\t\t\t\t\t│");

        int count = 1;
        for (Movie movie : MakeMovie.list) {
            if (selectedMovieName.equals(movie.moviename)) {
                System.out.println(
                        "\t" + count + ". " + movie.movietime + " 남은좌석:" +
                                movie.movieseatprec + "/" +
                                movie.movieseatpreset);
                count++;
            }
        }

        System.out.println("│\t\t\t\t\t\t\t\t\t│");
        System.out.println("└───────────────────────────────────┘");
        System.out.print("영화 시간 선택 ->  ");
        int selectedTimeIndex = Integer.parseInt(scanner.nextLine()) - 1;

        count = 0;
        for (Movie movie : MakeMovie.list) {
            if (selectedMovieName.equals(movie.moviename)) {
                if (count == selectedTimeIndex) {
                    return movie;
                }
                count++;
            }
        }
        return null;


    }

    /**
     *
     */
    public static void loginMenu(){ /*로그인 화면*/
        System.out.println("┌───────────── 로그인 ────────────┐");
        System.out.println("│                                │");
        System.out.println("│            1.로그인             │");
        System.out.println("│            2.회원가입           │");
        System.out.println("│            3.종료               │");
        System.out.println("│                                │");
        System.out.println("└────────────────────────────────┘");
        System.out.print("메뉴 선택 ->  ");
    }





    public static void movieMenu(Movie movie) { /* 영화 좌석을 보여주는 메뉴 */
        System.out.println(movie.moviename);    //영화 이름 출력
        for(int i = 0; i<movie.movieseat[0].length;i++){ //열의 값을 출력함
            System.out.printf("\t"+(i+1));
        }
        System.out.println();
        char alpha[] = {'A','B','C','D','E','F'}; //행의 값을 출력함
        for (int i = 0; i < movie.movieseat.length; i++) { //좌석의 입석수를 확인하며 콘솔창에 입석을 표기함
            System.out.print(alpha[i]);
            for (int j = 0; j < movie.movieseat[i].length; j++) {

                if (!movie.movieseat[i][j]) {
                    System.out.print("\t□");
                } else {
                    System.out.print("\t■");
                }
            }
            System.out.println();

        }

        System.out.println("남은 좌석 :" + movie.movieseatprec + "/" + movie.movieseatpreset); //남은 좌석을 표기한다
    }

}




