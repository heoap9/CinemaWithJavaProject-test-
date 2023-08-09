/** 영화 예메 프로그램 입니다**/

import Movie.*;
import User.*;
import Menu.*;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Member Accountsave = null; //계정 정보 저장을 위한 변수
        //테스트용 코드
        // Accountsave = new Member("a","a");
        Movie SaveMovie = null;
        Movie movie1 = new Movie("어벤져스", 10000);
        MakeMovie.setMovie(new Movie("엄복동",8000));
        MakeMovie.setMovie(new Movie("무적콧털 보보보",8000));
        MakeMovie.setMovie(new Movie("녹색전차 해모수",8000));
        MakeMovie.setMovie(new Movie("녹색전차 해모수",8000,"08:00"));
        FindMovie.printMovie();

        boolean select = true;
        boolean select1 = true;
        String id;
        String pw;


        Scanner scanner = new Scanner(System.in);
        String input = null;
        String input1 = null;

        while (select) { //비회원 메뉴
            Menu.mainMenu(Accountsave);
            while (Accountsave != null) {//회원 로그인 시
                Menu.mainMenu(Accountsave);
                input = scanner.nextLine();
                switch (input.charAt(0)) {
                    case '1': //예매
                        Menu.movieMenu(movie1);
                        System.out.println("좌석을 선택해주세요");
                        input1 = scanner.nextLine();
                        MovieFunction.BuyTiket(Accountsave, movie1, input1);
                        break;

                    case '2'://예매 취소

                        break;

                    case '3':
                        Menu.movieTiketprintwithUser(Accountsave);
                        break;
                    case '4':
                        System.out.println("적립금 입금 메뉴 입니다");
                        System.out.println("얼마를 입금하시겠습니까?");
                        System.out.println("->");
                        MemberFunction.MemberMoneyInput(Accountsave,input);
                        break;
                    case '5':
                        Accountsave= null;
                        input =null;
                        break;

                }
            }



            input = scanner.nextLine();
            switch (input.charAt(0)) {  //비회원 로그인 시
                case '1' -> {   /**로그인 메뉴**/
                                /**진입시 회원가입,로그인 창으로 진입**/
                    while (select1) {
                        Menu.loginMenu();
                        input = scanner.nextLine();
                        switch (input.charAt(0)) {
                            case '1':
                                System.out.println("로그인");
                                System.out.println();
                                System.out.println("LOGIN");
                                System.out.print("ID : ");
                                id = scanner.nextLine();
                                System.out.print("PASSWORD : ");
                                pw = scanner.nextLine();
                                Accountsave = FindGuest.FindAccount(id, pw);
                                if (Accountsave != null) {
                                    select1 = false;
                                }
                                break;
                            case '2':
                                System.out.println("회원가입");
                                System.out.println();
                                System.out.println("LOGIN");
                                System.out.print("ID : ");
                                id = scanner.nextLine();
                                System.out.print("PASSWORD : ");
                                pw = scanner.nextLine();
                                if(MakeMember.setMember(new Member(id, pw))) {
                                    System.out.println("회원가입을 축하드립니다!");
                                    System.out.println("회원가입 축하금으로 3000포인트를 입금해드립니다");
                                }
                                break;
                            case '3':
                                System.out.println("이전 화면으로 돌아갑니다");
                                select1 = false;
                                break;
                            default:
                                System.out.println("잘 못 입력하셨습니다");

                        }

                    }
                }
                case '2' -> {
                    Menu.showMovienameList();
                    System.out.println("영화선택:-->");
                    input = scanner.nextLine();
                    SaveMovie = FindMovie.SelectFindMovie(input);
                    System.out.println();
                    System.out.println("┌─────────── 상영중 ───────────┐");
                    System.out.println("│                             │");
                    System.out.println(SaveMovie.movietime); //해당되는 영화의

                    // 모든 시간을 출력해야함 (메서드 구현)
                    System.out.println("│                             │");
                    System.out.println("└─────────────────────────────┘");
                    System.out.print("시간 선택 ->  ");
                }
                case '3' -> {
                    System.out.println("종료합니다");
                    select1 = false;
                }
                default -> System.out.println("잘 못 입력하셨습니다");
            }
        }

    }
}
