package bitcamp.myapp2.vo;

public class Member {

  // 모든 인스턴스에서 공유하는 값은 스태틱 필드에 보관한다.
  private static int userId = 1;

  // 상수는 스태틱 필드로 정의.
  // => 정보를 다룰 떄는 그 정보를 갖고 있는 클래스에 그 기능을 둔다.
  // => 필드도 마찬가지.

  // GRASP 패턴 : Information Expert
  public static final char MALE = 'M';
  public static final char FEMALE = 'W';


  // 인스턴스 필드는 각각 개별적으로 유지해야 하는 값을 저장할떄 사용한다.
  // new 명령을 통해 변수를 Heap 영역에 생성한다.
  private int no;
  private String name;
  private String email;
  private String password;
  private char gender;


  // 생성자는 인스턴스를 생성한 필드를 초기화 시키는 일을 한다.
  // 인스턴스를 사용할떄 문제가 없도록 유효한 값으로 초기화시킨다.
  // 기본 생성자(default constructor)는 개발자가 생성자를 정의하지 않을떄
  // 컴파일러가 추가해주는 생성자다.
  // 물론 개발자가 직접 추가 가능!
  public Member() {
    this.no = userId++;
  }



  // Overloading = 오버로딩
  // 같은 기능을 수행하는 생성자는 위에 존재
  // 다만 파라미터가 다를 뿐이다.
  // 다른말로 = 생성자 오버로딩이라 한다.
  public Member(int no) {
    this.no = no;
  }

  // object의 equals()는 Member 인스턴스를 비교하는데 적합하지 않다.
  // Object의 equals()는 단순히 인스턴스 주소가 같은지 비교하기 때문
  // 우리가 원하는 것은 인스턴스 주소가 다르더라도
  // 그 인스턴스 안에 저장된 변수들의 값이 같다면
  // 두 인스턴스는 같은 것으로 처리하는 것이다.
  // 그래서 수퍼 클래스의 equals()를 재정의 한다.
  // 이것을 Overriding 오버라이팅이라 부른다.

  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }

    if (this.getClass() != obj.getClass()) {
      return false;
    }

    // 위 조건에서 this가 가리키는 인스턴스의 클래스와
    // 파라미터 obj가 가리키는 인스턴스의 클래스가
    // 같다고 결론이 났기에, obj를 Member 타입으로 형 변환한다.

    Member m = (Member) obj;

    if (this.getNo() != m.getNo()) {
      return false;
    }

    // 06.16 실습
    // if (this.getName() != null && !this.getName().equals(m.getName())) {
    // return false;
    // }
    //
    // if (this.getEmail() != null && !this.getEmail().equals(m.getEmail())) {
    // return false;
    // }
    //
    // if (this.getPassword() != null && !this.getPassword().equals(m.getPassword())) {
    // return false;
    // }
    //
    // if (this.getGender() != m.getGender()) {
    // return false;
    // }

    return true;
  }



  // getter/setter 는 인스턴스 필드의 값을 설정하고 꺼내는 method
  // 보통 회부에서 직접 필드에 접근하는 것을 막았을떄 사용.
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

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public char getGender() {
    return gender;
  }

  public void setGender(char gender) {
    this.gender = gender;
  }

}
