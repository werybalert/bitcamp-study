
import java.util.Scanner;

public class App {

    /*
    )
     */
        static void m2(int a, String... names) {} // OK!

        // 배열 파라미터는 여러 개 선언할 수 있다.
        static void x1(String[] names, String[] emails) {}

        // 배열 파리미터는 순서에 상관 없다.
        static void x2(String[] names, int a) {}

        public static void main(String[] args) {


    //        for (String name : names)
    //      System.out.println(name);
    //      동일하다        =
            for (int i = 0; i<name.length; i++) {
                String name = name[i];
                System.out.println(name);
            }


            Scanner keyScan = new Scanner(System.in);
            System.out.print("밑변의 길이? ");
            int len = keyScan.nextInt();
            keyScan.close();

            int starLen = 1;
            while (starLen <= len) {
                // 별 앞에 공백 출력
                int spaceCnt = 1;
                int spaceLen = (len - starLen) / 2;
                while (spaceCnt <= spaceLen) {
                    System.out.print(" ");
                    spaceCnt++;
                }



                // 별 출력
                int starCnt = 1;
                while (starCnt <= starLen) {
                    System.out.print("*");
                    starCnt++;
                }

                // 출력 줄 바꾸기
                System.out.println();
                starLen += 2;
            }

    //            밑변의 길이? 3
    // *
    //***'
    //        밑변의 길이? 9
    //    *
    //   ***
    //  *****
    // *******
    //*********


            // 2 + 3 + 4 + 5 = ?
            //
            // 1) 메서드의 리턴 값을 변수로 받을 때
            int result = plus(2, 3);
            result = plus(result, 4); // result 변수가 넘어가는 것이 아니라 result 변수의 값이 넘어 간다.
            result = plus(result, 5);
            System.out.println(result);

            // 2) 메서드의 리턴 값을 바로 파라미터에 전달할 때
            result = plus(plus(plus(2, 3), 4), 5);
            // 실행 과정
            // - 메서드를 호출하는 문장의 가장 안쪽부터 실행된다.
            //
            // result = plus(plus(5, 4),5);
            // result = plus(9, 5);
            // result = 14;
            //
            System.out.println(result);

            System.out.println(plus(plus(plus(2, 3), 4), 5));

            int r = plus(100, 200);
            System.out.printf("100 + 200 = %d\n", r);

            // 위의 문장은 다음과 같다.
            System.out.printf("100 + 200 = %d\n", plus(100, 200));

        }


        static int plus(int a, int b) {
            return a + b;
        }
    //14
    //14
    //14
    //100 + 200 = 300
    //100 + 200 = 300


            // 가변 파라미터
            // [리턴타입] 메서드명(타입... 변수) {...}
            // => 0 개 이상의 값을 받을 때 선언하는 방식.
            // => 메서드 내부에서는 배열처럼 사용한다.
            //
            // 다음은 hello()를 호출할 때 String 값을 0개 이상 전달할 수 있다. = String...
            static void hello(String... names) {
                for (int i = 0; i < names.length; i++) {
                    System.out.printf("%s님 반갑습니다.\n", names[i]);
                }
            }

            public static void main(String[] args) {

                hello(); // 이 경우 names 배열의 개수는 0이다.
                System.out.println("-------------------");

                hello("홍길동"); // 이 경우 names 배열의 개수는 1이다.
                System.out.println("-------------------");

                hello("홍길동", "임꺽정", "유관순"); // 이 경우 names 배열의 개수는 3이다.
                System.out.println("-------------------");

                // 가변 파라미터 자리에 배열을 직접 넣어도 된다.
                String[] arr = {"김구", "안중근", "윤봉길", "유관순"};

                hello(arr);
                System.out.println("-------------------");

                //    hello("홍길동", 20, "오호라"); // 다른 타입은 안된다. 컴파일 오류!
            }

    //        -------------------
    //홍길동님 반갑습니다.
    //-------------------
    //홍길동님 반갑습니다.
    //임꺽정님 반갑습니다.
    //유관순님 반갑습니다.
    //-------------------
    //김구님 반갑습니다.
    //안중근님 반갑습니다.
    //윤봉길님 반갑습니다.
    //유관순님 반갑습니다.
    //-------------------




        // 가변 파라미터에 배열을 넘길 경우
        // 기존 배열을 그대로 사용할까? 아니면 파라미터로 받은 배열을 복제해서 사용할까?
        // => 가변 파라미터에 배열을 넘길 경우 그 배열을 그대로 받아 사용한다.
        static void hello(String... names) {
            for (int i = 0; i < names.length; i++) {
                names[i] += "^^";
                System.out.printf("%s님 반갑습니다.\n", names[i]);
            }
        }

