public class study03 {
  public static void main(String[] args) {

//# 레퍼런스와 인스턴스 - 가비지

// ## 가비지 컬렉터(garbage collector)
// - 힙 메모리에 존재하는 garbage를 찾아 제거하는 일을 한다.
// - 다른 용도로 사용할 수 있도록 메모리를 해제하는 일을 한다.
// - JVM이 관리하는 메모리가 부족할 때, CPU가 한가할 때 작업

class Score {
      String name;
      int kor;
      int eng;
      int math;
      int sum;
      float aver;
    }
 // Score 레퍼런스 선언
/*  Score s1;

    // 인스턴스를 만들어 그 주소를 레퍼런스에 저장한다.
    s1 = new Score();

    // 새 인스턴스를 만들어 s1에 주소를 저장한다.
    s1 = new Score();

    // 그러면 기존에 들어 있던 주소는 잃어 버린다.
    // 주소를 잃어버려 사용할 수 없는 메모리를 "가비지(garbage)"라 부른다.

    // 가비지는 가비지 컬렉터에 의해 메모리에서 해제된다.
    // - System.gc()를 호출하여 가비지 실행을 요청할 때
    //   물론 이 경우에 바로 실행하는 것이 아니라
    //   빠른 시간 내에 실행할 것을 종용하는 것이다.

// ------------------------------------------------------
    // Score s1 = new Score();
    // Score s2 = new Score();

    // s2 = s1;
    // s1의 주소는 s2에도 저장되었다.
    // 즉 s1이 가리키는 객체는 s2도 가리키게 되었다.
    // JVM은 객체의 참조 상태를 관리하기 위해 "레퍼런스 카운트(reference count)"를 이용한다.
    // s1이 가리키는 객체처럼 주소를 알고 있는 변수가 늘어나면 레퍼런스 카운트를 증가시키고
    // s2이 이전에 가리켰던 객체처럼 주소를 알고 있는 변수가 줄어들면 레퍼런스 카운트를 감소시킨다.
    // 레퍼런스 카운트가 0인 상태가 "가비지(garbage)"이다.


    // --------------------------------------------------

 // 바깥 쪽에 별도 선언한 클래스를 사용하기
    Score s = new Score();

    s.name = "홍길동";
    s.kor = 100;
    s.eng = 90;
    s.math = 80;
    s.sum = s.kor + s.eng + s.math;
    s.aver = s.sum / 3;

    System.out.printf("%s: %d, %d, %d, %d, %.1f\n",
        s.name, s.kor, s.eng, s.math, s.sum, s.aver);

*/
 // 바깥 쪽에 별도 선언한 클래스를 사용하기
    Score s = new Score();

    s.name = "홍길동";
    s.kor = 100;
    s.eng = 90;
    s.math = 80;
    s.sum = s.kor + s.eng + s.math;
    s.aver = s.sum / 3;

    System.out.printf("%s: %d, %d, %d, %d, %.1f\n",
        s.name, s.kor, s.eng, s.math, s.sum, s.aver);


// 결과
// 홍길동: 100, 90, 80, 270, 90.0

// 컴파일할 때 Score 클래스 정보가 필요하다.
// 자바에서 기본으로 제공하는 클래스가 아닌 다른 클래스를 사용할 때 컴파일러에 Score 클래스에 대한 정보 확인 필요


// -------------------------------------
    // 특정 패키지에 소속된 여러 클래스를 사용한다면 
    // 다음과 같이 패키지명 다음에 wildcard(*)를 지정하면 편리하다.
    // 문법:
    //      import 패키지명.*;
    //
    // - 이 경우 사용하는 클래스 마다 import를 따로 지정할 필요가 없다.
    // - (주의!) 서브 패키지는 해당이 안된다.
    // - 단 소스 코드를 읽을 때 어떤 클래스가 어떤 패키지 있는지 바로 확인할 수 없는 불편함이 있다.
    //   그래서 대부분의 자바 개발자들은 널리 알려진 클래스가 아닌 경우
    //   가능한 wildcard(*)를 사용하지 않고 패키지명과 클래스명을 정확하게 명시한다.
    //
// -----------------------------------------


  }
}