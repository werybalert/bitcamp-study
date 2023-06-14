package bitcamp.myapp.vo;

public class Number {
  public String name; // 회원 이름
  public char gender; // 남녀 성별
  public int lives; // 남은 목숨
  public int card; // 뽑기 카드
  public int low; // 최고점
  public int high; // 최저점
  public static int totalPoints;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public char getGender() {
    return gender;
  }

  public void setGender(char gender) {
    this.gender = gender;
  }

  public int getLives() {
    return lives;
  }

  public void setLives(int lives) {
    this.lives = lives;
  }

  public int getCard() {
    return card;
  }

  public void setCard(int card) {
    this.card = card;
  }

  public int getLow() {
    return low;
  }

  public void setLow(int low) {
    this.low = low;
  }

  public int getHigh() {
    return high;
  }

  public void setHigh(int high) {
    this.high = high;
  }

  public static int getTotalPoints() {
    return totalPoints;
  }

  public static void setTotalPoints(int totalPoints) {
    Number.totalPoints = totalPoints;
  }


}
