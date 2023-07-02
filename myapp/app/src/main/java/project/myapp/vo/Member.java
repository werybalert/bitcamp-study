package project.myapp.vo;

import java.io.Serializable;

import project.util.Prompt;

public class Member implements Serializable, CsvObject {
  private static final long serialVersionUID = 1L;

  public static int userId = 1;

public static int totalPoints;

  public static final char MALE = 'M';
  public static final char FEMALE = 'W';

  private int no;
  private String name;
  private char gender;

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

  @Override
  public String toCsvString() {
    return String.format("%d,%s,%s,%d",
        this.getNo(),
        this.getName(),
        this.getGender(),
        this.getTotalPoints());
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

  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
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

public int getTotalPoints() {
	return totalPoints;
}

public void setTotalPoints(int totalPoints) {
	Member.totalPoints = totalPoints;
}

public void setTotalPoints(Object addPoints) {
	Member.totalPoints = totalPoints;
	
}

}
