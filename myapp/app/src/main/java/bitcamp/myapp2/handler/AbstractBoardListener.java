package bitcamp.myapp2.handler;

import bitcamp.myapp2.vo.Board;
import bitcamp.util.ActionListener;
import bitcamp.util.List;

public abstract class AbstractBoardListener implements ActionListener {
  // ★abstract★ = 추상 클래스임을 알림!
  protected List list;

  public AbstractBoardListener(List list) {
    this.list = list; // interface 의존 객체 생성
  }

  protected Board findBy(int no) {
    for (int i = 0; i < this.list.size(); i++) {
      Board b = (Board) this.list.get(i);
      if (b.getNo() == no) {
        return b;
      }
    }
    return null;
  }

  // abstract를 작성하면서 추상 class가 되기에 추상 method를 가질수 있다.
  // @Override
  // public void service(BreadcrumbPrompt prompt) {
  // }

}
