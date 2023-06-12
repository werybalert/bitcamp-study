package bitcamp.myapp;


import java.util.InputMismatchException;
import bitcamp.myapp.heart.life;
import bitcamp.myapp.prompt.prompt;

public class playGuessNumberGame {
  // playGuessNumberGame클래스에선 게임에 필요한 환경을 구성했다.

  public static int low;
  public static int high;
  public static int card;
  public static int point;


  public static void GuessNumGame() {

    while (true) {
      point = 100;
      low = 0; // 카드 값의 최소 범위
      high = 99; // 카드 값의 최대 범위
      card = prompt.RandomNumber(); // 카드에 적힌 번호 값(숨기는 값, 정답)
      System.out.println("Up & Down 게임입니다. 숨겨진 수를 맞추어 보세요");

      playGame();
      life.displayResult();

      System.out.print("다시 하시겠습니까? (y/n) >>");
      String playAgain = prompt.scanner.next();
      if (playAgain.equals("n"))
        break;
    }
  } // Guessname 끗

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
  }


  public static int getInput() {
    int n = 0;
    try {
      n = prompt.scanner.nextInt();
    } catch (InputMismatchException e) {
      // try 내부의 코드가 InputMismatchException 을 던진다면, 예외를 받아온다.
      // catch가 실행되는 동안은 Program 이 종료되지 않는다.
      System.out.println("정수만 입력하셔야 합니다!!");
      prompt.scanner.nextLine();
      return -1;
    }
    return n;
  }


  public static boolean playAgain() {
    System.out.print("다시하시겠습니까(y/n)>>");
    String answer = prompt.scanner.next();
    return answer.equalsIgnoreCase("y");
  }



}
