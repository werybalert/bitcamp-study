package bitcamp.myapp2.handler;

import bitcamp.myapp2.vo.Board;
import bitcamp.util.Prompt;

public class BoardHandler {



  private static final int MAX_SIZE = 100;
  // 인스턴스에 상관없이 공통으로 사용하는 필드라면 스태틱 필드로 선언한다!

  // 인스턴스 마다 별개로 관리해야 할 Data라면, 인스턴스 필드로 선언한다!
  private Board[] boards = new Board[MAX_SIZE];
  private int length = 0;
  Prompt prompt = new Prompt();


  public BoardHandler(Prompt prompt) {
    this.prompt = prompt;
  }


  // 인스턴스 멤버(필드나 메서드)를 사용하는 경우 인스턴스 메서드로 정의해야 한다!
  public void inputBoard() {
    if (!this.available()) {
      System.out.println("더이상 입력할 수 없습니다!");
      return;
    }

    Board board = new Board();
    board.setTitle(this.prompt.inputString("제목? "));
    board.setContent(this.prompt.inputString("내용? "));
    board.setWriter(this.prompt.inputString("작성자? "));
    board.setPassword(this.prompt.inputString("암호? "));

    // 위에서 만든 Board 인스턴스의 주소를 잃어버리지 않게
    // 레퍼런스 배열에 담는다.
    this.boards[this.length++] = board;
  }

  public void printBoards() {
    System.out.println("---------------------------------------");
    System.out.println("번호, 제목, 작성자, 조회수, 등록일");
    System.out.println("---------------------------------------");


    for (int i = 0; i < this.length; i++) {
      Board board = this.boards[i];

      System.out.printf("%d, %s, %s, %d, %tY-%5$tm-%5$td %5$tH:%5$tM:%5$tS\n", board.getNo(),
          board.getTitle(), board.getWriter(), board.getViewCount(), board.getCreatedDate());
    }
  }

  public void viewBoard() {
    String boardNo = this.prompt.inputString("번호? ");
    for (int i = 0; i < this.length; i++) {
      Board board = this.boards[i];
      if (board.getNo() == Integer.parseInt(boardNo)) {
        System.out.printf("게시글 번호 : %s\n", board.getNo());
        System.out.printf("게시글 제목 : %s\n", board.getTitle());
        System.out.printf("게시글 작성자 : %s\n", board.getWriter());
        System.out.printf("게시글 내용 : %s\n", board.getContent());
        System.out.printf("게시글 등록일 : %tY-%1$tm-%1$td\n", board.getCreatedDate());
        board.setViewCount(board.getViewCount() + 1);
        return;
      }
    }
    System.out.println("해당 게시글이 없습니다!");
  }

  // 06.14 refactoring 기법 수정
  public void updateBoard() {
    String boardNo = this.prompt.inputString("번호? ");
    for (int i = 0; i < this.length; i++) {
      Board board = this.boards[i];
      if (board.getNo() == Integer.parseInt(boardNo)) {
        if (!this.prompt.inputString("암호? : ").equals(board.getPassword())) {
          System.out.println("암호가 일치하지 않습니다!");
          return;
        }

        // String password = Prompt.inputString("암호? : ");
        // if (!password.equals(board.getPassword())) {
        // System.out.println("암호가 일치하지 않습니다!");
        // return;
        // }

        board.setTitle(this.prompt.inputString("제목(%s)? ", board.getTitle()));

        // System.out.printf("제목(%s)? ", board.getTitle());
        // board.setTitle(Prompt.inputString(""));

        board.setContent(this.prompt.inputString("내용(%s)? ", board.getContent()));

        // System.out.printf("내용(%s)? ", board.getContent());
        // board.setContent(Prompt.inputString(""));

        board.setWriter(this.prompt.inputString("작성자(%s)? ", board.getWriter()));

        // System.out.printf("작성자(%s)? ", board.getWriter());
        // board.setWriter(Prompt.inputString(""));

        return;
      }
    }
    System.out.println("해당 게시글이 없습니다!");
  }


  public void deleteBoard() {
    int deletedIndex = indexOf(this.prompt.inputInt("번호? "));

    // int boardNo = Prompt.inputInt("번호? ");
    // int deletedIndex = indexOf(boardNo);

    if (deletedIndex == -1) {
      System.out.println("해당 번호의 게시글이 없습니다!");
      return;
    }

    for (int i = deletedIndex; i < this.length - 1; i++) {
      this.boards[i] = this.boards[i + 1];
    }

    this.boards[--this.length] = null;
  }


  private int indexOf(int boardNo) {
    for (int i = 0; i < this.length; i++) {
      Board board = this.boards[i];
      if (board.getNo() == boardNo) {
        return i;
      }
    }
    return -1;
  }

  private boolean available() {
    return this.length < MAX_SIZE;
  }
}
