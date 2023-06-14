package bitcamp.test.step01;

//0609 실습 파일
//낮채의 변수 사용
public class App {
  public static void main(String[] args) {
    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float aver;

    name = "홍길동";
    kor = 100;
    eng = 100;
    math = 100;
    sum = kor + eng + math;
    aver = sum / 3f;

    System.out.printf("%s : 합계 = %d, 평균 %.1f\n", name, sum, aver);

  }
}


/*


//import bitcamp.util.Calculator;
//Calculator 앞에 bitcamp.util이란 코드를 자동으로 붙이고 compile 실행
main 안에
    // 2 * 3 + 7 - 2 / 2 = ?
    // 3 - 1 * 7 + 15 /3 = ?
    // => 위의 계싼을 동시에 수행하기



    //두 개의 계산 결과를 저장할 수 있는 result 변수 준비!!!!
    Calculator c1 = new Calculator();
    Calculator c2 = new Calculator();
    // == 인스턴스 필드!! ( c1 = reference = calculator 인스턴스 주소를 담을 변수)


    // => 연산자 우선 순위를 고려하지 않고 앞에서부터 뒤로 순차적으로 계산한다.

    c1.init(2);
    c1.multiple(3);
    c1.plus(7);
    c1.minus(2);
    c1.divide(2);

    System.out.println(c1.getResult());


    c2.init(3);
    c2.minus(1);
    c2.multiple(7);
    c2.plus(15);
    c2.divide(3);

    System.out.println(c2.getResult());

 */