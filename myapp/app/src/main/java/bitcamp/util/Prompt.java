package bitcamp.util;

import java.io.InputStream;
import java.util.Scanner;

public class Prompt {

  private Scanner scanner;

  // default constructor 정의
  public Prompt() {
    this.scanner = new Scanner(System.in);
  }

  // 다른 입력 도구와 연결한다면
  public Prompt(InputStream in) {
    this.scanner = new Scanner(in);
  }

  public String inputString(String title ) {
    System.out.printf(title);
    return this.scanner.nextLine();
  }

  public int inputInt(String title) {
    return Integer.parseInt(this.inputString(title));
  }

  public void close() {
    this.scanner.close();
  }

}
