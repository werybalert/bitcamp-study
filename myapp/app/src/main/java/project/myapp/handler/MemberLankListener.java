package project.myapp.handler;

import java.util.List;
import project.myapp.vo.Member;
import project.util.BreadcrumbPrompt;

public class MemberLankListener extends AbstractMemberListener {

  public MemberLankListener(List<Member> list) {
    super(list);
  }


  @Override
  public void service(BreadcrumbPrompt prompt, List<Member> list) {

  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    System.out.println("회원 순위");
    System.out.println("-----------------------");
    System.out.println("번호\t이름\t성별\t총 점수");
    System.out.println("-----------------------");

    // 회원 리스트를 총 점수에 따라 내림차순으로 정렬합니다.
    list.sort((m1, m2) -> m2.getTotalPoints() - m1.getTotalPoints());

    int rank = 1;
    for (Member member : list) {
      System.out.println(
          rank + "\t" + member.getName() + "\t" + (member.getGender() == Member.MALE ? "남성" : "여성")
              + "\t" + member.getTotalPoints() + "점");
      rank++;
    }
  }

}
