ex)06

import java.util.ArrayList;

public class App2 {
    public static void main(String[] args) {
        /*


        Scanner keyScan = new Scanner(System.in);
        System.out.println("[지원부서]");
        System.out.println("1. S/W개발");
        System.out.println("2. 일반관리");
        System.out.println("3. 시설경비");
        System.out.print("지원 분야의 번호를 입력하세요? ");
        int no = keyScan.nextInt();

        System.out.println("제출하실 서류는 다음과 같습니다.");
        switch (no) {
            case 1:
                System.out.println("정보처리자격증");
                System.out.println("졸업증명서");
                System.out.println("이력서");
                break; // 여기까지만 실행한다.
            case 2:
                System.out.println("졸업증명서");
                System.out.println("이력서");
                break; // 여기까지만 실행한다.
            case 3:
                System.out.println("이력서");
                break; // 여기까지만 실행한다.
            default:
                System.out.println("올바른 번호를 입력하세요!");
        }
        keyScan.close();
//[지원부서]
//1. S/W개발
//2. 일반관리
//3. 시설경비
//지원 분야의 번호를 입력하세요? 2
//제출하실 서류는 다음과 같습니다.
//졸업증명서
//이력서


        int level = 1;

        // 상수를 사용하지 않았을 때
        // => 값의 의미를 주석으로 달아야만 다른 개발자가 이해할 수 있다.
        switch (level) {
            case 0: // 손님
                System.out.println("조회만 가능합니다.");
                break;
            case 1: // 일반회원
                System.out.println("글작성 가능합니다.");
                break;
            case 2: // 관리자
                System.out.println("다른 회원의 글을 변경, 삭제할 수 있습니다.");
                break;
        }


        int x = 2, y = 1;

        // 5 * 5 까지만 출력하라!
        myloop:
        while (x <= 9) {

            while (y <= 9) {
                System.out.printf("%d * %d = %d\n", x, y, x * y);
                if (x == 5 && y == 5)
                    break myloop; // myloop 라벨에 소속된 문장을 나간다.
                y++;
            }

            System.out.println();
            x++;
            y = 1;
        }
        System.out.println("종료!!");
//        2 * 1 = 2
//2 * 2 = 4
//2 * 3 = 6
//2 * 4 = 8
//2 * 5 = 10
//2 * 6 = 12
//2 * 7 = 14
//2 * 8 = 16
//2 * 9 = 18
//
//3 * 1 = 3
//3 * 2 = 6
//3 * 3 = 9
//3 * 4 = 12
//3 * 5 = 15
//3 * 6 = 18
//3 * 7 = 21
//3 * 8 = 24
//3 * 9 = 27
//
//4 * 1 = 4
//4 * 2 = 8
//4 * 3 = 12
//4 * 4 = 16
//4 * 5 = 20
//4 * 6 = 24
//4 * 7 = 28
//4 * 8 = 32
//4 * 9 = 36
//
//5 * 1 = 5
//5 * 2 = 10
//5 * 3 = 15
//5 * 4 = 20
//5 * 5 = 25
//
//6 * 1 = 6
//6 * 2 = 12
//6 * 3 = 18
//6 * 4 = 24
//6 * 5 = 30
//6 * 6 = 36
//6 * 7 = 42
//6 * 8 = 48
//6 * 9 = 54
//
//7 * 1 = 7
//7 * 2 = 14
//7 * 3 = 21
//7 * 4 = 28
//7 * 5 = 35
//7 * 6 = 42
//7 * 7 = 49
//7 * 8 = 56
//7 * 9 = 63
//
//8 * 1 = 8
//8 * 2 = 16
//8 * 3 = 24
//8 * 4 = 32
//8 * 5 = 40
//8 * 6 = 48
//8 * 7 = 56
//8 * 8 = 64
//8 * 9 = 72
//9 * 8 = 72
//9 * 9 = 81
//
//종료!!
        for (int i = 1; i <= 5; i++)
            System.out.println(i);

//         동일
        // for (변수선언 및 초기화; 조건; 증감문) 문장;
        // for (변수선언 및 초기화; 조건; 증감문) {문장1; 문장2; ...}

        // 조건문 제거
        int i = 1;
        for (  ;  ;  ) {
            if (i > 5)
                break;
            System.out.println(i);
            i++;
        }

//1
//2
//3
//4
//5

        // 변수초기화 시키는 문장에 여러 개의 변수를 선언 할 수 있다.
        // 변수 증가문에 여러 개의 문장을 작성할 수 있다.
        for (int i = 1, j = 3, k = 5; i <= 10; i++, j--, k += 2)
            System.out.printf("(%d,%d,%d) ", i, j, k);

//(1,3,5) (2,2,7) (3,1,9) (4,0,11) (5,-1,13) (6,-2,15) (7,-3,17) (8,-4,19) (9,-5,21) (10,-6,23)

        // break
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
                if (j == 5)
                    break; // break 소속된 현재 반복문을 멈춘다.
            }
            System.out.println();
        }

// 1
//1 2
//1 2 3
//1 2 3 4
//1 2 3 4 5
//1 2 3 4 5
//1 2 3 4 5
//1 2 3 4 5
//1 2 3 4 5
//1 2 3 4 5

        // break 라벨명;
        loop1: {
            for (int i = 1; i <= 10; i++) {
                for (int j = 1; j <= i; j++) {
                    System.out.print(j + " ");
                    if (j == 5)
                        break loop1; // 라벨로 지정한 문장을 나간다.
                }
                System.out.println();
            }
            System.out.println("-------------------------");
        }
        System.out.println("loop1 밖!");
// 1
//1 2
//1 2 3
//1 2 3 4
//1 2 3 4 5 loop1 밖!

        String[] names = {"홍길동", "임꺽정", "유관순", "윤봉길", "안중근"};

        for (int i = 0; i < names.length; i++){
            System.out.println(names[i]);
        }

//홍길동
//임꺽정
//유관순
//윤봉길
//안중근


        // 인덱스 범위 조정
        for (int i = 2; i < 4; i++) {
            System.out.println(names[i]);
        }
//유관순
//윤봉길


            // 증가치 조정
            for (int i = 0; i < names.length; i += 2) {
                System.out.println(names[i]);
            }
//홍길동
//유관순
//안중근

        // for (배열에서 꺼낸 값을 저장할 변수 선언 : 배열주소) 문장;
        for (String name : names) {
            System.out.println(name);
        }
    */

        // 배열은 같은 타입의 값만 보관할 수 있지만
        // 컬렉션은 다른 타입의 값도 보관할 수 있다.
        //
        // 배열은 크기가 고정되지만,
        // 컬렉션은 크기가 가변적이다.

        // 제네릭 적용
        ArrayList<String> list = new ArrayList<>();
        list.add("홍길동");
        list.add("임꺽정");
        list.add("유관순");
        list.add("안중근");
        list.add("윤봉길");
        list.add("김원봉");
        list.add("김구");

        // String 이 아닌 값은 넣을 수 없다.
        // list.add(3.14f); // 컴파일 오류
        // list.add(true); // 컴파일 오류
        // list.add(365); // 컴파일 오류

        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
//홍길동
//임꺽정
//유관순
//안중근
//윤봉길
//김원봉
//김구
        for (String name : list) {
            System.out.print(name + " ");
        }
//홍길동 임꺽정 유관순 안중근 윤봉길 김원봉 김구
    }
}

