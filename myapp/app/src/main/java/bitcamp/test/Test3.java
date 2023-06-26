package bitcamp.test;

// 06.16 실습
public class Test3 extends A {
  public static void main(String[] args) {
    /*
     * Calculator2 c = new Calculator2();
     *
     * int result = c.minus(17, 3); result = c.minus(result, 4); System.out.println(result); // 10
     *
     *
     * result = c.minus(17, 3, 4); System.out.println(result); // 10
     *
     */

    A obj = new A();

    // obj.V1 = 100;
    // obj.V2 = 100;
    // obj.V3 = 100; 셋다 접근 불가 상속받은 멤버가 아니다
    obj.V4 = 100;
    // obj.m(); // 접근 불가 <= 상속 받은 멤버가 아님

    m2();
    Test3 obj2 = new Test3(); // 상속 받아서 만든 field는 protected 접근 가능!
    obj2.m3(); // 활용하려면
    // obj2.v1 = 100; // 접근 불가
    // 그냥 m3라면 => Cannot make a static reference to the non-static method m3() from the type Test3
    //
    // obj2
    // obj2.V4 = 400; // 자식 클래스가 상속 받아서 사용하는 멤버


  }

  static void m2() {

  }


  void m3() {

  }

}
