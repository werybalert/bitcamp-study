package bitcamp.test.step03;

//0609 실습 파일
// 클래스를 이용하여 데이터 타입 정의
public class App {
  public static void main(String[] args){

    class score{
    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float ever;
  }
    final int Max_size = 10;
    Score[] scores = new Score[Max_size];
    int length = 0;

    Score s = new Score();
    s.name = "홍길동";
    s.kor = 100;
    s.eng = 100;
    s.math= 100;
    s.sum = s.kor + s.eng + s.math;
    s.aver = s.sum / 3f;
    score[length++] = s;
    System.out.printf("%s : 합계 = %d, 평균 %.1f\n", s.name, s.sum, s.aver);

    s = new Score();
    s.name = "임꺽정";
    s.kor = 90;
    s.eng = 90;
    s.math= 90;
    s.sum = s.kor + s.eng + s.math;
    s.aver = s.sum / 3f;
    score[length++] = s;
    System.out.printf("%s : 합계 = %d, 평균 %.1f\n", s.name, s.sum, s.aver);

    s = new Score();
    s.name = "유관순";
    s.kor = 80;
    s.eng = 80;
    s.math= 80;
    s.sum = s.kor + s.eng + s.math;
    s.aver = s.sum / 3f;
    score[length++] = s;
    System.out.printf("%s : 합계 = %d, 평균 %.1f\n", s.name, s.sum, s.aver);
    System.out.printf("%s : 합계 = %d, 평균 %.1f\n", name[length], sum[length], aver[length]);


    for (int i = 1; < length; i++ {
      s = score[i];
      System.out.printf("%s : 합계 = %d, 평균 %.1f\n", s.name, s.sum, s.aver);
    })

  }
}


