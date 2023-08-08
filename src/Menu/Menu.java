package Menu;

import User.Member;

import java.util.Scanner;

public class Menu {
    public static void mainMenu(Member member){

        if(member == null){
            System.out.println("┌───────────── 하이영화관 ─────────┐");
            System.out.println("│                                │");
            System.out.println("│           1.로그인              │");
            System.out.println("│           2.상영중인 영화        │");
            System.out.println("│                                │");
            System.out.println("└────────────────────────────────┘");
        }else{
            System.out.println("┌───────────── 하이영화관 ─────────┐");
            System.out.println("│                                │");
            System.out.println("│           1.로그인              │");
            System.out.println("│           2.상영중인 영화        │");
            System.out.println("│     "+member.id+"님 환영합니다   │");
            System.out.println("│                                │");
            System.out.println("└────────────────────────────────┘");
        }
        System.out.print("메뉴 선택 ->  ");
    }
    public static void loginMenu(){
        System.out.println("┌───────────── 로그인    ─────────┐");
        System.out.println("│                                │");
        System.out.println("│           1.로그인              │");
        System.out.println("│          2.회원가입             │");
        System.out.println("│          3.종료                │");
        System.out.println("│                                │");
        System.out.println("└────────────────────────────────┘");
        System.out.print("메뉴 선택 ->  ");
    }

}




