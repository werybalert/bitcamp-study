


public class study02{


static class Score {
    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float aver;
}



  public static void main(String[] args) {


// // oop/Exma0121
//   Score s = new Score();

//     s.name = "홍길동";
//     s.kor = 100;
//     s.eng = 90;
//     s.math = 80;

//     // 1. 성적 데이터를 클래스로 묶어 놓으면 값을 다루기가 편하다.
//     // => 다음과 같이 성적 데이터를 한 번에 넘길 수 있다.
//     printScore(s);

//     Score s2 = new Score();
//     s2.name = "임꺾정";
//     s2.kor = 90;
//     s2.eng = 80;
//     s2.math = 70;
//     printScore(s2);

//     Score s3 = new Score();
//     s3.name = "유관순";
//     s3.kor = 80;
//     s3.eng = 70;
//     s3.math = 60;
//     printScore(s3);
//   }

//   static void printScore(Score s) {
//     s.sum = s.kor + s.eng + s.math;
//     s.aver = s.sum / 3;
//     System.out.printf("%s: %d, %d, %d, %d, %.1f\n",
//         s.name, s.kor, s.eng, s.math, s.sum, s.aver);


// // 결과
// // 홍길동: 100, 90, 80, 270, 90.0
// // 임꺾정: 90, 80, 70, 240, 80.0
// // 유관순: 80, 70, 60, 210, 70.0



//   // 2. 클래스를 이용하면 성적 정보와 같은 여러 개의 값을 한 번에 리턴 받을 수 있다.
//     Score s = createScore("홍길동", 100, 100, 100);
//     printScore(s);

//     Score s2 = createScore("임꺽정", 90, 80, 70);
//     printScore(s2);

//     Score s3 = createScore("유관순", 80, 70, 60);
//     printScore(s3);

//  static Score createScore(String name, int kor, int eng, int math) {
//     Score s = new Score();

//     s.name = name;
//     s.kor = kor;
//     s.eng = eng;
//     s.math = math;
//     s.sum = s.kor + s.eng + s.math;
//     s.aver = s.sum / 3;

//     return s; 
    // s에 저장된 인스턴스의 주소를 리턴한다.
    // => 모든 로컬 변수는 메서드 호출이 끝나면 스택 메모리에서 삭제됩니다.
    //  인스턴스는 힙(heap) 메모리에 생성됩니다. 어떤 메서드에서 인스턴스를 생성하든지 간에
    //    힙에 생성된 것은 메서드 호출이 끝나더라도 삭제되지 않습니다.
    //    오직 스택(stack) 메모리에 생성된 로컬 변수만이 삭제됩니다.


    //3. 여러 개의 인스턴스 주소 저장하기

// 배열 문법을 이용하면 한 번에 여러 개의 레퍼런스를 선언할 수 있다.
    // - 문법:
    //     클래스명[] 배열명 = new 클래스명[레퍼런스개수];
    // - 주의!
    //   레퍼런스 배열이다. 인스턴스 배열이 아니다!
    //

    Score[] arr = new Score[3];

    // 레퍼런스 배열을 생성하면 모든 항목이 null로 초기화 된다.
    // 아직 레퍼런스 배열의 각 항목에 인스턴스 주소가 없는 상태이다.
    System.out.println(arr[0]);
    System.out.println(arr[1]);
    System.out.println(arr[2]);

    System.out.println("------------------------");

    // 레퍼런스 배열의 각 항목에 인스턴스를 저장한 후 사용해야 한다.
    arr[0] = new Score();
    arr[1] = new Score();
    arr[2] = new Score();

    System.out.println(arr[0]);
    System.out.println(arr[1]);
    System.out.println(arr[2]);

// 결과
// null
// null
// null
// ------------------------
// study02$Score@5ca881b5
// study02$Score@24d46ca6
// study02$Score@4517d9a3

//  ★
// - 인스턴스 배열을 만들 수 없다.
// - 레퍼런스 배열만 가능하다.
// - 단 자바 기본 타입(byte, short, int, long, float, double, boolean, char)은
//   해당 타입의 메모리를 배열로 만들 수 있다.
// - 그 외 모든 타입은 오직 레퍼런스 배열만 생성한다.


   }
  }


  //  컴파일
  // javac -d bin/main -encoding UTF-8 src/main/java/bitcamp/myapp/study02.java 