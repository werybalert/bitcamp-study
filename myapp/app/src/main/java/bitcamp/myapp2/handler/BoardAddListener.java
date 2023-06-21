package bitcamp.myapp2.handler;

import bitcamp.myapp2.vo.Board;
import bitcamp.util.BreadcrumbPrompt;
import bitcamp.util.List;

public class BoardAddListener extends AbstractBoardListener {


  private List list;

  public BoardAddListener(List list) {
    super(list); // interface 의존 객체 생성
  }


  @Override
  public void service(BreadcrumbPrompt prompt) {

    Board board = new Board();
    board.setTitle(prompt.inputString("제목? "));
    board.setContent(prompt.inputString("내용? "));
    board.setWriter(prompt.inputString("작성자? "));
    board.setPassword(prompt.inputString("암호? "));
    this.list.add(board);
  }


}
