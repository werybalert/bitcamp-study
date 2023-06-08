import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;

public class App {
  private static int low;
  private static int high;
  private static int card;
  private static Random r;
  private static Scanner scanner;
  private static int lives;

  public static void main(String[] args) {
    r = new Random();
    scanner = new Scanner(System.in);
    lives = 5;

    while (true) {
      low = 0;
      high = 99;
      card = r.nextInt(100);
      System.out.println("Up & Down 게임입니다. 숨겨진 수를 맞추어 보세요");

      playGame();
      displayResult();

      System.out.print("다시 하시겠습니까? (y/n) >>");
      String playAgain = scanner.next();
      if (playAgain.equals("n"))
        break;
    }

    scanner.close();
  } // main 끝


  private static void playGame() {
    int i = 0;
    while (lives > 0) {
      displayRangeAndStats(i);
      int n = getInput();

      if (n == -1) {
        continue;
      }

      if (isOutOfRange(n)) {
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
        lives--;
      }
      i++;
    }
  }

  private static void displayRangeAndStats(int attempt) {
    System.out.println(low + "-" + high);
    System.out.println("남은 목숨: " + lives + ", 시도 횟수: " + (attempt + 1) + " >>");
  }

  private static int getInput() {
    int n = 0;
    try {
      n = scanner.nextInt();
    } catch (InputMismatchException e) {
      System.out.println("정수만 입력하셔야 합니다!!");
      scanner.nextLine();
      return -1;
    }
    return n;
  }

  private static boolean isOutOfRange(int n) {
    return n > high || n < low;
  }

  private static void displayResult() {
    if (lives == 0) {
      System.out.println("목숨을 모두 사용하셨습니다. 정답은 " + card + "입니다.");
    }
  }
}