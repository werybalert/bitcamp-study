package project.util;

import project.myapp.vo.Member;

public class Totalpoint {

  public int addPoints(Member member, int points) {
    member.setTotalPoints(member.getTotalPoints() + points);

    System.out.println("획득한 점수: " + points + "점");
    System.out.println("총 점수: " + member.getTotalPoints() + "점");
    return points;
  }
}
