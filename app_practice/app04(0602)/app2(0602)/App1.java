
//0602 실습

import java.util.Scanner;

public class App1 {

    static Scanner scanner = new Scanner(System.in);

    static final int MAX_SIZE = 100;
    static int[] no = new int[MAX_SIZE];
    static String[] name = new String[MAX_SIZE];
    static String[] email = new String[MAX_SIZE];
    static String[] password = new String[MAX_SIZE];
    static char[] gender = new char[MAX_SIZE];
    static int userID = 1;
    static int length = 0;


    public static void main(String[] args) {

        printTitle();

//              회원 정보 등록
        while (length < MAX_SIZE) {
            inputMember();
            if (!promptContinue()) {
                break;
            }
        }
        printMembers();

        scanner.close();
    }

        static void printTitle() {
            System.out.println("나의 목록 관리 시스템");
            System.out.println("----------------------------------");
          }


    static void inputMember() {

        System.out.print("이름? : ");
        name[length] = scanner.next();

        System.out.print("email? : ");
        email[length] = scanner.next();

        System.out.print("PW : ");
        password[length] = scanner.next();

//      1. 남자 / 2. 여자 / 3. ~~ 무효한 번호 입니다. => 다시 1.2.선택지로 이동
//      next : enter가 입력되기 전까지 대기
        loop: while (true) {
            System.out.println("성별  : ");
            System.out.println("1. 남자 ");
            System.out.println("2. 여자 ");
            System.out.print(" > ");
            String menuNum = scanner.next();
            scanner.nextLine(); // 입력 값(Token)을 읽고 난 후에 남아 있는 줄바꿈 코드를 제거한다.


//2. switch 구문
            switch (menuNum) {
                case "1":
                    gender[length] = 'M';
                    break loop;
                case "2":
                    gender[length] = 'w';
                    break loop;           //  === 반복문 탈출
                default:
                    System.out.println("무료한 번호입니다.");
            }
        }

        no[length] = userID++;
        length++;
    }

    static boolean promptContinue() {

        System.out.print("계속 하시겠습니까?(Y/N)");
        String response = scanner.nextLine();       //nextLine 은 문자 입력을 자동으로 받는다.
        if (!response.equals("")  && !response.equalsIgnoreCase("Y")) {
            return false;
        }
        return true;
    }

    static void printMembers() {

        System.out.println("---------------------------------------");

        System.out.println("번호, 이름, 이메일, 성별");
        System.out.println("---------------------------------------");

        for (int i = 0; i < length; i++) {
            System.out.printf("%d, %s, %s, %c\n", no[i], name[i], email[i], gender[i]);

            }
        }
    }


//나의 목록 관리 시스템
//----------------------------------
//이름? : 홍길동
//email? : asdf.com
//PW : 1234
//성별  :
//1. 남자
//2. 여자
// > 1
//계속 하시겠습니까?(Y/N)Y
//이름? : 남길동
//email? : qwer.com
//PW : 3456
//성별  :
//1. 남자
//2. 여자
// > 2
//계속 하시겠습니까?(Y/N)N
//---------------------------------------
//번호, 이름, 이메일, 성별
//---------------------------------------
//1, 홍길동, asdf.com, M
//2, 남길동, qwer.com, w