        public static void main(String[] args) {

            String[] arr = {"김구", "안중근", "윤봉길", "유관순"};

            // 가변 파라미터에 배열을 넘길 경우
            hello(arr);
            System.out.println("-------------------");

            for (String value : arr) {
                System.out.println(value);
            }
        }
    //    김구^^님 반갑습니다.
    //안중근^^님 반갑습니다.
    //윤봉길^^님 반갑습니다.
    //유관순^^님 반갑습니다.
    //-------------------
    //김구^^
    //안중근^^
    //윤봉길^^
    //유관순^^

    //--------------------------------------------------------------
    public static void main(String[] args) {
        int result = plus(2, 3);
        result = plus(result, 4); // result 변수가 넘어가는 것이 아니라 result 변수의 값이 넘어 간다.
        result = plus(result, 5);
        System.out.println(result);

        // 2) 메서드의 리턴 값을 바로 파라미터에 전달할 때
        result = plus(plus(plus(2, 3), 4), 5);
//    14

        // 실행 과정
        // - 메서드를 호출하는 문장의 가장 안쪽부터 실행된다.
        //
        // result = plus(plus(5, 4),5);
        // result = plus(9, 5);
        // result = 14;
        //
        System.out.println(result);

//    14

        System.out.println(plus(plus(plus(2, 3), plus(10, 20)), 5));

//   plus(2, 3), plus(10, 20) 실행 가능
//    40

    }

    static int plus(int a, int b) {
        return a + b;
    }


    }


    public static void main(String[] args) {
        int a = 100, b = 200;
        swap(a,b);
        System.out.printf("main() : %d,%d\n",a,b);

    }
    static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
        System.out.printf("swap(): %d,%d\n",a,b);
    }

//swap(): 200,100
//main()    : 100,200


//--------------------------------------------------------------

    static class MyObject {
        // => class 는 메모리의 구조를 설계하는 문법이다.
        // => new 명령을 이용하여 변수를 생성할 수 있다.
        int a;
        int b;
    }

    static void swap(MyObject ref) {
        System.out.printf("swap(): a=%d, b=%d\n", ref.a, ref.b);
        int temp = ref.a;
        ref.a = ref.b;
        ref.b = temp;
        System.out.printf("swap(): a=%d, b=%d\n", ref.a, ref.b);
    }

    public static void main(String[] args) {
        // MyObject 설계도에 따라 int a와 int b 메모리를 만든다.
        // 그리고 그 메모리(인스턴스=객체)의 주소를 ref 변수에 저장한다.
        MyObject ref = new MyObject();
        ref.a = 100;
        ref.b = 200;

        // a, b 변수가 들어 있는 인스턴스(객체=메모리)의 주소를
        // swap()에 넘긴다. => 그래서 "call by reference"인 것이다.
        swap(ref);
        System.out.printf("main(): a=%d, b=%d\n", ref.a, ref.b);
    }

//swap(): a=100, b=200
//swap(): a=200, b=100
//main(): a=200, b=100




static class MyObject {
    int a;
    int b;
}

    static MyObject swap(int a, int b) {
        MyObject ref = new MyObject();
        ref.a = b; //200
        ref.b = a; //100
        return ref;
    }

    public static void main(String[] args) {
        int a = 100;
        int b = 200;

        MyObject ref = swap(a, b);

        System.out.printf("main(): ref.a=%d, ref.b=%d\n", ref.a, ref.b);
    }

//main(): ref.a=200, ref.b=100



    static void swap(int a, int b) {
        int temp = a; //100
        a = b;  //200
        b = temp; //100
        System.out.printf("swap(): a=%d, b=%d\n", a, b);
    }
    //    swap(): a=200, b=100

    public static void main(String[] args) {
        int a = 100;
        int b = 200;
        swap(a, b);
        System.out.printf("main(): a=%d, b=%d\n", a, b);
    }
