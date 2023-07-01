package project.myapp.handler;

import java.util.List;
import project.util.BreadcrumbPrompt;
import project.myapp.vo.Member;

public class MemberUpdateListener extends AbstractMemberListener {

  public MemberUpdateListener(List<Member> list) {
    super(list);

  }

  @Override
  public void service(project.util.BreadcrumbPrompt prompt) {
    int memberNo = prompt.inputInt("번호? ");

    Member m = this.findBy(memberNo);
    if (m == null) {
      System.out.println("해당 번호의 회원이 없습니다!");
      return;
    }

    m.setName(prompt.inputString("이름(%s)? ", m.getName()));
    m.setGender(inputGender(m.getGender(), prompt));
  }
}
