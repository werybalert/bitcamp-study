// # 05.25 수업 코드
// ## 1. 자바 프로젝트 준비하기

// - Gradle 빌드 도구를 이용하여 프로젝트 폴더를 구성하는 방법
//   - Gradle 의 'init' task를 사용하는 방법

// - Gradle로 프로젝트를 빌드하고 실행하는 방법
//   - 'build', 'run' task 실행

// gradle init

// gradle build

// 결과 > 
// PS C:\Users\bitcamp\git\bitcamp-study\myapp> gradle run

// > Task :app:run
// Hello World!


// PS C:\Users\bitcamp\git\bitcamp-study\myapp> gradle -q run		- q : quit!
// Hello World!





// ## 2. 컴파일 실습

//ex03)#Exam0100.java
// public class study01 {
//   public static void main(String[] args) {
    // System.out.println("-------- 정수 리터럴");
    // System.out.println(78); // 10진수
    // System.out.println(+78);
    // System.out.println(-78);
    // System.out.println(0116); // 8진수
    // System.out.println(0x4e); // 16진수
    // System.out.println(0b01001110); // 2진수
    
    // System.out.println("-------- 부동소수점 리터럴");
    // System.out.println(3.14);
    // System.out.println(31.4e-1);
    
    // System.out.println("-------- 논리 리터럴");
    // System.out.println(true);
    // System.out.println(false);
    
    // System.out.println("-------- 문자 리터럴");
    // System.out.println('가');
    
    // System.out.println("-------- 문자열 리터럴");
    // System.out.println("오호라 코딩스쿨!");


// 컴파일 : 
// PS C:\Users\USER\git\bitcamp-study\bitcamp-study\myapp\app-02> 
// javac -d bin/main -encoding UTF-8 src/main/java/bitcamp/myapp/study01.java 

// 결과
// PS C:\Users\USER\git\bitcamp-study\bitcamp-study\myapp\app-02\bin\main> java study01              
// -------- 정수 리터럴
// 78
// 78
// -78
// 78
// 78
// 78
// -------- 부동소수점 리터럴
// 3.14
// 3.14
// -------- 논리 리터럴
// true
// false
// -------- 문자 리터럴
// 가
// -------- 문자열 리터럴
// 오호라 코딩스쿨!

// ------------------------------------------------------------

// #ex02)Exam0200
//   public static String message = "Goodbye~ , world!";
  
//   public static void main(String[] args) {

//    System.out.println(message);
//   }

// 결과
// PS C:\Users\USER\git\bitcamp-study\bitcamp-study\myapp\app-02\bin\main> java study01        
// Goodbye~, world!

// ------------------------------------------------------------



// 2. 리터럴 문법을 사용하여 데이터 출력하기

// - 리터럴 문법을 사용하는 방법
//   - 

// public class study01 {
//    public static void main(String[] args) {

//  //10진수 리터럴 
//     //- 코드에서 일반적으로 정수 값을 표현할 때 사용한다.
//     System.out.println(100);
    
//     //8진수 리터럴
//     //- 코드를 작성할 때 잘 사용하지 않는다.
//     //- 0으로 시작해야 한다.
//     System.out.println(0144);
    
//     //2진수 리터럴
//     //- 메모리의 상태를 직설적으로 보여주고 싶을 때 사용한다.
//     //- 0b 또는 0B로 시작한다.
//     System.out.println(0b1100100);
//     System.out.println(0B1100100);
    
//     //- 숫자 앞에 0이 있어도 된다.
//     System.out.println(0b01100100);
//     System.out.println(0B01100100);
    
//     //16진수 리터럴
//     //- 2진수를 간결하게 표현하기 위해 사용한다.
//     //- 0x 또는 0X 로 시작한다.
//     System.out.println(0x64);
//     System.out.println(0X64);
    
//     //- 숫자 앞에 0이 있어도 된다.
//     System.out.println(0x064);
//     System.out.println(0X064);


//   }
// }

// //결과 
// java study01                                                
// 100
// 100
// 100
// 100
// 100
// 100
// 100
// 100
// 100
// 100

// ex03) Exam0220
//  public class study01 {
//     public static void main(String[] args) {

