/**
 * 영화 예메 프로그램 입니다
 **/

import movie.*;
import tiket.TiketFunction;
import user.*;
import menu.*;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Member Accountsave = null; //계정 정보 저장을 위한 변수
        // 테스트 코드

        Movie SaveMovie = null; //영화 정보 저장을 위한 변수

        Movie.setMovie(new Movie("엄복동"));
        Movie.setMovie(new Movie("엄복동", 8000));
        Movie.setMovie(new Movie("무적콧털 보보보", 8000));
        Movie.setMovie(new Movie("녹색전차 해모수", 8000));
        Movie.setMovie(new Movie("녹색전차 해모수", 8000, "08:00"));

        String id;
        String pw;


        Scanner scanner = new Scanner(System.in);
        String input = null;
        String input1 = null;

        while (true) {
            if (Accountsave == null) {
                Accountsave = showNonMemberMenu(Accountsave,SaveMovie,scanner);
            } else {
                Accountsave = showMainMenu(Accountsave,SaveMovie,scanner);
            }
        }
    }

    private static Member showNonMemberMenu(Member accountsave, Movie saveMoive, Scanner scanner) {
        Menu.mainMenu(accountsave);
        String input = scanner.nextLine();
        String id;
        String pw;
        switch (input.charAt(0)) {
            case '1':
                Menu.loginMenu();
                input = scanner.nextLine();
                switch (input.charAt(0)) {
                    case '1': //로그인
                        System.out.println("로그인");
                        System.out.println();
                        System.out.println("LOGIN");
                        System.out.print("ID : ");
                        id = scanner.nextLine();
                        System.out.print("PASSWORD : ");
                        pw = scanner.nextLine();
                        accountsave = FindGuest.FindAccount(id, pw);
                        if (accountsave != null) {
                            return accountsave;
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
                        if (MakeMember.setMember(new Member(id, pw))) {
                            System.out.println("회원가입을 축하드립니다!");
                            System.out.println("회원가입 축하금으로 3000포인트를 입금해드립니다");
                        }else{
                            System.out.println("이미 존재하는 회원의 id이므로 회원가입에 실패했습니다");
                        }
                        break;
                    case '3':
                        System.out.println("종료합니다");
                        return null;
                    default:
                        System.out.println("잘못입력하셨습니다");
                        break;


                }

                break;
            case '2':
                int a = Menu.showMovienameList(scanner);
                Movie saveMovie = Menu.showMovieTimeListandSelect(a, scanner);
                Menu.movieMenu(saveMovie);
                // 영화 선택 메뉴
                // ...
                break;
            case '3':
                System.out.println("종료합니다");
                System.exit(0);
            default:
                System.out.println("잘 못 입력하셨습니다");
        }
        return null;

    }
    private static Member showMainMenu(Member accountSave, Movie saveMovie, Scanner scanner) {
        Menu.mainMenu(accountSave);
        String input = scanner.nextLine();
        switch (input.charAt(0)) {
            case '1':
                // 예매
                // 영화 목록을 먼저 보여주고,
                int index = Menu.showMovienameList(scanner);
                if(index > -1){
                    saveMovie = Menu.showMovieTimeListandSelect(index,scanner);
                    Menu.movieMenu(saveMovie);
                    System.out.println("좌석을 선택해주세요");
                    input = scanner.nextLine();
                    TiketFunction.BuyTiket(accountSave, saveMovie, input);
                    break;
                }
                else{
                    System.out.println("이전화면으로 돌아갑니다");
                }
                //상영시간을 누르면 해당 영화의 예매 페이지로 넘어가게 한다

                break;
            case '2': //예매 취소
                System.out.println("예매 취소할 티켓을 선택해주세요");
                Menu.movieTiketprintwithUser(accountSave);
                System.out.println("->");
                input = scanner.nextLine();
                int a = input.charAt(0) - '0';
                TiketFunction.refund(accountSave,a-1);

                // 티켓의 번호를 순차적으로 보여주면서
                // 해당되는 티켓의 movie 인덱스 번호를 참조하여 찾아가서 초기화 시켜야 한다
                // ...
                break;
            case '3':
                Menu.movieTiketprintwithUser(accountSave);
                break;
            case '4':
                // 적립금 입금
                // ...
                System.out.println("적립금 입금 메뉴 입니다");
                System.out.println("얼마를 입금하시겠습니까?");
                System.out.println("->");
                input = scanner.nextLine();
                Member.MemberMoneyInput(accountSave, input);
                break;
            case '5': //입출금 내역 표시
                accountSave.printMemberMoneyHistory();
                break;
            case '6':
                accountSave = null;
                return null;
            default:

                System.out.println("잘못 입력하셨습니다");
        }
        return accountSave;
    }

}
