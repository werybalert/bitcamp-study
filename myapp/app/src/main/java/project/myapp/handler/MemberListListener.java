package project.myapp.handler;

import java.util.Iterator;
import java.util.List;

import project.myapp.PlayGuessNumberGame;
import project.myapp.vo.Member;
import project.util.BreadcrumbPrompt;

public class MemberListListener extends AbstractMemberListener {
  private PlayGuessNumberGame game;

  public MemberListListener(List<Member> list) {
    super(list);
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    System.out.println("---------------------------------------");
    System.out.println("번호, 이름, 성별, 점수");
    System.out.println("---------------------------------------");

    Iterator<Member> iterator = list.iterator();
    while (iterator.hasNext()) {
      Member m = iterator.next();
      System.out.printf("%d, %s, %s, %d점\n",m.getNo(),
          m.getName(), toGenderString(m.getGender()), m.getTotalPoints());
    }
  }

@Override
public void service(BreadcrumbPrompt prompt, List<Member> list) {
	
		}
}
