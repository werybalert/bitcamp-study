package project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import bitcamp.myapp.vo.CsvObject;
import project.myapp.vo.Member;
import project.myapp.vo.Number;
import project.util.BreadcrumbPrompt;
import project.util.ManagerGroup;
import project.util.Menu;
import project.util.MenuGroup;
import project.util.MenuListener;


public class App {

  ArrayList<Member> memberList = new ArrayList<>();
  ArrayList<Number> NumList = new ArrayList<>();

  BreadcrumbPrompt prompt = new BreadcrumbPrompt();
  MenuGroup mainMenu = new MenuGroup("메인");
  ManagerGroup manageMenu = new ManagerGroup("관리자");


  protected void App() {
    prepareMenu();
  }

  public static void main(String[] args, int point, BreadcrumbPrompt name) {
    new App().execute();
    // App 클래스의 main 메서드를 재정의하여 게임 종료 후 실행되는 부분을 작성

    System.out.println("게임 종료! 획득한 점수: " + point + "점");

    write(name);

  }

  public static void write(BreadcrumbPrompt prompt) {
    String name = prompt.inputString("이름은? ");
    System.out.printf("%s 님 반가워요!\n", name);
  }


  public void execute() {
    printTitle();

    // loadData();
    mainMenu.execute(prompt);
    // saveData();

    prompt.close();

  }

  // private void loadData() {
  // loadCsv("member.csv", memberList, Member.class);
  // // loadCsv("number.csv", NumList, Number.class);
  //
  // }
  //
  // private void saveData() {
  // saveCsv("member.csv", memberList);
  // // saveCsv("number.csv", NumList);
  //
  // }


  private static void prepareMenu() {
    MenuGroup memberMenu = new MenuGroup("게임 mode");
    memberMenu.add(new Menu("게임 시작", new MenuListener()));
    // memberMenu.add(new Menu("전적 조회", new MemberDetailListener(memberList)));
    // mainMenu.add(memberMenu);

    ManagerGroup memberMenu2 = new ManagerGroup("관리자 모드");
    // memberMenu2.add(new Menu("User 조회", new MemberDetailListener(NumList)));
    // memberMenu2.add(new Menu("User 변경", new MemberUpdateListener(NumList)));
    // memberMenu2.add(new Menu("User 삭제", new MemberDeleteListener(NumList)));
    // manageMenu.add(memberMenu2);

  }


  private static void printTitle() {
    System.out.println("랜덤으로 값을 맞추는 게임");
    System.out.println("----------------------------------");
  }

  // 0630 실습 (loadMember + loadBoard 중복을 방지하고자 혼합한 코드)
  @SuppressWarnings("unchecked")
  private <T extends CsvObject> void loadCsv(String filename, List<T> list, Class<T> clazz) {
    try {
      Method factoryMethod = clazz.getDeclaredMethod("fromCsv", String.class);

      FileReader in0 = new FileReader(filename);
      BufferedReader in = new BufferedReader(in0); // <== Decorator 역할을 수행!

      String line = null;

      while ((line = in.readLine()) != null) {
        list.add((T) factoryMethod.invoke(null, line)); // Reflection API를 사용하여 스태틱 메서드 호출
        // list.add(Member.fromCsv(line)); // 직접 스태틱 메서드 호출
      }

      in.close();

    } catch (Exception e) {
      System.out.println(filename + " 파일을 읽는 중 오류 발생!");
    }
  }

  private void saveCsv(String filename, List<? extends CsvObject> list) {
    try {
      FileWriter out0 = new FileWriter(filename);
      BufferedWriter out1 = new BufferedWriter(out0); // <== Decorator(장식품) 역할 수행!
      PrintWriter out = new PrintWriter(out1); // <== Decorator(장식품) 역할 수행!

      for (CsvObject obj : list) {
        out.println(obj.toCsvString());
        // Board나 Member 클래스에 필드가 추가/변경/삭제되더라도
        // 여기 코드를 변경할 필요가 없다.
        // 이것이 Information Expert 설계를 적용하는 이유다!
        // 설계를 어떻게 하느냐에 따라 유지보수가 쉬워질 수도 있고,
        // 어려워질 수도 있다.
      }
      out.close();

    } catch (Exception e) {
      System.out.println(filename + " 파일을 저장하는 중 오류 발생!");
    }
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    // TODO Auto-generated method stub

  }
}
