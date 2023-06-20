package bitcamp.util;

import java.io.InputStream;
import java.util.Scanner;

public class Prompt {

  private static Scanner scanner;

  // default constructor 정의
  public Prompt() {
    this.scanner = new Scanner(System.in);
  }

  // 다른 입력 도구와 연결한다면?
  public Prompt(InputStream in) {
    this.scanner = new Scanner(in);
  }


  // 0614 수정
  public String inputString(String title, Object... args) {
    System.out.printf(title, args);
    return this.scanner.nextLine();
  }

  public int inputInt(String title, Object... args) {
    return Integer.parseInt(this.inputString(title, args));
  }

  public void close() {
    this.scanner.close();

  }

}
