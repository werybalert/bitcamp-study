package project.myapp.prompt;

import java.util.Random;
import java.util.Scanner;
import project.playGuessNumberGame;


public class Prompt {
  // prompt 클래스에선 키보드에서 출력할 값과 난수 생성을 담당했다.

  public static Random random = new Random();
  public static Scanner scanner = new Scanner(System.in);
  // Random과 Scanner 객체를 생성합니다.


  public static void main(String[] args) {}

  public static String inputString(String title) {
    System.out.print(title);
    return scanner.nextLine();
  }

  public static boolean isOutOfRange(int n) {
    return n > playGuessNumberGame.high || n < playGuessNumberGame.low;
  }



  public static int RandomNumber() {
    return random.nextInt(100);
  }
}