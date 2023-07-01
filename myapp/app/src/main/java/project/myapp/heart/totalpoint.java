package project.myapp.heart;

import project.myapp.vo.Member;

public class totalpoint {

  public static void addPoints(int points) {
    Member.totalPoints += points;
    System.out.println("획득한 점수: " + points + "점");
    System.out.println("총 점수: " + Member.totalPoints + "점");
  }

}
