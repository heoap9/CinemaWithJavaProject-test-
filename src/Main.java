// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

import Movie.DefaultMovie;
import User.*;
import Menu.*;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Member Accountsave = null; //계정 정보 저장을 위한 변수
        boolean select = true;
        boolean select1 = true;

        Scanner scanner = new Scanner(System.in);
        String input;

        while (select1) {
            Menu.mainMenu(Accountsave);
            input = scanner.nextLine();
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
                                System.out.println("");
                                System.out.println("LOGIN");
                                System.out.print("ID : ");
                                String id = scanner.nextLine();
                                System.out.print("PASSWORD : ");
                                String pw = scanner.nextLine();
                                Accountsave = FindGuest.FindAccount(id, pw);
                                if(Accountsave != null){
                                    select =false;
                                }
                                break;
                            case '2':
                                System.out.println("회원가입");
                                System.out.println("");
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
                                System.out.println("잘못입력하셨습니다");

                        }

                    }
                    break;


                case '2':
                    System.out.println("");
                    System.out.println("┌─────────── 상영중 ───────────┐");
                    System.out.println("│                             │");
                    System.out.println("│           1. 9:00           │");
                    System.out.println("│                             │");
                    System.out.println("└─────────────────────────────┘");
                    System.out.print("시간 선택 ->  ");
                    String time = scanner.nextLine();
                    int time_num = Integer.parseInt(time);

                    switch (time_num) {
                        case 1:
                            System.out.println("");
                            System.out.println("┌─────────── 상영중인 영화 ───────────┐");
                            System.out.println("│                                   │");
                            System.out.println("│           1. 어벤져스              │");
                            System.out.println("│           2. 탑건                 │");
                            System.out.println("│           3. 아바타                │");
                            System.out.println("└───────────────────────────────────┘");
                            System.out.print("영화 선택 ->  ");
                            String movie = scanner.nextLine();
                            int movie_num = Integer.parseInt(movie);
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