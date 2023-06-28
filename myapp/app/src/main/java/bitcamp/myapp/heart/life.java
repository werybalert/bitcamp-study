package bitcamp.myapp.heart;

import bitcamp.myapp.playGuessNumberGame;
import bitcamp.myapp.vo.Number;


public class life {

  public static int lives;

  public static void displayRangeAndStats(int attempt) {
    System.out.println(playGuessNumberGame.low + "-" + playGuessNumberGame.high);
    System.out.println("남은 목숨: " + lives + ", 시도 횟수: " + (attempt + 1) + " >>");
  }

  public static void displayResult() {
    if (lives == 0) {
      System.out.println("목숨을 모두 사용하셨습니다. 정답은 " + playGuessNumberGame.card + "입니다.");
    }
  }

  public static void addPoints(int points) {
    Number.totalPoints += points;
    System.out.println("획득한 점수: " + points + "점");
    System.out.println("총 점수: " + Number.totalPoints + "점");
  }

}