//     //## 10진수에 _ 문자를 삽입하기
//     System.out.println(12783406);
//     System.out.println(1278_3406);
//     System.out.println(12_783_406);

//     //숫자 맨 앞 또는 맨 뒤에 삽입할 수 없다.
//     //System.out.println(_12783406); 
//     //System.out.println(12783406_);
    
//     // error



//     //## 8진수에 _ 문자를 삽입하기
//     System.out.println(077);
//     System.out.println(0_77);
//     System.out.println(07_7);

//     //숫자 맨 앞 또는 맨 뒤에 삽입할 수 없다.
//     //System.out.println(_077);
//     //System.out.println(077_);

//     // error

//     //## 2진수에 _ 문자를 삽입하기
//     System.out.println(0b1100100);
//     System.out.println(0b110_0100);
//     System.out.println(0b1_1_0_0_1_0_0);

//     //숫자 맨 앞 또는 맨 뒤에 삽입할 수 없다.
//     //System.out.println(0b_1100100);
//     //System.out.println(0b1100100_);

//     // error

//     //## 16진수에 _ 문자를 삽입하기
//     System.out.println(0xffaa);
//     System.out.println(0xff_aa);

//     //숫자 맨 앞 또는 맨 뒤에 삽입할 수 없다.
//     //System.out.println(0x_ffaa);
//     //System.out.println(0xffaa_);

//     // error

//     }
//   }


//   PS C:\Users\USER\git\bitcamp-study\bitcamp-study\myapp\app-02\bin\main> java study01  
// 12783406
// 12783406
// 12783406
// 63
// 63
// 63
// 100
// 100
// 100
// 65450
// 65450


// eX03) Exam0230
//  public class study01 {
//     public static void main(String[] args) {
//        //## 4바이트 정수
//     //접미사를 붙이지 않고 그냥 숫자를 표현하면 4바이트 크기의 메모리에 저장되는 정수를 표현한다.
//     System.out.println(2147483647); // 4바이트 양의 정수 최대값
//     System.out.println(-2147483648); // 4바이트 음의 정수 최소값

//     //4바이트 메모리 크기를 초과하면 컴파일 오류가 발생한다.
//     //System.out.println(2147483648);
//     //System.out.println(-2147483649);

//     //## 8바이트 정수
//     //4바이트 메모리를 벗어나는 정수 값을 표현할 때 사용한다.
//     //숫자 뒤에 L 또는 l을 붙인다.
//     //보통 대문자를 붙인다. 왜? 소문자 l은 숫자 1과 헷갈리기 때문이다.
//     System.out.println(2147483648L);
//     System.out.println(-2147483649L);

//     //## 4바이트 또는 8바이트 정수의 최대값과 최소값
//     //자바에서는 각 데이터 유형에 따라 최대/최소 값을 알아볼 수 있도록 특별한 명령을 제공한다.
//     System.out.println(Integer.MAX_VALUE); // 4바이트로 표현할 수 있는 정수 최대값
//     System.out.println(Integer.MIN_VALUE); // 4바이트로 표현할 수 있는 정수 최소값
//     System.out.println(Long.MAX_VALUE); // 8바이트로 표현할 수 있는 정수 최대값
//     System.out.println(Long.MIN_VALUE); // 8바이트로 표현할 수 있는 정수 최소값

//     //## 주의!
//     //- 다음은 크기가 다른 정수이다.
//     System.out.println(100); // 4바이트 크기의 정수 값
//     System.out.println(100L); // 8바이트 크기의 정수 값

// // 결과 
// // java study01
// // 2147483647
// // -2147483648
// // 2147483648
// // -2147483649
// // 2147483647
// // -2147483648
// // 9223372036854775807
// // -9223372036854775808
// // 100
// // 100



// //ex03)Exam0310
// public class study01{
//   public static void main(String[] args) {

 
//     //## 10진수 표기법
//     System.out.println(3.14);
    
