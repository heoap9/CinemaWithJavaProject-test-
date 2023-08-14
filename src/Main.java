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
        Movie SaveMovie = null; //영화 정보 저장을 위한 변수
        MovieCommonUsed.setMovie(new Movie("녹색전차 해모수", 8000, "08:00",60));
        MovieCommonUsed.setMovie(new Movie("엄복동", 8000, "08:00",70));
        MovieCommonUsed.setMovie(new Movie("녹색전차 해모수", 8000, "08:00",100));
        MovieCommonUsed.setMovie(new Movie("핑크퐁2", 8000, "15:00",140));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                if (Accountsave == null) {
                    Accountsave = showNonMemberMenu(Accountsave, scanner);
                } else {
                    Accountsave = showMainMenu(Accountsave, scanner);
                }
            }catch (StringIndexOutOfBoundsException e){
                System.out.println("메뉴 버튼을 잘못입력하셨습니다 다시 입력해주세요");
            }
        }
    }

    private static Member showNonMemberMenu(Member accountsave, Scanner scanner) {
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
                        accountsave = MemberCommonUsedpution.FindAccount(scanner);
                        if (accountsave != null) {
                            return accountsave;
                        }
                        break;
                    case '2':
                        if (MemberCommonUsedpution.setMember(scanner)) {
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
                break;
        }
        return null;

    }
    private static Member showMainMenu(Member accountSave, Scanner scanner) {
        Menu.mainMenu(accountSave);
        String input = scanner.nextLine();
        Movie saveMovie;
        switch (input.charAt(0)) {
            case '1':
                // 예매
                // 영화 목록을 먼저 보여주고,
                int index = Menu.showMovienameList(scanner);
                if(index > -1){
                    saveMovie = Menu.showMovieTimeListandSelect(index,scanner);
                    Menu.movieMenu(saveMovie);
                    TiketFunction.BuyTiket(accountSave, saveMovie, scanner);
                    break;
                }
                else{
                    System.out.println("이전화면으로 돌아갑니다");
                }
                break;


            case '2': //예매 취소
                System.out.println("예매 취소할 티켓을 선택해주세요");
                Menu.movieTiketprintwithUser(accountSave);
                System.out.println("->");
                if (!TiketFunction.refund(accountSave,scanner)){
                    System.out.println("티켓 선택을 잘못하셨습니다");
                }
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
                Member.MemberMoneyInput(accountSave,scanner);
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
