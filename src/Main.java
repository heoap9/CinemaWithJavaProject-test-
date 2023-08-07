// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

import  Movie.DefaultMovie;
import  User.Guest;
import  java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("췌아!");

        Guest u1 = new Guest("성근","1234");


        System.out.println(u1.id);

        /** 처음 메인화면**/

        System.out.println("========================================================");
        System.out.println("메인메뉴");
        System.out.println("========================================================");


        Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine();
        int num = Integer.parseInt(number);




    }
}