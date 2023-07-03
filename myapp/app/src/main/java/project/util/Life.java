package project.util;

import project.myapp.PlayGuessNumberGame;

public class Life {

  public static int lives; // 목숨 값 설정하기!

  public static void displayRangeAndStats(int attempt) {
    System.out.println(PlayGuessNumberGame.low + "-" + PlayGuessNumberGame.high);
    System.out.println("남은 목숨: " + lives + ", 시도 횟수: " + (attempt + 1) + " >>");
  }

  public static void displayResult() {
    if (lives == 0) {
      System.out.println("목숨을 모두 사용하셨습니다. 정답은 " + PlayGuessNumberGame.card + "입니다.");
    }
  }

  public static void decreaseLives() {
    lives--;
  }

  public static void resetLives() {
    lives = 10;
  }


  public static boolean isOutOfLives() {
    return lives <= 0;
  }

}
