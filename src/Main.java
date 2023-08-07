// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

import  Movie.DefaultMovie;
import User.FindGuest;
import User.MakeGuest;
import User.Member;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;


public class Main {
    public static void main(String[] args) {




        Member Accountsave;
        boolean select = true;
        boolean select1 = true;
        while (select1) {
            System.out.println("┌───────────── 하이영화관 ─────────┐");
            System.out.println("│                                │");
            System.out.println("│           1.로그인              │");
            System.out.println("│           2.상영중인 영화        │");
            System.out.println("│                                │");
            System.out.println("└────────────────────────────────┘");
            System.out.print("메뉴 선택 ->  ");

            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();


            switch (input.charAt(0)) {
                case '1': /**로그인 메뉴**/
                    /**진입시 회원가입,로그인 창으로 진입**/
                    while (select) {
                        System.out.println("┌───────────── 로그인    ─────────┐");
                        System.out.println("│                                │");
                        System.out.println("│           1.로그인              │");
                        System.out.println("│          2.회원가입             │");
                        System.out.println("│          3.종료             │");
                        System.out.println("│                                │");
                        System.out.println("└────────────────────────────────┘");
                        System.out.print("메뉴 선택 ->  ");

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
                                FindGuest.FindAccount(id, pw);

                                break;
                            case '2':
                                System.out.println("회원가입");
                                System.out.println("");
                                System.out.println("LOGIN");
                                System.out.print("ID : ");
                                id = scanner.nextLine();
                                System.out.print("PASSWORD : ");
                                pw = scanner.nextLine();
                                Accountsave = new Member(id, pw);
                                MakeGuest.setMember(Accountsave);
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
        /*

        Member member2 = new Member("tuarmsdl","1234",2000);

        MakeGuest.setMember(member1);

        Iterator<Member> iterator = MakeGuest.iterator;
        MakeGuest.setMember(member2);

        if (iterator.hasNext()) {
            System.out.println(iterator.next().id);
        }

        if (iterator.hasNext()) {
            System.out.println(iterator.next().id);
        }
    }*/
    }
}