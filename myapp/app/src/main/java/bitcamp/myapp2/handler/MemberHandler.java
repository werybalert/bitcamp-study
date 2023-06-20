package bitcamp.myapp2.handler;

import bitcamp.myapp2.vo.Member;
import bitcamp.util.LinkedList;
import bitcamp.util.List;
import bitcamp.util.Prompt;

public class MemberHandler implements Handler {

  // 06.19 실습
  // private List list = new LinkedList();
  private List list = new LinkedList();

  // private ArrayList list = new ArrayList();
  private Prompt prompt;
  private String title;


  // 필요한 값을 외부에서 받고 싶으면 파라미터(Prompt prompt)를 선언하시오!
  public MemberHandler(Prompt prompt, String title, List list) {
    this.prompt = prompt;
    this.title = title;
    this.list = list;
    // 생성자 : 인스턴스를 사용할 수 있도록 유효한 값으로 초기화 시키는 일을 수행
    // members = new Member[MAX_SIZE]; => 이렇게도 사용 가능
  }


  // 0615

  private static void printMenu() {
    System.out.println("0. 메인");
    System.out.println("1. 등록");
    System.out.println("2. 목록");
    System.out.println("3. 조회");
    System.out.println("4. 변경");
    System.out.println("5. 삭제");
  }



  // @Override 인터페이스에 선언된 메서드 정의,수퍼 클래스의 메서드를 재정의
  // (window > preprence > java > edit > save Editor > configure > Missing code > add check! )
  // Hndler 인터페이스에 선언된 대로 메서드 정의!
  // => "Handler 인터페이스를 구현" 라고 표현함!
  @Override
  public void execute() {
    printMenu();

    while (true) {
      String menuNo = prompt.inputString(" %s > ", this.title);
      if (menuNo.equals("0")) {
        return;
      } else if (menuNo.equals("menu")) {
        printMenu();
      } else if (menuNo.equals("1")) {
        this.inputMember();
      } else if (menuNo.equals("2")) {
        this.printMembers();
      } else if (menuNo.equals("3")) {
        this.viewMember();
      } else if (menuNo.equals("4")) {
        this.updateMember();
      } else if (menuNo.equals("5")) {
        this.deleteMember();
      } else {
        System.out.println("메뉴 번호가 옳지 않습니다");
      }
    }
  }


  private void inputMember() {
    Member m = new Member();
    m.setName(this.prompt.inputString("이름? "));
    m.setEmail(this.prompt.inputString("이메일? "));
    m.setPassword(this.prompt.inputString("암호? "));
    m.setGender(inputGender((char) 0));

    this.list.add(m); // add의 입력 실패는 LinkedList에선 볼수 없다

    // if (!this.list.add(m)) {
    // System.out.println("입력 실패 입니다.");
    // return;
    // }


    // 위에서 만든 Member 인스턴스의 주소를 잃어버리지 않게
    // 레퍼런스 배열에 담는다.

    // MemberList 이동
    // this.members[this.length++] = m;


  }

  private void printMembers() {
    System.out.println("---------------------------------------");
    System.out.println("번호, 이름, 이메일, 성별");
    System.out.println("---------------------------------------");

    // Object[] arr = this.list.toArray();
    // for (Object obj : arr) {
    for (int i = 0; i < this.list.size(); i++) {
      Member m = (Member) this.list.get(i);
      System.out.printf("%d, %s, %s, %s\n", m.getNo(), m.getName(), m.getEmail(),
          toGenderString(m.getGender()));
    }
  }

  private void viewMember() {

    Member m = this.findBy(this.prompt.inputInt("번호? "));

    if (m == null) {
      System.out.println("해당 번호의 회원이 없습니다!");
      return;
    }
    System.out.printf("이름: %s\n", m.getName());
    System.out.printf("이메일: %s\n", m.getEmail());
    System.out.printf("성별: %s\n", toGenderString(m.getGender()));
  }


  // 메소가 instance를 쓰지 않으면 static으로 생성!!

  private static String toGenderString(char gender) {
    return gender == 'M' ? "남성" : "여성";
  }

  private void updateMember() {

    Member m = this.findBy(this.prompt.inputInt("번호? "));
    if (m == null) {
      System.out.println("해당 번호의 회원이 없습니다!");
      return;
    }
    m.setName(this.prompt.inputString("이름(%s)? ", m.getName()));
    m.setEmail(this.prompt.inputString("이메일(%s)? ", m.getEmail()));
    m.setPassword(this.prompt.inputString("새암호? "));
    m.setGender(inputGender(m.getGender()));
  }



  private char inputGender(char gender) {
    String label;
    if (gender == 0) {
      label = "성별?\n";
    } else {
      label = String.format("성별(%s)?\n", toGenderString(gender));
    }
    while (true) {
      String menuNo = this.prompt.inputString(label + "  1. 남자\n" + "  2. 여자\n" + "> ");

      switch (menuNo) {
        case "1":
          return Member.MALE;
        case "2":
          return Member.FEMALE;
        default:
          System.out.println("무효한 번호입니다.");
      }
    }
  }

  private void deleteMember() {

    if (!this.list.remove(new Member(this.prompt.inputInt("번호? ")))) {
      System.out.println("해당 번호의 회원이 없습니다!");
    }
  }


  private Member findBy(int no) {

    // Object[] arr = this.list.toArray();
    // for (Object obj : arr) {

    for (int i = 0; i < this.list.size(); i++) {
      Member m = (Member) this.list.get(i);
      if (m.getNo() == no) {
        return m;
      }
    }
    return null;
  }


}

