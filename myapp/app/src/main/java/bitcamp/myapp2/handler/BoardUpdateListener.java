package bitcamp.myapp2.handler;

import bitcamp.myapp2.vo.Board;
import bitcamp.util.BreadcrumbPrompt;
import bitcamp.util.List;

public class BoardUpdateListener extends AbstractBoardListener {


  public BoardUpdateListener(List list) {
    super(list); // interface 의존 객체 생성
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    int boardNo = prompt.inputInt("번호");

    Board board = findBy(boardNo);

    if (board == null) {
      System.out.println("해당 번호의 게시글이 없습니다!");
      return;
    }

    if (!prompt.inputString("암호? ").equals(board.getPassword())) {
      System.out.println("암호가 일치하지 않습니다!");
      return;
    }

    board.setTitle(prompt.inputString("게시글 제목 : %s\\n", board.getTitle()));
    board.setWriter(prompt.inputString("게시글 작성자 : %s\n", board.getTitle()));
    board.setContent(prompt.inputString("게시글 내용 : %s\n", board.getContent()));
  }



}
