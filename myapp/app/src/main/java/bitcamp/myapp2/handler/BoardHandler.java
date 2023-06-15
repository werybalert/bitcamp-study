package bitcamp.myapp2.handler;

import bitcamp.myapp2.vo.Board;
import bitcamp.util.Prompt;

public class BoardHandler implements Handler {

  // private static final int MAX_SIZE = 100;
  // 인스턴스에 상관없이 공통으로 사용하는 필드라면 스태틱 필드로 선언한다!

  // 인스턴스 마다 별개로 관리해야 할 Data라면, 인스턴스 필드로 선언한다!
  // private Board[] boards = new Board[MAX_SIZE];
  // private int length = 0;
  private BoarderList list = new BoarderList();
  private Prompt prompt;
  private String name;


  public BoardHandler(Prompt prompt, String name) {
    this.prompt = prompt;
    this.name = name;
  }

  private static void printMenu() {
    System.out.println("0. 메인");
    System.out.println("1. 등록");
    System.out.println("2. 목록");
    System.out.println("3. 조회");
    System.out.println("4. 변경");
    System.out.println("5. 삭제");
  }

  public void execute() {
    printMenu();

    while (true) {
      String menuNo = prompt.inputString(" %s > ", this.name);
      if (menuNo.equals("0")) {
        return;
      } else if (menuNo.equals("menu")) {
        printMenu();
      } else if (menuNo.equals("1")) {
        this.inputBoard();
      } else if (menuNo.equals("2")) {
        this.printBoards();
      } else if (menuNo.equals("3")) {
        this.viewBoard();
      } else if (menuNo.equals("4")) {
        this.updateBoard();
      } else if (menuNo.equals("5")) {
        this.deleteBoard();
      } else {
        System.out.println("메뉴 번호가 옳지 않습니다");
      }
    }
  }

  // 인스턴스 멤버(필드나 메서드)를 사용하는 경우 인스턴스 메서드로 정의해야 한다!
  private void inputBoard() {
    Board board = new Board();
    board.setTitle(this.prompt.inputString("제목? "));
    board.setContent(this.prompt.inputString("내용? "));
    board.setWriter(this.prompt.inputString("작성자? "));
    board.setPassword(this.prompt.inputString("암호? "));

    // // 위에서 만든 Board 인스턴스의 주소를 잃어버리지 않게
    // // 레퍼런스 배열에 담는다.
    // this.boards[this.length++] = board;
    this.list.add(board);
  }

  private void printBoards() {
    System.out.println("---------------------------------------");
    System.out.println("번호, 제목, 작성자, 조회수, 등록일");
    System.out.println("---------------------------------------");


    Board[] arr = list.list();
    for (Board b : arr) {
      System.out.printf("%d, %s, %s, %d, %tY-%5$tm-%5$td %5$tH:%5$tM:%5$tS\n", b.getNo(),
          b.getTitle(), b.getWriter(), b.getViewCount(), b.getCreatedDate());
    }
  }

  private void viewBoard() {
    int boardNo = this.prompt.inputInt("번호? ");
    Board board = this.list.get(boardNo);

    if (board == null) {
      System.out.println("해당 게시글이 없습니다!");
      return;
    }
    System.out.printf("게시글 번호 : %s\n", board.getNo());
    System.out.printf("게시글 제목 : %s\n", board.getTitle());
    System.out.printf("게시글 작성자 : %s\n", board.getWriter());
    System.out.printf("게시글 내용 : %s\n", board.getContent());
    System.out.printf("게시글 등록일 : %tY-%1$tm-%1$td\n", board.getCreatedDate());
  }

  // 06.14 refactoring 기법 수정
  private void updateBoard() {
    /*
     * String boardNo = this.prompt.inputString("번호? "); for (int i = 0; i < this.length; i++) {
     * Board board = this.boards[i]; if (board.getNo() == Integer.parseInt(boardNo)) { if
     * (!this.prompt.inputString("암호? : ").equals(board.getPassword())) {
     * System.out.println("암호가 일치하지 않습니다!"); return; }
     *
     * // String password = Prompt.inputString("암호? : "); // if
     * (!password.equals(board.getPassword())) { // System.out.println("암호가 일치하지 않습니다!"); // return;
     * // }
     *
     * board.setTitle(this.prompt.inputString("제목(%s)? ", board.getTitle()));
     *
     * // System.out.printf("제목(%s)? ", board.getTitle()); //
     * board.setTitle(Prompt.inputString(""));
     *
     * board.setContent(this.prompt.inputString("내용(%s)? ", board.getContent()));
     *
     * // System.out.printf("내용(%s)? ", board.getContent()); //
     * board.setContent(Prompt.inputString(""));
     *
     * board.setWriter(this.prompt.inputString("작성자(%s)? ", board.getWriter()));
     *
     * // System.out.printf("작성자(%s)? ", board.getWriter()); //
     * board.setWriter(Prompt.inputString(""));
     *
     * return; } } System.out.println("해당 게시글이 없습니다!");
     */

    int boardNo = this.prompt.inputInt("번호? ");
    Board b = this.list.get(boardNo);

    if (b == null) {
      System.out.println("해당 번호의 게시글이 없습니다!");
      return;
    }
    b.setTitle(this.prompt.inputString("게시글 제목 : %s\\n", b.getTitle()));
    b.setWriter(this.prompt.inputString("게시글 작성자 : %s\n", b.getTitle()));
    b.setContent(this.prompt.inputString("게시글 내용 : %s\n", b.getContent()));
  }


  private void deleteBoard() {
    if (!this.list.delete(this.prompt.inputInt("번호? "))) {
      System.out.println("해당 번호의 회원이 없습니다!");
    }
    /*
     * // int boardNo = Prompt.inputInt("번호? "); // int deletedIndex = indexOf(boardNo);
     *
     * if (deletedIndex == -1) { System.out.println("해당 번호의 게시글이 없습니다!"); return; }
     *
     * for (int i = deletedIndex; i < this.length - 1; i++) { this.boards[i] = this.boards[i + 1]; }
     *
     * this.boards[--this.length] = null;
     */
  }



}
