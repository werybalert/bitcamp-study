package bitcamp.test;

class A {
  int v1 = 100;
  int v2 = 200;

  {
    System.out.println("111");
  }
  {
    System.out.println("222");
  }

  {
    System.out.println("333");
  }

}


// 0622 실습
public class Exam01 {
  public static void main(String[] args) {
    new A();
    new A();
    new A();

  }
}
