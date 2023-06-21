package bitcamp.myapp2.handler;

import bitcamp.myapp2.vo.Member;
import bitcamp.util.BreadcrumbPrompt;
import bitcamp.util.List;

public class MemberListListener extends AbstractMemberListener {

  private List list;

  public MemberListListener(List list) {
    super(list);
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    System.out.println("---------------------------------------");
    System.out.println("번호, 이름, 이메일, 성별");
    System.out.println("---------------------------------------");

    for (int i = 0; i < this.list.size(); i++) {
      Member m = (Member) this.list.get(i);
      System.out.printf("%d, %s, %s, %s\n", m.getNo(), m.getName(), m.getEmail(),
          toGenderString(m.getGender()));
    }
  }


}
