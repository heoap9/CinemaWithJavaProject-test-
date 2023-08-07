// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

import  Movie.DefaultMovie;
import  User.Guest;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        System.out.println("췌아!");

        Guest u1 = new Guest("성근","1234");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();


        switch (input.charAt(0)){
            case'1':

                break;
            case'2':
                break;
            case'3':
                break;
            case'4':
                break;
            default:
                System.out.println("잘못입력하셨습니다");
        }
        System.out.println(u1.id);




    }
}