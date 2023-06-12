package myapp.vo;

public class Member {
  private int no;
  private String name;
  private String email;
  private String password;
  private char gender;

  public int getNo() {
    return this.no;
  }

  public int setNo(int no) {
    this.no =  no;
  }

  public String getName() {
    return this.name;
  }

  public String setName(String name) {
    this.name=  name;
  }

  public String getEmail() {
    return this.email;
  }

  public int setEmail(String email) {
    this.email =  email;
  }

  public String getPassword() {
    return this.password;
  }

  public int setPassword(String password) {
    this.password =  password;
  }

  public char getGender() {
    return this.gender;
  }

  public char setGender (char gender) {
    this.gender =  gender;
  }

}
