package bitcamp.myapp2;

import bitcamp.myapp2.handler.BoardHandler;
import bitcamp.myapp2.handler.MemberHandler;
import bitcamp.util.Prompt;


// ctrl + shift + o

public class App {

  public static void main(String[] args) {

    Prompt prompt = new Prompt();
    MemberHandler memberHandler = new MemberHandler(prompt); // 의존객체 주입
    BoardHandler boardHandler = new BoardHandler(prompt);
    BoardHandler readHandler = new BoardHandler(prompt);

    // 기본 생성자를 이용해 Prompt 인스턴스 준비
    // = 기본 생성자는 Scanner를 키보드와 연결
    // Prompt prompt = new Prompt();

    printTitle();

    printMenu();

    while (true) {
      String menuNo = prompt.inputString("메인> ");
      if (menuNo.equals("99")) {
        break;
      } else if (menuNo.equals("menu")) {
        printMenu();
      } else if (menuNo.equals("1")) {
        memberHandler.inputMember();
      } else if (menuNo.equals("2")) {
        memberHandler.printMembers();
      } else if (menuNo.equals("3")) {
        memberHandler.viewMember();
      } else if (menuNo.equals("4")) {
        memberHandler.updateMember();
      } else if (menuNo.equals("5")) {
        memberHandler.deleteMember();

        // 게시판 출력 번호 (06.13)
      } else if (menuNo.equals("6")) {
        boardHandler.inputBoard();
      } else if (menuNo.equals("7")) {
        boardHandler.printBoards();
      } else if (menuNo.equals("8")) {
        boardHandler.viewBoard();
      } else if (menuNo.equals("9")) {
        boardHandler.updateBoard();
      } else if (menuNo.equals("10")) {
        boardHandler.deleteBoard();

        // 독서록 출력 번호 (06.14)
      } else if (menuNo.equals("11")) {
        readHandler.inputBoard();
      } else if (menuNo.equals("12")) {
        readHandler.printBoards();
      } else if (menuNo.equals("13")) {
        readHandler.viewBoard();
      } else if (menuNo.equals("14")) {
        readHandler.updateBoard();
      } else if (menuNo.equals("15")) {
        readHandler.deleteBoard();
      } else {
        System.out.println("메뉴 번호가 옳지 않습니다");
      }
    }

    prompt.close();
  }

  static void printMenu() {
    System.out.println("1. 회원등록");
    System.out.println("2. 회원목록");
    System.out.println("3. 회원조회");
    System.out.println("4. 회원변경");
    System.out.println("5. 회원삭제");

    // 0613 실습
    System.out.println("6. 게시글등록");
    System.out.println("7. 게시글목록");
    System.out.println("8. 게시글조회");
    System.out.println("9. 게시글변경");
    System.out.println("10. 게시글삭제");

    // 0614 실습
    System.out.println("11. 독서록등록");
    System.out.println("12. 독서록목록");
    System.out.println("13. 독서록조회");
    System.out.println("14. 독서록변경");
    System.out.println("15. 독서록삭제");


    System.out.println("99. 종료");

  }

  static void printTitle() {
    System.out.println("나의 목록 관리 시스템");
    System.out.println("----------------------------------");
  }
}
