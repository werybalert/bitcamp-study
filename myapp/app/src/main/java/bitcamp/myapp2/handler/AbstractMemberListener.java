package bitcamp.myapp2.handler;

import bitcamp.myapp2.vo.Member;
import bitcamp.util.ActionListener;
import bitcamp.util.BreadcrumbPrompt;
import bitcamp.util.List;

public abstract class AbstractMemberListener implements ActionListener {
  // ★abstract★ = 추상 클래스임을 알림!
  protected List list;

  public AbstractMemberListener(List list) {
    this.list = list; // interface 의존 객체 생성
  }

  protected Member findBy(int no) {
    for (int i = 0; i < this.list.size(); i++) {
      Member m = (Member) this.list.get(i);
      if (m.getNo() == no) {
        return m;
      }
    }
    return null;
  }


  protected static String toGenderString(char gender) {
    return gender == 'M' ? "남성" : "여성";
  }

  protected char inputGender(char gender, BreadcrumbPrompt prompt) {
    String label;
    if (gender == 0) {
      label = "성별?\n";
    } else {
      label = String.format("성별(%s)?\n", toGenderString(gender));
    }

    while (true) {
      String menuNo = prompt.inputString(label + "  1. 남자\n" + "  2. 여자\n" + "> ");

      switch (menuNo) {
        case "1":
          return Member.MALE;
        case "2":
          return Member.FEMALE;
        default:
          System.out.println("무효한 번호입니다.");
      }
    }
  }

  // abstract를 작성하면서 추상 class가 되기에 추상 method를 가질수 있다.
  // @Override
  // public void service(BreadcrumbPrompt prompt) {
  // }

}
