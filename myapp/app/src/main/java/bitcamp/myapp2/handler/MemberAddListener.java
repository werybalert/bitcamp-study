package bitcamp.myapp2.handler;

import bitcamp.myapp2.vo.Member;
import bitcamp.util.BreadcrumbPrompt;
import bitcamp.util.List;

public class MemberAddListener extends AbstractMemberListener {

  public MemberAddListener(List list) {
    super(list);
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    Member m = new Member();
    m.setName(prompt.inputString("이름? "));
    m.setEmail(prompt.inputString("이메일? "));
    m.setPassword(prompt.inputString("암호? "));
    m.setGender(inputGender((char) 0, prompt));

    this.list.add(m);
  }

}
