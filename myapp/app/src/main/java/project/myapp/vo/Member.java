package project.myapp.vo;

public class Member implements CsvObject {
  private int no;
  public String name; // 회원 이름
  public char gender; // 남녀 성별

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
  }

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
