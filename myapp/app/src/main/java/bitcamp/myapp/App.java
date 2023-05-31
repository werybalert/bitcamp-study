
package bitcamp.myapp;

public class App {
  public static void main(String[] args) {
    System.out.println("나의 목록 관리 시스템");
    System.out.println("-------------------");

    System.out.print("번호: ");   //그냥 print는 줄바꿈 기능 x
    System.out.println(100);
    // = System.out.println("번호" + 100); 이렇게 표시해도 사용 가능
    
    System.out.printf("이름 : %s", "홍길동");   //%s : 문자열 표시법
              //printf, println, print = function
    System.out.println();  // '\n' 대신 줄바꿈 명령을 이렇게 사용 가능

    System.out.println("나이" + 20);  

    System.out.printf("재직자: %b\n", true);   //%b : true, false 값 출력, \n : escape character

    System.out.printf("성별(남자(M), 여자(W)): %c\n",'M');

    System.out.printf("좌우 시력: %.1f,%.1f\n",1.5f, 1.0f);

  }
}
 

// 결과
// PS C:\Users\bitcamp\git\bitcamp-study\myapp> gradle -q run
// 나의 목록 관리 시스템
// -------------------
// 번호: 100
// 이름 : 홍길동
// 나이20
// 재직자: true
// 성별(남자(M), 여자(W)): M
// 좌우 시력: 1.5,1.0


// "성별(... ,'M' > "M"); 변경
// PS C:\Users\bitcamp\git\bitcamp-study\myapp> gradle -q run                                                           
// 나의 목록 관리 시스템
// -------------------
// 번호: 100
// 이름 : 홍길동
// 나이20
// 재직자: true
// 성별(남자(M), 여자(W)): Exception in thread "main" java.util.IllegalFormatConversionException ★: c != java.lang.String 
//         at java.base/java.util.Formatter$FormatSpecifier.failConversion(Formatter.java:4442)
//     ...