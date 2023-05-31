// # 실습 프로젝트

// ## 1. 자바 프로젝트 준비하기

// - Gradle 빌드 도구를 이용하여 프로젝트 폴더를 구성하는 방법
//   - `init` task 실행
// - Gradle로 프로젝트를 빌드하고 실행하는 방법
//   - `build`, `run` task 실행

// git add .
// git commit -m "."
// git push
// git clone https://github.com/eomjinyoung/bitcamp-study bitcamp-teacher


//gradle build
// BUILD SUCCESSFUL in 3s
// 7 actionable tasks: 7 executed

//gradle run
// > Task :app:run
// Hello World!

// gradle -q run
// Hello World!



// ## 2. 리터럴을 사용하여 데이터 출력하기

// - 리터럴을 사용하는 방법



// ## 3. 변수를 사용하여 데이터를 저장하기

// - 변수를 사용하는 방법

//## 실습
//1) 컴파일하기
//- $ javac -d bin/main -encoding UTF-8 src/main/java/bitcamp/myapp/0525study.java
//
//2) 실행하기
//- $ java -cp bin/main bitcamp.myapp.0525study
//

package bitcamp.app01;

public class 525study {
  public static void main(String[] args) {
  // ## 2. 리터럴을 사용하여 데이터 출력하기
  System.out.println("-------- 정수 리터럴");
  System.out.println(78); // 10진수
  System.out.println(+78);
  System.out.println(-78);
  System.out.println(0116); // 8진수
  System.out.println(0x4e); // 16진수
  System.out.println(0b01001110); // 2진수
  
  System.out.println("-------- 부동소수점 리터럴");
  System.out.println(3.14);
  System.out.println(31.4e-1);
  
  System.out.println("-------- 논리 리터럴");
  System.out.println(true);
  System.out.println(false);
  
  System.out.println("-------- 문자 리터럴");
  System.out.println('가');
  
  System.out.println("-------- 문자열 리터럴");
  System.out.println("오호라 코딩스쿨!");
  
  }
}
  
