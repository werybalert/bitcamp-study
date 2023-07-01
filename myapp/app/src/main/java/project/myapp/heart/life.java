package project.myapp.heart;

import project.PlayGuessNumberGame;


public class life {

  public static int lives;

  public static void displayRangeAndStats(int attempt) {
    System.out.println(PlayGuessNumberGame.low + "-" + PlayGuessNumberGame.high);
    System.out.println("남은 목숨: " + lives + ", 시도 횟수: " + (attempt + 1) + " >>");
  }

  public static void displayResult() {
    if (lives == 0) {
      System.out.println("목숨을 모두 사용하셨습니다. 정답은 " + PlayGuessNumberGame.card + "입니다.");
    }
  }

}
