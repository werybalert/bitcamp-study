package bitcamp.myapp;

import java.util.InputMismatchException;
import bitcamp.myapp.heart.life;
import bitcamp.myapp.prompt.prompt;

public class playGuessNumberGame {
  public static int low;
  public static int high;
  public static int card;
  public static int point;

  public static void GuessNumGame() {
    while (true) {
      point = 100;
      low = 0;
      high = 99;
      card = prompt.RandomNumber();

      System.out.println("Up & Down 게임입니다. 숨겨진 수를 맞추어 보세요");

      playGame();
      life.displayResult();

      System.out.print("다시 하시겠습니까? (y/n) >>");
      String playAgain = prompt.scanner.next();
      if (playAgain.equalsIgnoreCase("y")) {
        continue; // 게임을 다시 시작하기 위해 반복문의 처음으로 돌아갑니다
      } else {
        break; // 반복문을 종료하여 게임을 종료합니다
      }
      // return playAgain.equalsIgnoreCase("y");
    }

    return App.main(point);
  } // GuessNumGame 끗

  public static void playGame() {
    int i = 0;
    while (life.lives > 0) {
      life.displayRangeAndStats(i);
      int n = getInput();

      if (n == -1) {
        continue;
      }

      if (prompt.isOutOfRange(n)) {
        System.out.println("범위를 벗어났어요");
      } else {
        if (n == card) {
          System.out.println("맞았습니다.");
          point += 50; // 맞추면 50점 추가
          break;
        } else if (n > card) {
          System.out.println("더 낮게");
          high = n;
        } else {
          System.out.println("더 높게");
          low = n;
        }
        life.lives--;
      }
      i++;
    }
    // life.lives 가 0이 되었을 때 게임 종료 메시지와 점수 출력
    if (life.lives == 0) {
      System.out.println("게임 종료! 숨겨진 수는 " + card + "입니다.");
      System.out.println("획득한 점수: " + point + "점");
    }
  } // playGame 끗

  public static int getInput() {
    int n = 0;
    try {
      n = prompt.scanner.nextInt();
    } catch (InputMismatchException e) {
      System.out.println("정수만 입력하셔야 합니다!!");
      prompt.scanner.nextLine();
      return -1;
    }
    return n;
  } // getInput 끗


}
