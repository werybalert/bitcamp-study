package project.util;

import java.util.Random;
import java.util.Scanner;
import java.util.Stack;
import project.myapp.PlayGuessNumberGame;

public class BreadcrumbPrompt extends Prompt {

  public static Random random = new Random();
  public static Scanner scanner = new Scanner(System.in);

  // Random과 Scanner 객체를 생성합니다.

  private Stack<String> breadcrumbs = new Stack<>();

  public void appendBreadcrumb(String title) {
    this.breadcrumbs.push(title);
  }

  public void removeBreadcrumb() {
    this.breadcrumbs.pop();
  }

  public String inputMenu() {
    StringBuilder titleBuilder = new StringBuilder(); // 예) 메인/회원>
    for (int i = 0; i < this.breadcrumbs.size(); i++) {
      if (titleBuilder.length() > 0) {
        titleBuilder.append("/");
      }
      titleBuilder.append(this.breadcrumbs.get(i));
    }
    titleBuilder.append("> ");
    return this.inputString(titleBuilder.toString());
  }

  public int RandomNumber() {
    return random.nextInt(50);
  }

  public boolean isOutOfRange(int n) {
    return n > PlayGuessNumberGame.high || n < PlayGuessNumberGame.low;
  }
}


