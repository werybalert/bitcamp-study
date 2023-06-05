package bitcamp.util;

public class Calculator {           //class 공개모드로 변경하기

    public static int result;      //static 변수는 기본 값으로 0으로 초기화

    public static void init (int a) { //method definition call
        result = a;
    }

    public static void plus (int a) {
        result += a;
    }
    public static void minus (int a) {
        result -= a;
    }
    public static void multiple (int a) {
        result *= a;
    }
    public static void divide (int a) {
        result /= a;
    }

}
