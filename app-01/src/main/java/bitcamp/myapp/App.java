// 05.26 수업내용

package bitcamp.myapp;

public class App {
  public static void main(String[] args) {
//     System.out.println("나의 목록 관리 시스템");
//     System.out.println("----------------------------------");

//     int no = 100;
//     int age = 20;
//     String name = "홍길동";
//     boolean working = true;
//     char gender = 'M';
//     float leftEye = 1.5f;
//     float rightEye = 1.0f;
    
// System.out.printf("번호: %d\n", no);
//     System.out.printf("이름: %s\n", name);
//     System.out.printf("나이: %d\n", age);
//     System.out.printf("재직자: %b\n", working);
//     System.out.printf("성별(남자(M), 여자(W)): %c\n", gender);
//     System.out.printf("좌우시력: %.1f,%.1f\n", leftEye, rightEye);


// 경로 조심!
// 컴파일 
// javac -d ./bin/main -encoding UTF-8 .\src\main\java\bitcamp\myapp\App.java

// 실행
//  java -cp bin/main bitcamp.myapp.App                                       
// 나의 목록 관리 시스템
// ----------------------------------
// 번호: 100
// 이름: 홍길동
// 나이: 20
// 재직자: true
// 성별(남자(M), 여자(W)): M
// 좌우시력: 1.5,1.0


// -----------------------------------------------------------------------
  // 컴파일 실습 
    // //유니코드 문자집합에서 문자 'A'의 문자 코드는 65 이다.
    
    // //println()에 숫자를 그냥 전달하면 일반 숫자인줄 알고 그대로 출력
    // System.out.println(65);

    //   //  출력
    //   // 65

    // //println()에 전달하는 값이 일반적인 수가 아니라 문자 코드임을 지정해야 한다.
    // //숫자 앞에 (char) 를 붙여 이 숫자가 평범한 숫자가 아니라 문자의 UCS-2 코드 값임을 알려줘라.
    // //  (char)문자코드
    // System.out.println((char)65);

    //   //  출력
    //   // A

    // //보통 문자 코드를 표현할 때 16진수를 사용한다.
    // System.out.println((char)0x41);

    // //  출력
    //   // A

    // //한글 '가'를 문자 코드를 이용하여 출력하기
    // System.out.println((char)0xAC00);

    // //  출력
    //   // 가

    // //'가' 다음 문자 출력하기
    // System.out.println((char)(0xAC00 + 1));

    // //  출력
    //   // 각

    // //영어 대문자 모두 출력하기
    // //첫 번째 알파벳의 코드 값만 안다면 + 연산자를 이용하여 출력할 수 있다.
    // for (int i = 0; i < 26; i++) {
    //   System.out.print((char)(i + 65) + ",");

    //   //  출력
    //   // A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z,

//  -------------------------------------------------------------------


  // 자바는 문자를 메모리에 저장할 때 Unicode 규칙에 따라
    // 2바이트 코드로 저장한다.

    // \ 바로 뒤에 8진수로 적을 수 있다.
    // 단, 0 ~ 377 범위의 8진수만 가능하다.
    // System.out.println('\101'); // A
    // System.out.println('\122'); // R
    // System.out.println('\377'); // ÿ
    

    // System.out.println('\477'); // 컴파일 오류!
//      오류 위치
//     .\src\main\java\bitcamp\myapp\App.java:77: error: unclosed character literal
//     System.out.println('\477'); // 컴파일 오류!

    // 유니코드 값을 직접 적는 경우는
    // 보통 키보드로 문자를 직접 입력할 수 없을 때이다.
    // System.out.println('\u4eba'); // 사람을 뜻하는 '인(人)'이라는 한자의 문자 코드
    // System.out.println('\u00a9'); // copyright를 뜻하는 '©' 문자 코드
    // System.out.println('\u03c0'); // 수학의 파이 기호 'π'
    // System.out.println('\u03a3'); // 수학의 시그마 기호 'Σ'

    // 컴파일
// PS C:\Users\bitcamp\git\bitcamp-study\myapp\app01> java -cp bin/main bitcamp.myapp.App
// A
// R
// ?
// 人
// ?
// π
// Σ

// -------------------------------------------------------------------------


//# 이스케이프 문자(escape character) = 문자 제어 코드
//- 화면에 출력하는 문자가 아니라 문자 출력을 제어하는 문자이다.
//- 제어 문자
//  \n - Line Feed(LF), 0x0a
//  \r - Carrage Return(CR), 0x0d
//  \f - Form Feed, 0x0c
//  \t - Tab, 0x09
//  \b - Backspace, 0x08
//  \' - Single Quote, 0x27
//  \" - Double Quote, 0x22
//  \\ - Backslash, 0x5c
//
    System.out.println("Hello,world!"); 
    System.out.println("Hello,\nworld!"); // 줄바꿈 문자 ①
    System.out.println("Hello,\rabc"); // 커서(cursor)를 처음으로 돌리는 문자②
   
    System.out.println("Hello,\b\b\bworld!"); // 커서를 뒤로 한 칸 이동시키는 문자③
    System.out.println("Hello,\tworld!"); // 탭 공간을 추가시키는 문자④
    System.out.println("Hello,\fworld!"); //  ⑤
    System.out.println("Hello,\"w\"orld!"); // " 문자를 출력시키는 문자 ⑥
    System.out.println("Hello,'w'orld!"); //"" 안에서 ' 문자는 그냥 적는다.⑦
    System.out.println('\''); // ' 문자를 출력시키는 문자⑧
    System.out.println('"'); // '' 안에서 " 문자는 그냥 적는다. ⑨
    System.out.println("c:\\Users\\user\\git"); // \ 문자를 출력시키는 문자 ⑩

// 컴파일
// PS C:\Users\bitcamp\git\bitcamp-study\myapp\app01> java -cp bin/main bitcamp.myapp.App
// Hello,world!

// Hello,   2
// world!

// abclo,

// Helworld!      3

// Hello,  world! 4

// Hello,
// world!           5       

// Hello,"w"orld!   6

// Hello,'w'orld!   7

// '                8

// "                9

// c:\Users\user\git        10


  }
}




