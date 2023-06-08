package bitcamp.myapp;

import bitcamp.myapp.prompt.prompt;
import bitcamp.myapp.heart.life;
// 6/8 과제 프로젝트

public class App2 {
//App2 클래스에선 출력할 화면과 에러 목숨 차감과 이전 번호 조회등으로 구성했다.

    public static void main(String[] args) {
        life.lives = 5;
        playGuessNumberGame.GuessNumGame();
        prompt.scanner.close();
    }
}
