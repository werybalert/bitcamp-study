package bitcamp.myapp2.handler;

import bitcamp.myapp2.vo.Board;
import bitcamp.util.BreadcrumbPrompt;
import bitcamp.util.List;

public class BoardDetailListener extends AbstractBoardListener {

  public BoardDetailListener(List list) {
    super(list); // 상속 의 결과물
  }


  @Override
  public void service(BreadcrumbPrompt prompt) {
    int boardNo = prompt.inputInt("번호? ");

    Board board = findBy(boardNo);
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



}