//    main(): a=100, b=200


    public static void main(String[] args) throws Exception {

        int[] moneys = new int[] {100, 200, 300};
        float[] totals = new float[moneys.length];

        // 호출하는 쪽에서 결과를 담을 배열을 주는 경우
        compute(moneys, totals, 0.0089f);

        for (int i = 0; i < moneys.length; i++) {
            System.out.printf("%d => %.1f\n", moneys[i], totals[i]);
        }

        System.out.println("---------------------");

        float[] result;
        // 메서드 쪽에서 결과를 담을 배열을 만들어 리턴하는 경우
        result = compute2(moneys, 0.0089f);

        for (int i = 0; i < moneys.length; i++) {
            System.out.printf("%d => %.1f\n", moneys[i], result[i]);
        }

    }

    static void compute(int[] moneys, float[] totals, float interest) {
        for (int i = 0; i < moneys.length; i++) {
            totals[i] = moneys[i] + (moneys[i] * interest);
        }
    }

    static float[] compute2(int[] moneys, float interest) {
        float[] totals = new float[moneys.length];
        for (int i = 0; i < moneys.length; i++) {
            totals[i] = moneys[i] + (moneys[i] * interest);
        }
        return totals;
    }


//100 => 100.9
//200 => 201.8
//300 => 302.7
//---------------------
//100 => 100.9
//200 => 201.8
//300 => 302.7





//----------------------------------------------------------------------------


    public static void main(String[] args) {
        // 학생의 이름과 국영수 점수를 입력 받아 총점과 평균을 출력하라
        // $ java -cp ./bin/main com.eomcs.lang.ex07.Exam0540 홍길동 100 100 90
        // 이름: 홍길동
        // 총점: 290
        // 평균: 96.9
        //

        if (args.length < 4) {
            System.out.println(
                    "실행 형식: java -cp ./bin/main com.eomcs.lang.ex07.Exam0540 이름 국어점수 영어점수 수학점수");
            return;
        }

        int sum = 0;
        for (int i = 1; i < args.length; i++)
            sum += Integer.parseInt(args[i]);

        System.out.printf("이름: %s\n", args[0]);
        System.out.printf("총점: %d\n", sum);
        System.out.printf("평균: %.1f\n", sum / 3f);
    }

//실행 형식: java -cp ./bin/main com.eomcs.lang.ex07.Exam0540 이름 국어점수 영어점수 수학점수


    // 프로그램 아규먼트
    // - jvm을 실행할 때 프로그램에 전달하는 값
    // - 예)
    // > java -cp bin/main com.eomcs.lang.ex07.Exam0520 aaa bbb cccc
    // aaa bbb cccc 가 프로그램 아규먼트이다.
    //
    public static void main(String[] args) {
        // 프로그램 아규먼트는 스트링 배열에 담겨서 main()를 호출할 때
        // 넘어온다.
        // 프로그램 아규먼트는 공백을 기준으로 문자열을 잘라서 배열을 만든다.
        // 아규먼트가 없으면 빈 배열이 넘어온다.
        //
        for (String value : args) {
            System.out.printf("[%s]\n", value);
        }
        System.out.println("종료!");
    }
//종료!



// # 프로그램 아규먼트(arguments)
// - 프로그램을 실행할 때 넘겨주는 값.
// - 어떻게 아규먼트를 넘기는가?
//
// $ java 클래스명 값1 값2 값3
//
// - 아규먼트는 공백으로 구분한다.
// - JVM은 아규먼트의 개수만큼 문자열 배열을 만들어 저장한다.
// - 아규먼트가 없으면 빈 배열을 만든다.
// - 그런후 main()을 호출할 때 그 배열의 주소를 넘겨준다.



    public static void main(String[] args) {
    // 합계를 출력하는 프로그램을 작성하라.
    // $ java -cp ./bin/main com.eomcs.lang.ex07.Exam0530 200 43 56
    //
    int sum = 0;
    for (String arg : args)
    sum += Integer.parseInt(arg);
    System.out.printf("합계: %d\n", sum);

//    합계: 0




    }
//--------------------------------------------------------------------



    public static void main(String[] args) {
        // 학생의 이름과 국영수 점수를 입력 받아 총점과 평균을 출력하라
        // $ java -cp ./bin/main com.eomcs.lang.ex07.Exam0540 홍길동 100 100 90
        // 이름: 홍길동
        // 총점: 290
        // 평균: 96.9
        //

        if (args.length < 4) {
            System.out.println(
                    "실행 형식: java -cp ./bin/main com.eomcs.lang.ex07.Exam0540 이름 국어점수 영어점수 수학점수");
            return;
        }

        int sum = 0;
        for (int i = 1; i < args.length; i++)
            sum += Integer.parseInt(args[i]);

        System.out.printf("이름: %s\n", args[0]);
        System.out.printf("총점: %d\n", sum);
        System.out.printf("평균: %.1f\n", sum / 3f);
    }

//    실행 형식: java -cp ./bin/main com.eomcs.lang.ex07.Exam0540 이름 국어점수 영어점수 수학점수








}




