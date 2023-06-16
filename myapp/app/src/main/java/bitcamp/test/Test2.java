package bitcamp.test;

import bitcamp.myapp2.vo.Member;

public class Test2 {
  public static void main(String[] args) {
    Member m1 = new Member();
    m1.setNo(1);
    m1.setName("홍길동");
    m1.setEmail("hong@test.com");
    m1.setPassword("11111");
    m1.setGender('M');

    Member m2 = new Member();
    m2.setNo(1);
    m2.setName("유관순");
    m2.setEmail("hong@test.com");
    m2.setPassword("11111");
    m2.setGender('M');


    System.out.println(m1 == m2); // 각 레퍼런스에 저장된 인스턴스 주소를 비교
    System.out.println(m1.equals(m2));
    // equals()는 super class object의 메서드이가
    // object의 equals()는 두 인스턴스가 같은지 비교한다.

    // 실행결과
    // false
    // true

    Object obj1 = m1;
    Object obj2 = m2;

    System.out.println(obj1.equals(obj2));
    // true

    // 다형적 변수의 규칙
    // 컴파일이 통과되면, JVM이 메서드를 호출할 떄, 다형적 변수가 실제 가리키는 인스턴스의 클래스부터 찾아 올라간다.



  }
}
