/*

public class App {
    public static void main(String[] args) {

//        1.
        int i = 2;
        int result = i++ + i++ * i++;
        System.out.printf("%d, %d\n", i, result);

//        5, 14


        int result2 = i++ * i++ + i++;
        System.out.printf("%d, %d\n", i, result2);
//         8, 37

        // 연산자 우선수위:
        // 1) ++, --
        // 2) *, /, %
        // 3) +, -
        // 4) =
        //
        // int result = 2 + i++ * i++;  => i = 3
        // int result = 2 + 3 * i++; => i = 4
        // int result = 2 + 3 * 4; => i = 5
        // int result = 2 + 12;
        // int result = 14;
//        System.out.printf("%d, %d\n", i, result);
//        System.out.printf("%d, %d\n", i, result2);

//        5, 14

//        2.
        // 주의!
        // 1) pre-fix 연산자나 post-fix 연산자를 리터럴에 적용할 수 없다.
        //    int x = ++100; // 컴파일 오류!
        //    x = 100++; // 컴파일 오류!

        // 2) 변수에 동시에 적용할 수 없다.
//          - 실행된 값에 대해 전위/후위 연산자를 적용할 수 없기 때문이다.
        int y = 100;
        //    ++y++; // 컴파일 오류!
        //    (++y)++; // 컴파일 오류!
        //    ++(y++); // 컴파일 오류!

 */
/*
//0601 실습 (myapp의 test파일 수정본)
//1.
int[] no = new int[5];
no[0] = 100;
no[4] = 500;
//no[-1] = 100;
//        Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index -1 out of bounds for length 5
//        at App.main(App.java:53)

//no[5] = 500;
//        Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 5
//        at App.main(App.java:57)


//2.
        int[] no = new int[]{100,200,300};
        System.out.println(no.length);
//        3


//3.
        int[] no;
        no = new int[]{100,200,300};
        System.out.println(no.length);



    }
}
*/

//My app - 상수 사용법

// 코드 본문에서 사용할 클래스가 어떤 패키지의 클래스인지 지정한다.
import java.util.Scanner;

        public class App {
            public static void main(String[] args) {

                // 키보드 스캐너 준비
                Scanner scanner = new Scanner(System.in);

                final int MAX_SIZE = 100;
                int userID = 1;
                int length = 0;

                int[] no = new int[MAX_SIZE];
                String[] name = new String[MAX_SIZE];
                String[] email = new String[MAX_SIZE];
                String[] password = new String[MAX_SIZE];
                char[] gender = new char[MAX_SIZE];

                printTitle();

//              회원 정보 등록
                for (int i = 0; i < MAX_SIZE; i++) {
                    inputMember(scanner, i, name, email, password, gender, no, userID++ );
                    length++;
                    if (!promptContinue(scanner)) {
                        break;
                    }
                }
                printMembers((length,no, name, email, gender));
                scanner.close();

                static void printTitle() {
                    System.out.println("나의 목록 관리 시스템");
                    System.out.println("----------------------------------");
                }
            }


            static void inputMember(Scanner scanner,int i, String[] name,
                                    String[] email, String[] password, char[] gender,int[] no, int userID) {

                System.out.print("이름? : ");
                name[i] = scanner.next();

                System.out.print("email? : ");
                email[i] = scanner.next();

                System.out.print("PW : ");
                password[i] = scanner.next();

//                    성별
//                    1. 남자 / 2. 여자 / 3. ~~ 무효한 번호 입니다. => 다시 1.2.선택지로 이동
                // next : enter가 입력되기 전까지 대기
                loop: while (true) {
                    System.out.println("성별  : ");
                    System.out.println("1. 남자 ");
                    System.out.println("2. 여자 ");
                    System.out.print(" > ");
                    String menuNum = scanner.next();
                    scanner.nextLine(); // 입력 값(Token)을 읽고 난 후에 남아 있는 줄바꿈 코드를 제거한다.
                        /*

//1. 조건문
                        if (menuNum.equals("1")) {
                            gender[i] = 'M';
                            break;
                        } else if (menuNum.equals("2")) {
                            gender[i] = 'W';
                            break;
                        } else {
                            System.out.println("무효한 번호입니다.");
                        }
                        */
//2. switch 구문
                    switch (menuNum) {
                        case "1":
                            gender[i] = 'M';
                            break loop;
                        case "2":
                            gender[i] = 'w';
                            break loop;           //  === 반복문 탈출
                        default:
                            System.out.println("무료한 번호입니다.");
                    }
                }

//                    gender[i] = scanner.next().charAt(0);


                no[i] = userID++;

            }

            static boolean promptContinue(Scanner scanner ) {

                System.out.print("계속 하시겠습니까?(Y/N)");
                String response = scanner.nextLine();       //nextLine 은 문자 입력을 자동으로 받는다.
                if (!response.equals("")  && !response.equalsIgnoreCase("Y")) {
                    return false;
                }
                return true;
                }

                static void printMembers(int length, int[] no, String[] name, String[] email, char[] gender)
                {

                    System.out.println("---------------------------------------");

                    System.out.println("번호, 이름, 이메일, 성별");
                    System.out.println("---------------------------------------");

                    for (int i = 0; i < length; i++) {
                        System.out.printf("%d, %s, %s, %c\n", no[i], name[i], email[i], gender[i]);

                    }

                }

            }

//        나의 목록 관리 시스템
//----------------------------------
//이름? : asdf
//email? : asdf
//PW : asdf
//성별: :
//1. 남자
//2. 여자
// > 1
//계속 하시겠습니까?(Y/N)N
//---------------------------------------
//번호, 이름, 이메일, 성별
//---------------------------------------
//1, asdf, asdf, M
//PS C:\Users\bitcamp\git\bitcamp-study\myapp> java -cp /bin/main App
//나의 목록 관리 시스템
//----------------------------------
//이름? : 홍길동
//email? : asdf.com
//PW : 1234
//성별: :
//1. 남자
//2. 여자
// > 2
//계속 하시겠습니까?(Y/N)Y
//이름? : 고길동
//email? : qwer.com
//PW : 2345
//성별: :
//1. 남자
//2. 여자
// > 2
//계속 하시겠습니까?(Y/N)Y
//이름? : 김길동
//email? : zxcv.com
//PW : 5678
//성별: :
//1. 남자
//2. 여자
// > 1
//계속 하시겠습니까?(Y/N)^N
//---------------------------------------
//번호, 이름, 이메일, 성별
//---------------------------------------
//1, 홍길동, asdf.com, W
//2, 고길동, qwer.com, W
//3, 김길동, zxcv.com, M