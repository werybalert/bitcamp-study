package bitcamp.myapp2.handler;

import bitcamp.myapp2.vo.Board;
import bitcamp.util.BreadcrumbPrompt;
import bitcamp.util.List;

public class BoardDeleteListener extends AbstractBoardListener {

  public BoardDeleteListener(List list) {
    super(list); // interface 의존 객체 생성
  }


  @Override
  public void service(BreadcrumbPrompt prompt) {
    if (!this.list.remove(new Board(prompt.inputInt("번호? ")))) {
      System.out.println("해당 번호의 회원이 없습니다!");
    }
  }

}
