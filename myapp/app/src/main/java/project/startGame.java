package project;

import project.myapp.heart.life;
import project.myapp.prompt.Prompt;

public class startGame {
  // App2 클래스에선 출력할 화면과 에러 목숨 차감과 이전 번호 조회등으로 구성했다.

  public static void startGame() {

    life.lives = 100;
    playGuessNumberGame.GuessNumGame();
    Prompt.scanner.close();

  }

}
