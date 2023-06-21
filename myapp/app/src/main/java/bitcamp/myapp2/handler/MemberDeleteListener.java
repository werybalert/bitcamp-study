package bitcamp.myapp2.handler;

import bitcamp.myapp2.vo.Member;
import bitcamp.util.BreadcrumbPrompt;
import bitcamp.util.List;

public class MemberDeleteListener extends AbstractMemberListener {

  private List list;

  public MemberDeleteListener(List list) {
    super(list);
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    if (!this.list.remove(new Member(prompt.inputInt("번호? ")))) {
      System.out.println("해당 번호의 회원이 없습니다!");
    }
  }

}
