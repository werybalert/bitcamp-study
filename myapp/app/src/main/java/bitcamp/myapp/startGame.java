package bitcamp.myapp;

import bitcamp.myapp.handler.MemberHandler;
import bitcamp.myapp.heart.life;
// 6/8 과제 프로젝트
import bitcamp.myapp.prompt.prompt;

public class startGame {
  // App2 클래스에선 출력할 화면과 에러 목숨 차감과 이전 번호 조회등으로 구성했다.

  public static void startGame() {
    MemberHandler.printMembers(null);
    life.lives = 5;
    playGuessNumberGame.GuessNumGame();
    prompt.scanner.close();
  }

}
