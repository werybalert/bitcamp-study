package bitcamp.test;

public class Test {

  public static void main(String[] args) {

    System.out.println(factorial(5));
  }

  static int factorial(int value1) {
    if (value1 == 1) {
      return 1;
    }
    return factorial(value1 - 1) * value1;
  }

}
