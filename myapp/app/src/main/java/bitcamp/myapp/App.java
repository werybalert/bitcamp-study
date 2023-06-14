package bitcamp.myapp;

import bitcamp.myapp.handler.MemberHandler;
import bitcamp.myapp.prompt.prompt;
import bitcamp.util.Prompt;

public class App {

  public static void main(String[] args) {

    printTitle();

    printMenu();

    while (true) {
      String menuNo = prompt.inputString("메인> ");
      if (menuNo.equals("6")) {
        break;
      } else if (menuNo.equals("menu")) {
        printMenu();
      } else if (menuNo.equals("1")) {
        playGuessNumberGame.GuessNumGame();
        int point = playGuessNumberGame.point;
        MemberHandler.updateMemberPoint(point); // 포인트 업데이트
      } else if (menuNo.equals("2")) {
        MemberHandler.printMembers(null);
      } else if (menuNo.equals("3")) {
        MemberHandler.updateMember();
      } else if (menuNo.equals("4")) {
        MemberHandler.updateMember();
      } else if (menuNo.equals("5")) {
        MemberHandler.deleteMember();
      } else {
        System.out.println(menuNo);
      }
    }

    Prompt.close();
  }

  static void printMenu() {
    System.out.println("1. 게임 시작");
    System.out.println("2. 전적 조회");
    System.out.println("3. User 조회");
    System.out.println("4. User 변경");
    System.out.println("5. User 삭제");
    System.out.println("6. 종료");
  }

  static void printTitle() {
    System.out.println("랜덤으로 값을 맞추는 게임");
    System.out.println("----------------------------------");
  }

  public static void main(int point) {
    // App 클래스의 main 메서드를 재정의하여 게임 종료 후 실행되는 부분을 작성합니다.
    System.out.println("게임 종료! 획득한 점수: " + point + "점");
  }
}
