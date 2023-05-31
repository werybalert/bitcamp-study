// 0530 제작
import java.util.Scanner;


public class App {
  public static void main(String[] args) {
    /* 
 
    // 값 출력하기
    // println() = 출력 + 줄바꿈
    System.out.println(20);
    System.out.println(3.14f);
    System.out.println("Hello");
    System.out.println('Y');
    System.out.println(true);

// 출력
// 20
// 3.14
// Hello
// Y
// true

    // 값을 주지 않으면 줄바꿈만 수행한다.
    System.out.println();

    // print() 는 출력만 한다. 줄바꿈 없다.
    System.out.print(20);
    System.out.print(3.14f);
    System.out.print("Hello");
    System.out.print('Y');
    System.out.print(true);

// 203.14HelloYtrue


    // 이스케이프 문자를 통해 줄바꿈을 수행한다.
    System.out.print('\n');

    System.out.print("OK!\n"); // ==> println("Ok!")
    System.out.print("Hi!\n"); // ==> println("Hi!");
  
// OK!
// Hi!


// -----------------------------------------------------


    //형식을 지정하지 않으면 print()와 같다. 
    System.out.printf("Hello!\n");

    // %s : 지정한 자리에 문자열을 삽입한다.
    //      삽입할 값은 오른쪽에 설정한다.
    System.out.printf("이름: %s\n", "홍길동");
    System.out.printf("안녕하세요! %s입니다.\n", "임꺽정");

    // %d : 정수 값을 10진수 문자열로 만들어 삽입한다.
    // %x : 정수 값을 16진수 문자열로 만들어 삽입한다.
    // %c : 정수 값을 문자로 만들어 삽입한다.
    // %b : true/false 값을 문자열로 만들어 삽입한다.
    System.out.printf("%d %x %c %b\n", 65, 65, 65, false);

    // 한 개의 값을 여러 곳에 삽입할 수 있다.
    // %[n$]s : n은 문자열에 삽입될 값의 순서이다. 순서는 1부터 증가한다.
    System.out.printf("%d %1$x %1$c\n", 65);
    System.out.printf("%3$d %1$x %2$c\n", 65, 66, 67); // 3$(67), 1$(65), 2$(66)

    // 값을 삽입할 때 사용할 공간을 지정할 수 있다.
    // 문자열을 삽입할 때: 
    //   %[-][사용할공간너비]s : -는 왼쪽 정렬이다. 안 붙이면 기본 오른쪽 정렬이다.
    System.out.printf("'%-10s' '%10s'\n", "홍길동", "임꺽정");
    System.out.printf("'%-10d' '%10d'\n", 12345, 12345);

    // 정수를 삽입할 때:
    //   %[0][사용할공간너비]d : 앞의 빈자리는 0으로 채운다.
    //   %[+][0][사용할공간너비]d : +는 숫자 앞에 부호를 붙인다.
    System.out.printf("'%010d' '%07d'\n", 12345, 12345);
    System.out.printf("'%+010d' '%+07d'\n", 12345, -12345);
 
// Hello!
// 이름: 홍길동
// 안녕하세요! 임꺽정입니다.
// 65 41 A false
// 65 41 A
// 67 41 B
// '홍길동       ' '       임꺽정'
// '12345     ' '     12345'
// '0000012345' '0012345'
// '+000012345' '-012345'

// -----------------------------------------------------


 // 현재 날짜 및 시각 정보를 생성한다.
    // java.lang 패키지의 멤버를 사용할 때는 그냥 이름을 지정하면 된다.
    // 그 외 다른 패키지의 멤버를 사용할 때는 반드시 패키지 이름을 함께 지정해야 한다.
    java.util.Date today = new java.util.Date();

    // %t[날짜 및 시각 옵션]
    // 날짜 및 시간 옵션
    // Y : 날짜 및 시각 데이터에서 년도를 추출하여 4자리로 표현한다.
    // y : 날짜 및 시각 데이터에서 년도를 추출하여 뒤의 2자리로 표현한다.
    System.out.printf("%1$tY, %1$ty\n", today);

    // B : 날짜 및 시각 데이터에서 월을 추출하여 전체 이름으로 표현한다. ex) January
    // b : 날짜 및 시각 데이터에서 월을 추출하여 단축 이름으로 표현한다. ex) Jan
    System.out.printf("%1$tB, %1$tb\n", today);

    // m : 날짜 및 시각 데이터에서 월을 추출하여 2자리 숫자로 표현한다. ex) 12, 01
    System.out.printf("%1$tm\n", today);

    // d : 날짜 및 시각 데이터에서 일을 추출하여 2자리 숫자로 표현한다. ex) 01, 22
    // e : 날짜 및 시각 데이터에서 일을 추출하여 1자리 숫자로 표현한다. ex) 1, 22
    System.out.printf("%1$td %1$te\n", today);

    // A : 날짜 및 시각 데이터에서 요일을 추출하여 긴 이름으로 표현한다. ex) Sunday
    // a : 날짜 및 시각 데이터에서 요일을 추출하여 짧은 이름으로 표현한다. ex) Sun
    System.out.printf("%1$tA %1$ta\n", today);

    // H : 날짜 및 시각 데이터에서 시각을 추출하여 24시로 표현한다.
    // I : 날짜 및 시각 데이터에서 시각을 추출하여 12시로 표현한다.
    System.out.printf("%1$tH %1$tI\n", today);

    // M : 날짜 및 시각 데이터에서 시각을 추출하여 분을 표현한다.
    System.out.printf("%1$tM\n", today);

    // S : 날짜 및 시각 데이터에서 시각을 추출하여 초를 표현한다.
    // L : 날짜 및 시각 데이터에서 시각을 추출하여 밀리초를 표현한다.
    // N : 날짜 및 시각 데이터에서 시각을 추출하여 나노초를 표현한다.
    System.out.printf("%1$tS %1$tL %1$tN\n", today);

    // p : 오전 오후 출력하기
    //     소문자 p를 사용하면 am 또는 pm으로 출력하고, 
    //     대문자 P를 사용하면 AM 또는 PM으로 출력한다.
    //     한글은 대소문자가 없기 때문에 의미없다.
    System.out.printf("%1$tp\n", today);

    // 년-월-일 시:분:초를 출력하라! 예) 2019-01-04 12:04:30
    System.out.printf("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS\n", today);


// 2023, 23
// 5월, 5월
// 05
// 30 30
// 화요일 화
// 11 11
// 29
// 41 708 708000000
// 오전
// 2023-05-30 11:29:41
    

// -----------------------------------------------------

System.out.println('\n');
java.io.InputStream keyboard = System.in;
java.util.Scanner keyboardScanner = new java.util.Scanner(keyboard);
System.out.print("팀명? "); 
String str = keyboardScanner.nextLine();
System.out.println(str);
keyboardScanner.close(); // 공유하는 자원은 연결을 끊고 닫아야 한다.

// 팀명?    지아이조(입력)
// 지아이조



java.io.InputStream keyboard = System.in;
// System.in
// - 표준 입력 장치. 키보드를 가리킨다.
java.util.Scanner keyboardScanner = new java.util.Scanner(keyboard);


// 팀 멤버의 정보를 입력 받아 출력하라.
System.out.print("이름? ");
System.out.println(keyboardScanner.nextLine());
System.out.print("전화? ");
System.out.println(keyboardScanner.nextLine());
System.out.print("이메일? ");
System.out.println(keyboardScanner.nextLine());
System.out.print("나이? ");
System.out.println(keyboardScanner.nextLine());
System.out.print("재직여부? ");
System.out.println(keyboardScanner.nextLine());

// System.out
// - 표준 출력 장치. 콘솔(모니터, 명령창)을 가리킨다.

keyboardScanner.close();

//                      <입력값>
// 이름?                  홍길동
// 출력 : 홍길동
// 전화?               01012345678
// 출력 : 01012345678
// 이메일?              adad@gmail.com
// 출력 : adad@gmail.com
// 나이?                    25
// 출력 : 25
// 재직여부?                 n
// 출력 : n
 */

// java.util.Scanner keyboardScanner = new java.util.Scanner(System.in);


/* 

System.out.print("나이? ");
int age = keyboardScanner.nextInt();
// nextInt()는 한 개의 토큰을 읽은 후에 줄 바꿈 코드는 읽기 전 상태로 내비둔다.
// 따라서 다음에 nextLine()을 호출하면 의도치 않게 빈 문자열을 가진 한 줄을 
// 읽는 상황이 된다. 

// nextInt() 다음에 nextLine()을 호출할 때 이런 상황이 발생한다.
// 해결 방법? nextInt()를 호출한 후 남아있는 엔터 코드를 읽어서 제거하라.
// 나이? 123
// 이름? 123()

keyboardScanner.nextLine(); // 남아 있는 빈 문자열의 한 줄(LF 코드)을 읽어서 버린다.

System.out.print("이름? ");
String name = keyboardScanner.nextLine();

keyboardScanner.close();

System.out.printf("%d(%s)\n", age, name);

// 나이? 123
// 이름? 홍길동
// 123(홍길동)

// ---------------------------------------------------------------------------------------
 // next()
    // - 토큰 단위로 입력 데이터를 잘라서 읽을 때 유용하다. 
    System.out.print("입력: ");
    String token1 = keyboardScanner.next();
    String token2 = keyboardScanner.next();
    String token3 = keyboardScanner.next();

    keyboardScanner.close();

    System.out.printf("%s, %s, %s\n", token1, token2, token3);

    // 입력: 홍길동 25세 제직x  
    // 홍길동, 25세, 제직x




// ---------------------------------------------------------------------------------------
System.out.print("나이, 이름, 취업여부? ");
int age = keyboardScanner.nextInt(); // nextInt() : 나이를 읽음

// 한 개의 토큰을 읽을 때 유용하다.
String name = keyboardScanner.next(); //next() : 이름을 읽음

boolean working = keyboardScanner.nextBoolean(); //nextBoolean() : 취업 여부를 읽음

keyboardScanner.close();

System.out.printf("%d, %s, %b\n", age, name, working);

// 1. 
// 나이, 이름, 취업여부? 25 홍길동 false
// 25, 홍길동, false

// 2. 
// 나이, 이름, 취업여부? 25 홍길동 true 
// 25, 홍길동, true




// ---------------------------------------------------------------------------------------
// 0530 수업 코드
// import java.util.Scanner; 맨위 pulic 위에 입력

System.out.println("나의 목록 관리 시스템");
System.out.println("----------------------------------");

// 키보드 스캐너 준비
Scanner scanner = new Scanner(System.in);

// 1.
System.out.print("번호? ");
int no1 = scanner.nextInt();

System.out.print("이름? ");
String name1 = scanner.next();

System.out.print("나이? ");
int age1 = scanner.nextInt();

System.out.print("재직중(true/false)? ");
boolean working1 = scanner.nextBoolean();

System.out.print("성별(남자:M, 여자:W)? ");
String str = scanner.next();
char gender1 = str.charAt(0);

System.out.print("시력(왼쪽, 오른쪽)? ");
float leftEye1 = scanner.nextFloat();
float rightEye1 = scanner.nextFloat();


// 2.
System.out.print("번호? ");
int no2 = scanner.nextInt();

System.out.print("이름? ");
String name2 = scanner.next();

System.out.print("나이? ");
int age2 = scanner.nextInt();

System.out.print("재직중(true/false)? ");
boolean working2 = scanner.nextBoolean();

System.out.print("성별(남자:M, 여자:W)? ");
str = scanner.next(); //기존변수 재사용
char gender2 = str.charAt(0);

System.out.print("시력(왼쪽, 오른쪽)? ");
float leftEye2 = scanner.nextFloat();
float rightEye2 = scanner.nextFloat();


// 3.
System.out.print("번호? ");
int no3 = scanner.nextInt();

System.out.print("이름? ");
String name3 = scanner.next();

System.out.print("나이? ");
int age3 = scanner.nextInt();

System.out.print("재직중(true/false)? ");
boolean working3 = scanner.nextBoolean();

System.out.print("성별(남자:M, 여자:W)? ");
str = scanner.next();
char gender3 = str.charAt(0);

System.out.print("시력(왼쪽, 오른쪽)? ");
float leftEye3 = scanner.nextFloat();
float rightEye3 = scanner.nextFloat();


System.out.println("---------------------------------------");

System.out.printf("번호: %d\n", no1);
System.out.printf("이름: %s\n", name1);
System.out.printf("나이: %d\n", age1);
System.out.printf("재직자: %b\n", working1);
System.out.printf("성별(남자(M), 여자(W)): %c\n", gender1);
System.out.printf("좌우시력: %.1f,%.1f\n", leftEye1, rightEye1);


System.out.printf("번호: %d\n", no2);
System.out.printf("이름: %s\n", name2);
System.out.printf("나이: %d\n", age2);
System.out.printf("재직자: %b\n", working2);
System.out.printf("성별(남자(M), 여자(W)): %c\n", gender2);
System.out.printf("좌우시력: %.1f,%.1f\n", leftEye2, rightEye2);


System.out.printf("번호: %d\n", no3);
System.out.printf("이름: %s\n", name3);
System.out.printf("나이: %d\n", age3);
System.out.printf("재직자: %b\n", working3);
System.out.printf("성별(남자(M), 여자(W)): %c\n", gender3);
System.out.printf("좌우시력: %.1f,%.1f\n", leftEye3, rightEye3);


scanner.close();

// 출력
// 번호: 1
// 이름: 홍길동
// 나이: 23
// 재직자: true
// 성별(남자(M), 여자(W)): M
// 좌우시력: 1.5,1.0

// 번호: 2
// 이름: 김길동
// 나이: 25
// 재직자: true
// 성별(남자(M), 여자(W)): W
// 좌우시력: 2.0,1.5

// 번호: 3
// 이름: 노길동
// 나이: 30
// 재직자: false
// 성별(남자(M), 여자(W)): W
// 좌우시력: 0.1,0.5

*/
// ---------------------------------------------------------------------------------------

// 설치
// google-java-format

System.out.println("나의 목록 관리 시스템");
System.out.println("----------------------------------");

// 키보드 스캐너 준비
Scanner scanner = new Scanner(System.in);

int[] no = new int[3];
String[] name = new String[3];
int[] age = new int[3];
boolean[] working = new boolean[3];
char[] gender = new char[3];
float[] leftEye = new float[3];
float[] rightEye = new float[3];


for (int count = 0; count < 3;  count++) {
  //  셋다 같은 의미
  // count = count + 1;
  // count += 1;
  // count++;


  System.out.print("번호? ");
  no[count] = scanner.nextInt();

  System.out.print("이름? ");
  name[count] = scanner.next();

  System.out.print("나이? ");
  age[count] = scanner.nextInt();

  System.out.print("재직중(true/false)? ");
  working[count] = scanner.nextBoolean();

  System.out.print("성별(남자:M, 여자:W)? ");
  String str = scanner.next();
  gender[count] = str.charAt(0);

  System.out.print("시력(왼쪽, 오른쪽)? ");
  leftEye[count] = scanner.nextFloat();
  rightEye[count] = scanner.nextFloat();

         
}

// 반복문 
// 번호: 1
// 이름: 홍길동
// 나이: 23
// 재직자: true
// 성별(남자(M), 여자(W)): W
// 좌우시력: 1.0,2.0
// 번호: 2
// 이름: 노길동
// 나이: 35
// 재직자: false
// 성별(남자(M), 여자(W)): W
// 좌우시력: 1.5,2.5
// 번호: 3
// 이름: 감길동
// 나이: 35
// 재직자: false
// 성별(남자(M), 여자(W)): M
// 좌우시력: 1.5,3.5

/* 

//10명 입력값 넣기
// 1.
System.out.print("번호? ");
int no1 = scanner.nextInt();

System.out.print("이름? ");
String name1 = scanner.next();

System.out.print("나이? ");
int age1 = scanner.nextInt();

System.out.print("재직중(true/false)? ");
boolean working1 = scanner.nextBoolean();

System.out.print("성별(남자:M, 여자:W)? ");
String str = scanner.next();
char gender1 = str.charAt(0);

System.out.print("시력(왼쪽, 오른쪽)? ");
float leftEye1 = scanner.nextFloat();
float rightEye1 = scanner.nextFloat();


// 2.
System.out.print("번호? ");
int no2 = scanner.nextInt();

System.out.print("이름? ");
String name2 = scanner.next();

System.out.print("나이? ");
int age2 = scanner.nextInt();

System.out.print("재직중(true/false)? ");
boolean working2 = scanner.nextBoolean();

System.out.print("성별(남자:M, 여자:W)? ");
str = scanner.next(); //기존변수 재사용
char gender2 = str.charAt(0);

System.out.print("시력(왼쪽, 오른쪽)? ");
float leftEye2 = scanner.nextFloat();
float rightEye2 = scanner.nextFloat();


// 3.
System.out.print("번호? ");
int no3 = scanner.nextInt();

System.out.print("이름? ");
String name3 = scanner.next();

System.out.print("나이? ");
int age3 = scanner.nextInt();

System.out.print("재직중(true/false)? ");
boolean working3 = scanner.nextBoolean();

System.out.print("성별(남자:M, 여자:W)? ");
str = scanner.next();
char gender3 = str.charAt(0);

System.out.print("시력(왼쪽, 오른쪽)? ");
float leftEye3 = scanner.nextFloat();
float rightEye3 = scanner.nextFloat();


// 4.
System.out.print("번호? ");
int no4 = scanner.nextInt();

System.out.print("이름? ");
String name4 = scanner.next();

System.out.print("나이? ");
int age4 = scanner.nextInt();

System.out.print("재직중(true/false)? ");
boolean working4 = scanner.nextBoolean();

System.out.print("성별(남자:M, 여자:W)? ");
str = scanner.next();
char gender4 = str.charAt(0);

System.out.print("시력(왼쪽, 오른쪽)? ");
float leftEye4 = scanner.nextFloat();
float rightEye4 = scanner.nextFloat();


// 5.
System.out.print("번호? ");
int no5 = scanner.nextInt();

System.out.print("이름? ");
String name5 = scanner.next();

System.out.print("나이? ");
int age5 = scanner.nextInt();

System.out.print("재직중(true/false)? ");
boolean working5 = scanner.nextBoolean();

System.out.print("성별(남자:M, 여자:W)? ");
str = scanner.next(); //기존변수 재사용
char gender5 = str.charAt(0);

System.out.print("시력(왼쪽, 오른쪽)? ");
float leftEye5 = scanner.nextFloat();
float rightEye5 = scanner.nextFloat();


// 6.
System.out.print("번호? ");
int no6 = scanner.nextInt();

System.out.print("이름? ");
String name6 = scanner.next();

System.out.print("나이? ");
int age6 = scanner.nextInt();

System.out.print("재직중(true/false)? ");
boolean working6 = scanner.nextBoolean();

System.out.print("성별(남자:M, 여자:W)? ");
str = scanner.next();
char gender6 = str.charAt(0);

System.out.print("시력(왼쪽, 오른쪽)? ");
float leftEye6 = scanner.nextFloat();
float rightEye6 = scanner.nextFloat();


// 7.
System.out.print("번호? ");
int no7 = scanner.nextInt();

System.out.print("이름? ");
String name7 = scanner.next();

System.out.print("나이? ");
int age7 = scanner.nextInt();

System.out.print("재직중(true/false)? ");
boolean working7 = scanner.nextBoolean();

System.out.print("성별(남자:M, 여자:W)? ");
str = scanner.next();
char gender7 = str.charAt(0);

System.out.print("시력(왼쪽, 오른쪽)? ");
float leftEye7 = scanner.nextFloat();
float rightEye7 = scanner.nextFloat();


// 8.
System.out.print("번호? ");
int no8 = scanner.nextInt();

System.out.print("이름? ");
String name8 = scanner.next();

System.out.print("나이? ");
int age8 = scanner.nextInt();

System.out.print("재직중(true/false)? ");
boolean working8 = scanner.nextBoolean();

System.out.print("성별(남자:M, 여자:W)? ");
str = scanner.next(); //기존변수 재사용
char gender8 = str.charAt(0);

System.out.print("시력(왼쪽, 오른쪽)? ");
float leftEye8 = scanner.nextFloat();
float rightEye8 = scanner.nextFloat();


// 9.
System.out.print("번호? ");
int no9 = scanner.nextInt();

System.out.print("이름? ");
String name9 = scanner.next();

System.out.print("나이? ");
int age9 = scanner.nextInt();

System.out.print("재직중(true/false)? ");
boolean working9 = scanner.nextBoolean();

System.out.print("성별(남자:M, 여자:W)? ");
str = scanner.next();
char gender9 = str.charAt(0);

System.out.print("시력(왼쪽, 오른쪽)? ");
float leftEye9 = scanner.nextFloat();
float rightEye9 = scanner.nextFloat();


// 10.
System.out.print("번호? ");
int no10 = scanner.nextInt();

System.out.print("이름? ");
String name10 = scanner.next();

System.out.print("나이? ");
int age10 = scanner.nextInt();

System.out.print("재직중(true/false)? ");
boolean working10 = scanner.nextBoolean();

System.out.print("성별(남자:M, 여자:W)? ");
str = scanner.next();
char gender10 = str.charAt(0);

System.out.print("시력(왼쪽, 오른쪽)? ");
float leftEye10 = scanner.nextFloat();
float rightEye10 = scanner.nextFloat();
*/

System.out.println("---------------------------------------");


 for (int count = 0; count < 3; count++) {
System.out.printf("번호: %d\n", no[count]);
System.out.printf("이름: %s\n", name[count]);
System.out.printf("나이: %d\n", age[count]);
System.out.printf("재직자: %b\n", working[count]);
System.out.printf("성별(남자(M), 여자(W)): %c\n", gender[count]);
System.out.printf("좌우시력: %.1f,%.1f\n", leftEye[count], rightEye[count]);
}

scanner.close();

/* 
System.out.printf("번호: %d\n", no2);
System.out.printf("이름: %s\n", name2);
System.out.printf("나이: %d\n", age2);
System.out.printf("재직자: %b\n", working2);
System.out.printf("성별(남자(M), 여자(W)): %c\n", gender2);
System.out.printf("좌우시력: %.1f,%.1f\n", leftEye2, rightEye2);


System.out.printf("번호: %d\n", no3);
System.out.printf("이름: %s\n", name3);
System.out.printf("나이: %d\n", age3);
System.out.printf("재직자: %b\n", working3);
System.out.printf("성별(남자(M), 여자(W)): %c\n", gender3);
System.out.printf("좌우시력: %.1f,%.1f\n", leftEye3, rightEye3);


System.out.printf("번호: %d\n", no4);
System.out.printf("이름: %s\n", name4);
System.out.printf("나이: %d\n", age4);
System.out.printf("재직자: %b\n", working4);
System.out.printf("성별(남자(M), 여자(W)): %c\n", gender4);
System.out.printf("좌우시력: %.1f,%.1f\n", leftEye4, rightEye4);


System.out.printf("번호: %d\n", no5);
System.out.printf("이름: %s\n", name5);
System.out.printf("나이: %d\n", age5);
System.out.printf("재직자: %b\n", working5);
System.out.printf("성별(남자(M), 여자(W)): %c\n", gender5);
System.out.printf("좌우시력: %.1f,%.1f\n", leftEye5, rightEye5);


System.out.printf("번호: %d\n", no6);
System.out.printf("이름: %s\n", name6);
System.out.printf("나이: %d\n", age6);
System.out.printf("재직자: %b\n", working6);
System.out.printf("성별(남자(M), 여자(W)): %c\n", gender6);
System.out.printf("좌우시력: %.1f,%.1f\n", leftEye6, rightEye6);


System.out.printf("번호: %d\n", no7);
System.out.printf("이름: %s\n", name7);
System.out.printf("나이: %d\n", age7);
System.out.printf("재직자: %b\n", working7);
System.out.printf("성별(남자(M), 여자(W)): %c\n", gender7);
System.out.printf("좌우시력: %.1f,%.1f\n", leftEye7, rightEye7);


System.out.printf("번호: %d\n", no8);
System.out.printf("이름: %s\n", name8);
System.out.printf("나이: %d\n", age8);
System.out.printf("재직자: %b\n", working8);
System.out.printf("성별(남자(M), 여자(W)): %c\n", gender8);
System.out.printf("좌우시력: %.1f,%.1f\n", leftEye8, rightEye8);



System.out.printf("번호: %d\n", no9);
System.out.printf("이름: %s\n", name9);
System.out.printf("나이: %d\n", age9);
System.out.printf("재직자: %b\n", working9);
System.out.printf("성별(남자(M), 여자(W)): %c\n", gender9);
System.out.printf("좌우시력: %.1f,%.1f\n", leftEye8, rightEye9);



System.out.printf("번호: %d\n", no10);
System.out.printf("이름: %s\n", name10);
System.out.printf("나이: %d\n", age10);
System.out.printf("재직자: %b\n", working10);
System.out.printf("성별(남자(M), 여자(W)): %c\n", gender10);
System.out.printf("좌우시력: %.1f,%.1f\n", leftEye10, rightEye10);
*/


      // 출력
      // 번호: 123
      // 이름: 홍길동
      // 나이: 23
      // 재직자: true
      // 성별(남자(M), 여자(W)): w
      // 좌우시력: 1.5,1.0
  
  
      // - 키보드로 값을 입력 받는 방법
  
    }
  }






// 컴파일
// PS C:\Users\bitcamp\git\bitcamp-study\myapp\app03> javac -d ./bin/main -encoding UTF-8 .\src\main\java\bitcamp\myapp\App.java
// 실행
// PS C:\Users\bitcamp\git\bitcamp-study\myapp\app03\bin\main> java App


