package project.myapp.handler;

import java.util.List;


import project.myapp.vo.Member;
import project.util.BreadcrumbPrompt;

public class MemberAddListener extends AbstractMemberListener {

  public MemberAddListener(List<Member> list) {
    super(list);
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    Member m = new Member();
    m.setName(prompt.inputString("이름? "));
    m.setGender(inputGender((char)0, prompt));

    this.list.add(m);
  }

@Override
public void service(BreadcrumbPrompt prompt, List<Member> list) {
	// TODO Auto-generated method stub
	
}
}