//     //## Exponential 기호 사용하기
//     //- e 기호를 사용하면 소수점의 위치를 조정할 수 있다.
//     //- 소수점의 위치를 움직인다고 해서 "부동소수점(floating point)"이라 부른다. 
//     //- 표기법
//     //    숫자e지수 또는 숫자E지수 
//     System.out.println(0.0314e2); // 0.0314 * 10의2승 = 3.14
//     System.out.println(0.314e1); // 0.314 * 10의1승 = 3.14
//     System.out.println(31.4e-1); // 31.4 * 10의-1승 = 3.14
//     System.out.println(314e-2); // 314 * 10의-2승 = 3.14
//     }
//   }


  
//# 부동소수점 리터럴
//- 컴퓨터는 1과 0으로 데이터를 저장한다.
//- 실수 값을 부동소수점 방식으로 저장하려면 1과 0으로 변환해야 한다.
//- 자바는 부동소수점을 저장할 때 전기전자기술자협회(IEEE)에서 개발한 IEEE 754 명세에 따라 2진수로 변환한다.

//결과

// 3.14
// 3.14
// 3.14
// 3.14
// 3.14


//ex03)0320
public class study01{
  public static void main(String[] args) {
  //   //## 8바이트 크기의 부동소수점
  //   //- 숫자 맨 뒤에 d 또는 D를 붙인다.
  //   //- 생략해도 된다.
  //   System.out.println(3.14);
  //   System.out.println(3.14d);
  //   System.out.println(3.14D);

  //   //## 4바이트 크기의 부동소수점
  //   //- 숫자 맨 뒤에 f 또는 F를 붙인다.
  //   System.out.println(3.14f); // 주로 소문자 f를 많이 붙인다.
  //   System.out.println(3.14F);

// 결과
// 3.14
// 3.14
// 3.14
// 3.14
// 3.14


// Exam0330
    // //## 4바이트 부동소수점의 최대값과 최소값
    // System.out.println(Float.MAX_VALUE);
    // System.out.println(Float.MIN_VALUE);
    
    // //## 8바이트 부동소수점의 최대값과 최소값
    // System.out.println(Double.MAX_VALUE);
    // System.out.println(Double.MIN_VALUE);

// 결과
// 3.4028235E38
// 1.4E-45
// 1.7976931348623157E308
// 4.9E-324

// Exam0340
    //## 4byte(float) 부동소수점의 유효자릿수
    //소수점을 뺀 후 7자리 숫자까지는 거의 정상적으로 저장된다.
    System.out.println(999.9999f);
    System.out.println(999999.9f);
    System.out.println(9.999999f);
    System.out.println("----------------------------");

    //유효자릿수가 7자리를 넘어가는 경우 값이 잘려서 저장될 수 있다.
    System.out.println(987654321.1234567f);
    System.out.println(9.876543211234567f);
    System.out.println(987654321123456.7f);
    System.out.println("----------------------------");

    //## 8byte(double) 부동소수점의 유효자릿수
    //소수점을 뺀 후 16자리 숫자까지는 거의 정상적으로 저장된다.
    System.out.println(987654321.1234567);
    System.out.println(9.876543211234567);
    System.out.println(987654321123456.7);
    System.out.println("----------------------------");

    //유효자릿수가 16자리를 넘어가는 경우 값이 잘려서 저장될 수 있다.
    System.out.println(987654321.12345678);
    System.out.println(9.8765432112345678);
    System.out.println(987654321123456.78);
    System.out.println("----------------------------");

    //## 부동소수점을 저장할 때 정확하게 저장되지 않는 예
    System.out.println(7 * 0.1); //결과: 0.7000000000000001
    //- 이유
    //  - IEEE-754 규격에 따라 부동소수점을 2진수로 바꾸다보면
    //    정확하게 2진수로 딱 떨어지지 않는 경우가 있다.
    //    CPU, OS, 컴파일러, JVM의 문제가 아니다.
    //  - IEEE-754의 방법에 내재되어 있는 문제다.
    //- 해결책
    //  - 시스템에서 필요한 만큼 소수점 이하 자리수를 적절히 짤라 사용하라!

// 결과 
// 999.9999
// 999999.9
// 9.999999
// ----------------------------
// 9.8765434E8
// 9.876543
// 9.876543E14
// ----------------------------
// 9.876543211234567E8
// 9.876543211234567
// 9.876543211234568E14
// ----------------------------
// 9.876543211234568E8
// 9.876543211234567
// 9.876543211234568E14
// ----------------------------
// 0.7000000000000001


 }

}


 