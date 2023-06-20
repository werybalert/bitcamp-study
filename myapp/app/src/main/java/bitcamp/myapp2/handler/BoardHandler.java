package bitcamp.myapp2.handler;

import bitcamp.myapp2.vo.Board;
import bitcamp.util.List;
import bitcamp.util.MenuPrompt;

public class BoardHandler implements Handler {


  // 06.19 실습
  private List list;
  // private List list = new LinkedList();

  // private LinkedList list = new LinkedList();

  // private ArrayList list = new ArrayList();
  private MenuPrompt prompt;
  private String title;


  public BoardHandler(MenuPrompt prompt, String title, List list) {
    this.prompt = prompt;
    this.title = title;
    this.list = list; // interface 의존 객체 생성
  }



  public void execute() {

    prompt.appendBreadcrumb(this.title, getMenu());

    prompt.printMenu();

    while (true) {
      String menuNo = prompt.inputMenu();

      switch (menuNo) {
        case "0":
          prompt.removeBreadcrumb();
          return;
        case "1":
          this.inputBoard();
          break;
        case "2":
          this.printBoards();
          break;
        case "3":
          this.viewBoard();
          break;
        case "4":
          this.updateBoard();
          break;
        case "5":
          this.deleteBoard();
          break;
      }
    }
  }

  private static String getMenu() {
    StringBuilder menu = new StringBuilder();

    menu.append("0.메인\n");
    menu.append("1.등록\n");
    menu.append("2.목록\n");
    menu.append("3.조회\n");
    menu.append("4.변경\n");
    menu.append("5.삭제\n");
    return menu.toString();
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


    // Object[] arr = this.list.toArray();
    // for (Object obj : arr) {
    for (int i = 0; i < this.list.size(); i++) {
      Board b = (Board) this.list.get(i);
      System.out.printf("%d, %s , %s, %d, %tY-%5$tm-%5$td %5$tH:%5$tM:%5$tS\n", b.getNo(),
          b.getTitle(), b.getWriter(), b.getViewCount(), b.getCreatedDate());
    }

  }

  private void viewBoard() {
    int boardNo = this.prompt.inputInt("번호? ");
    Board board = this.findBy(boardNo); // 06.19 수정 LinkedList 확인

    if (board == null) {
      System.out.println("해당 게시글이 없습니다!");
      return;
    }
    System.out.printf("게시글 번호 : %s\n", board.getNo());
    System.out.printf("게시글 제목 : %s\n", board.getTitle());
    System.out.printf("게시글 작성자 : %s\n", board.getWriter());
    System.out.printf("게시글 내용 : %s\n", board.getContent());
    System.out.printf("게시글 등록일 : %tY-%1$tm-%1$td\n", board.getCreatedDate());
    board.setViewCount(board.getViewCount() + 1);
  }

  // 06.14 refactoring 기법 수정
  private void updateBoard() {

    Board b = this.findBy(this.prompt.inputInt("번호? "));

    if (b == null) {
      System.out.println("해당 번호의 게시글이 없습니다!");
      return;
    }

    if (!this.prompt.inputString("암호? ").equals(b.getPassword())) {
      System.out.println("암호가 일치하지 않습니다!");
      return;
    }

    b.setTitle(this.prompt.inputString("게시글 제목 : %s\\n", b.getTitle()));
    b.setWriter(this.prompt.inputString("게시글 작성자 : %s\n", b.getTitle()));
    b.setContent(this.prompt.inputString("게시글 내용 : %s\n", b.getContent()));
  }


  private void deleteBoard() {
    if (!this.list.remove(new Board(this.prompt.inputInt("번호? ")))) {
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

  private Board findBy(int no) {
    Object[] arr = this.list.toArray();

    for (int i = 0; i < this.list.size(); i++) {
      Board b = (Board) this.list.get(i);
      if (b.getNo() == no) {
        return b;
      }
    }
    return null;
  }



}
