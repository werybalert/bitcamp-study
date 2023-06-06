public class App2 {
    public static void main(String[] args) {
//       1.
/*
        // 조건연산자
        // => 조건 ? 표현식1 : 표현식2
        // => 조건이 참이면 표현식1을 실행하고,
        //    조건이 거짓이면 표현식2를 실행한다.
        //
        int age = 20;

        // 조건연산자의 왼쪽은 변수이어야 한다.
        String message = age > 18 ? "성년" : "미성년";
        System.out.printf("나이 %d는(은) %s이다.\n", age, message);

        //나이 20는(은) 성년이다.


 */
/*

//        2.
        // 조건연산자
        // => 조건 ? 표현식1 : 표현식2
        // => 조건이 참이면 표현식1을 실행하고,
        //    조건이 거짓이면 표현식2를 실행한다.
        //
        int age = 20;

        // 또는 파라미터 값이 놓일 자리에 조건연산자를 둘 수 있다.
        test(age > 18 ? "성년" : "미성년");
    }

    static void test(String value) {
        System.out.println(value + " 입니다.");
    }
//    성년 입니다.

 */
/*


//    2-1
int age = 20;

    // 조건 연산자를 수행한 후 그 결과를 받을 변수를 받드시 선언해야 한다.
    // => 선언하지 않으면 문법 오류!
   (age > 18) ? "성년" : "미성년";

//        App2.java:46: error: not a statement
//                (age > 18) ? "성년" : "미성년";
//              ^
//        App2.java:64: error: reached end of file while parsing
//    }
//     ^
//             2 errors

//  2-2
        int age = 20;

        // 표현식은 반드시 값을 리턴해야 한다.
     age > 18 ? System.out.println("성인이다.") : System.out.println("미성년자이다.");

     //        App2.java:62: error: not a statement
//        age > 18 ? System.out.println("성인이다.") : System.out.println("미성년자이다.");
//              ^

//2-3

        int age = 20;

        // 조건 연산자의 결과 값이 왼편의 변수 타입과 일치해야 한다.
        // => 결과 값이 없으면 문법 오류!
        //    String str = age > 18 ? System.out.println("성인이다.") : System.out.println("미성년자이다.");
        // 표현식 자리에는 문자가 되었든 숫자가 되었든
        // 실행 결과가 놓여져야 한다.
        // 위의 System.out.println(...) 문장은 결과를 리턴하지 않는다.
        // 그래서 컴파일 오류이다.

        // => 왼쪽 편의 변수 타입과 표현식의 결과 타입이 다르면 문법 오류!
        int result = age > 18 ? "성년" : "미성년";


        //        App2.java:82: error: incompatible types: bad type in conditional expression
//        int result = age > 18 ? "성년" : "미성년";
//                                ^
//        String cannot be converted to int
//        App2.java:82: error: incompatible types: bad type in conditional expression
//        int result = age > 18 ? "성년" : "미성년";
//                                       ^
//        String cannot be converted to int
//        2 errors


//        3.

        int i = 2;

        // 증감 연산자가 없다면,
        // 기존 변수의 값을 1증가시키기 위해 다음과 같이 코딩해야 한다.
        //i = i + 1;

        // 증감 연산자를 사용하면 다음과 같이 간략하게 작성할 수 있다.
        i++; // i => 3
        // 현재 위치에 i 메모리에 들어 있는 값(2)을 꺼내 놓는다.
        // 그런 다음에 i 메모리의 값을 1 증가시킨다.
        // 결론:
        //   ==> i++ 문장은 컴파일러가 i = i + 1 문장으로 바꾼다.
        //   ==> 즉 i = i + 1 문장을 축약한 문법에 불과하다.

        i++; // i => 4

        System.out.println(i);   // 4

        System.out.println(i++); // 4
        // 위의 코드는 컴파일 할 때 다음의 코드로 바뀐다.
        //
          int temp = i; //<-- 임시 변수를 만들어 현재 i 값을 저장한다.
            i = i + 1;
          System.out.println(temp);


        System.out.println(i); // 5
 */
//        4
//        4
//        5
//        6



//        4.
        int i = 2;

        // 증감 연산자가 없다면,
        // 기존 변수의 값을 1증가시키기 위해 다음과 같이 코딩해야 한다.
        //i = i + 1;

        // 증감 연산자를 사용하면 다음과 같이 간략하게 작성할 수 있다.
//    i++; // i => 3
        // 현재 위치에 i 메모리에 들어 있는 값(2)을 꺼내 놓는다.
        // 그런 다음에 i 메모리의 값을 1 증가시킨다.
        // 결론:
        //   ==> i++ 문장은 컴파일러가 i = i + 1 문장으로 바꾼다.
        //   ==> 즉 i = i + 1 문장을 축약한 문법에 불과하다.

//    i++; // i => 4

//    System.out.println(i);   // 4

//    System.out.println(i++); // 4
        // 위의 코드는 컴파일 할 때 다음의 코드로 바뀐다.
        //
        //    int temp = i; //<-- 임시 변수를 만들어 현재 i 값을 저장한다.
        //    i = i + 1;
        //    System.out.println(temp);

//    System.out.println(i); // 5


//        5.

//        6.




    }
}




