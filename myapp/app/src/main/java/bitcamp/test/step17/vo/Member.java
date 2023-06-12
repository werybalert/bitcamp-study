package bitcamp.test.step17.vo;

public class Member {

  // 프로그래밍의 일관을 위해 그냥 막았다.
  private String name;

  // 직접 접근을 허용했을 때, 무효한 값을 저장할 수 있기 때문에
  // private 으로 접근을 막았다.
  private int kor;
  private int eng;
  private int math;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getKor() {
    return kor;
  }

  public void setKor(int kor) {
    this.kor = kor;
  }

  public int getEng() {
    return eng;
  }

  public void setEng(int eng) {
    this.eng = eng;
  }

  public int getMath() {
    return math;
  }

  public void setMath(int math) {
    this.math = math;
  }

  public int getSum() {
    return sum;
  }

  public void setSum(int sum) {
    this.sum = sum;
  }

  public float getAver() {
    return aver;
  }

  public void setAver(float aver) {
    this.aver = aver;
  }

  private int sum;
  private float aver;

}

