package project.util;

import project.playGuessNumberGame;
import project.startGame;

public class MenuListener implements ActionListener {

  @Override
  public void service(BreadcrumbPrompt prompt) {}

  public static void main(String[] args, int point) {
    playGuessNumberGame.GuessNumGame();
    point = playGuessNumberGame.point;
    startGame.startGame();; // 포인트 업데이트
  }

}
