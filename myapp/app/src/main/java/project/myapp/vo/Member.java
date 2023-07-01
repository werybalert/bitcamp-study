package project.myapp.vo;

public class Member {

  @SuppressWarnings("unused")
  private int no;
  public String name; // 회원 이름
  public char gender; // 남녀 성별
  public int lives; // 남은 목숨
  public int card; // 뽑기 카드
  public int low; // 최고점
  public int high; // 최저점
  public static int totalPoints;



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
    Member.totalPoints = totalPoints;
  }

  public static int getUserId() {
    return userId;
  }

  public static void setUserId(int userId) {
    Member.userId = userId;
  }

  public static char getMale() {
    return MALE;
  }

  public static char getFemale() {
    return FEMALE;
  }

  public static int userId = 1;

  public static final char MALE = 'M';
  public static final char FEMALE = 'W';

  public Member() {
    this.no = userId++;
  }

  public Member(int no) {
    this.no = no;
  }

  public static Member fromCsv(String csv) {
    String[] values = csv.split(",");
    Member member = new Member(Integer.parseInt(values[0]));
    member.setName(values[1]);
    member.setGender(values[2].charAt(0));


    if (Member.userId <= member.getNo()) {
      Member.userId = member.getNo() + 1;
    }

    return member;
  } // fromCsv 끗

  public int getNo() {
    return 0;
  }

  public String toCsvString() {
    return String.format("%d,%s,%s,%s,%c", this.getNo(), this.getName(), this.getGender());
  }


  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }

    if (this.getClass() != obj.getClass()) {
      return false;
    }

    Member m = (Member) obj;

    if (this.getNo() != m.getNo()) {
      return false;
    }

    return true;
  }

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

  public void setNo(int no) {
    this.no = no;
  }


}
