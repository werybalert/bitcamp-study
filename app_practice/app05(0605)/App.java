 import java.io.*;
 import java.util.*;

 import util.Calculator;

// 소스 코드에서 Calculator 클래스는 uilt 패키지에 소속된 클래스를 가리킨다.



public class App{

    public static void main(String[] args)  {
//        2 * 3 + 7 -2 /2

//        연산자 우선 순위를 고려하지 않고 앞에서 부터 뒤로 순차적으로 계산!

/*

        int result =  (2 * 3 + 7 -2 ) /2;
//                  5

        int result = 0; // 로컨 변수는 자동 초기화 x , 그외 나머지는 자동

//        동일한 메소드 방법

        multiple(2,3);
        result = plus(result,7);
        result = minus(result,2);
        result = divide(result ,2);
        System.out.println(result);
*/
//        동일한 메소드 방법.2

        Calculator.init(2);
        Calculator.multiple(3);
        Calculator.plus(7);
        Calculator.minus(2);
        Calculator.divide(2);
        System.out.println(Calculator.result);
    }
}