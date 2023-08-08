/** 영화 예메 프로그램 입니다**/

import Movie.*;
import User.*;
import Menu.*;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Member Accountsave = null; //계정 정보 저장을 위한 변수
        Movie movie1 = new Movie("어벤져스", 10000);
        boolean select = true;
        boolean select1 = true;
        String id;
        String pw;


        Scanner scanner = new Scanner(System.in);
        String input = null;

        Menu.movieMenu(movie1);

        while (select1) {

            Menu.mainMenu(Accountsave);
            input = scanner.nextLine();

            while (Accountsave != null) {//회원 로그인 시
                Menu.mainMenu(Accountsave);
                input = scanner.nextLine();
                switch (input.charAt(0)) {
                    /*
                                System.out.println("│           1.영화 예매            │");
                                System.out.println("│           2.영화 예매 취소        │");
                                System.out.println("│           3.영화 예매 확인        │");
                                System.out.println("│           4.로그아웃             │");

                     */
                    case '1':
                        Menu.movieMenu(movie1);
                        System.out.println("좌석을 선택해주세요");
                        input = scanner.nextLine();

                        MoviePution.BuyTiket(Accountsave, movie1, input);
                        System.out.println(Accountsave.haveticket);

                        break;

                    case '2':
                        break;

                    case '3':
                        Menu.movieTiketprintwithUser(Accountsave);
                        break;
                    case '4':
                        Accountsave= null;
                        break;

                }
            }



            switch (input.charAt(0)) {
                case '1':   /**로그인 메뉴**/
                    /**진입시 회원가입,로그인 창으로 진입**/
                    select = true;
                    while (select) {
                        Menu.loginMenu();
                        scanner = new Scanner(System.in);
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
                                    select = false;
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
                                MakeGuest.setMember(new Member(id, pw));
                                break;
                            case '3':
                                System.out.println("이전 화면으로 돌아갑니다");
                                select = false;
                                break;
                            default:
                                System.out.println("잘 못 입력하셨습니다");

                        }

                    }
                    break;


                case '2':
                    System.out.println("");
                    System.out.println("┌─────────── 상영중인 영화 ───────────┐");
                    System.out.println("│                                   │");
                    System.out.println("│           1. 어벤져스              │");
                    System.out.println("│           2. 탑건                  │");
                    System.out.println("│           3. 아바타                │");
                    System.out.println("└───────────────────────────────────┘");
                    System.out.print("영화 선택 ->  ");
                    String time = scanner.nextLine();
                    int time_num = Integer.parseInt(time);

                    switch (time_num) {
                        case 1:
                            System.out.println("");
                            System.out.println("┌─────────── 상영중 ───────────┐");
                            System.out.println("│                             │");
                            System.out.println("│           1. 9:00           │");
                            System.out.println("│                             │");
                            System.out.println("└─────────────────────────────┘");
                            System.out.print("시간 선택 ->  ");


                    }


                case '3':
                    System.out.println("종료합니다");
                    select1 = false;
                    break;

                default:
                    System.out.println("잘 못 입력하셨습니다");


            }
        }

    }
}
