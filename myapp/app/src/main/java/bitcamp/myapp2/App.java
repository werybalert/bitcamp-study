package bitcamp.myapp2;

import bitcamp.myapp2.handler.BoardHandler;
import bitcamp.myapp2.handler.Handler;
import bitcamp.myapp2.handler.MemberHandler;
import bitcamp.util.Prompt;


// ctrl + shift + o = import 자동 생성 구문

public class App {

  public static void main(String[] args) {

    Prompt prompt = new Prompt();
    Handler memberHandler = new MemberHandler(prompt, "회원"); // 의존객체 주입
    Handler boardHandler = new BoardHandler(prompt, "게시글");
    Handler readHandler = new BoardHandler(prompt, "독서록");
    // 모든 핸들러는 Handler 규칙에 따라 정의되었기 떄문에
    // Handler 레퍼런스에 그 주소를 담을 수 있다.


    // 기본 생성자를 이용해 Prompt 인스턴스 준비
    // = 기본 생성자는 Scanner를 키보드와 연결
    // Prompt prompt = new Prompt();

    printTitle();

    printMenu();

    while (true) {
      String menuNo = prompt.inputString("메인> ");
      if (menuNo.equals("0")) {
        break;
      } else if (menuNo.equals("menu")) {
        printMenu();
      } else if (menuNo.equals("1")) {
        memberHandler.execute();
      } else if (menuNo.equals("2")) {
        boardHandler.execute(); // 객체 사용하는 규칙
      } else if (menuNo.equals("3")) {
        readHandler.execute(); // 객체 사용하는 규칙
      } else {
        System.out.println("메뉴 번호가 옳지 않습니다");
      }
    }

    prompt.close();
  }

  static void printMenu() {
    System.out.println("0. 종료");
    System.out.println("1. 회원등록");
    System.out.println("2. 게시글");
    System.out.println("3. 독서록");


    // System.out.println("4. 회원변경");
    // System.out.println("5. 회원삭제");
    //
    // // 0613 실습
    // System.out.println("6. 게시글등록");
    // System.out.println("7. 게시글목록");
    // System.out.println("8. 게시글조회");
    // System.out.println("9. 게시글변경");
    // System.out.println("10. 게시글삭제");
    //
    // // 0614 실습
    // System.out.println("11. 독서록등록");
    // System.out.println("12. 독서록목록");
    // System.out.println("13. 독서록조회");
    // System.out.println("14. 독서록변경");
    // System.out.println("15. 독서록삭제");
    //
    //
    // System.out.println("99. 종료");

  }

  static void printTitle() {
    System.out.println("나의 목록 관리 시스템");
    System.out.println("----------------------------------");
  }

}
