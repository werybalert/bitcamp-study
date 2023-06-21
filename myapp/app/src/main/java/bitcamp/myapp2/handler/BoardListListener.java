package bitcamp.myapp2.handler;

import bitcamp.myapp2.vo.Board;
import bitcamp.util.BreadcrumbPrompt;
import bitcamp.util.List;

public class BoardListListener extends AbstractBoardListener {



  public BoardListListener(List list) {

    super(list);
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    System.out.println("---------------------------------------");
    System.out.println("번호, 제목, 작성자, 조회수, 등록일");
    System.out.println("---------------------------------------");

    for (int i = 0; i < this.list.size(); i++) {
      Board b = (Board) this.list.get(i);
      System.out.printf("%d, %s , %s, %d, %tY-%5$tm-%5$td %5$tH:%5$tM:%5$tS\n", b.getNo(),
          b.getTitle(), b.getWriter(), b.getViewCount(), b.getCreatedDate());
    }

  }

}
