package project.myapp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import bitcamp.myapp.vo.AutoIncrement;
import project.myapp.handler.MemberAddListener;
import project.myapp.handler.MemberDeleteListener;
import project.myapp.handler.MemberDetailListener;
import project.myapp.handler.MemberLankListener;
import project.myapp.handler.MemberListListener;
import project.myapp.handler.MemberUpdateListener;
import project.myapp.vo.Member;
import project.util.BreadcrumbPrompt;
import project.util.Menu;
import project.util.MenuGroup;

public class App {

  List<Member> memberList = new ArrayList<>();

  BreadcrumbPrompt prompt = new BreadcrumbPrompt();

  MenuGroup mainMenu = new MenuGroup("메인");

  public App() {
    prepareMenu();
  }

  public static void main(String[] args) {
    new App().execute();
  }

  static void printTitle() {
    System.out.println(" 랜덤으로 값을 맞추는 게임 시스템");
    System.out.println("----------------------------------");
  }

  public void execute() {
    printTitle();

    loadData();
    mainMenu.execute(prompt);
    saveData();

    prompt.close();
  }

  private void loadData() {
    loadJson("Game.json", memberList, Member.class);
  }

  void saveData() {
    saveJson("Game.json", memberList);
  }


  private void prepareMenu() {
    MenuGroup boardMenu = new MenuGroup("게임시작");
    MenuGroup memberMenu = new MenuGroup("관리 모드");

    boardMenu.add(new Menu("게임 시작", new PlayGuessNumberGame(memberList)));


    mainMenu.add(boardMenu);

    boardMenu.add(new Menu("User 순위", new MemberLankListener(memberList)));
    memberMenu.add(new Menu("전적 조회", new MemberListListener(memberList)));
    memberMenu.add(new Menu("User 등록", new MemberAddListener(memberList)));
    memberMenu.add(new Menu("User 조회", new MemberDetailListener(memberList)));
    memberMenu.add(new Menu("User 변경", new MemberUpdateListener(memberList)));
    memberMenu.add(new Menu("User 삭제", new MemberDeleteListener(memberList)));
    mainMenu.add(memberMenu);

  }

  private <T> void loadJson(String filename, List<T> list, Class<T> clazz) {
    try {
      FileReader in0 = new FileReader(filename);
      BufferedReader in = new BufferedReader(in0); // <== Decorator 역할을 수행!

      StringBuilder strBuilder = new StringBuilder();
      String line = null;

      while ((line = in.readLine()) != null) {
        strBuilder.append(line);
      }

      in.close();

      Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
      Collection<T> objects = gson.fromJson(strBuilder.toString(),
          TypeToken.getParameterized(Collection.class, clazz).getType());

      list.addAll(objects);

      Class<?>[] interfaces = clazz.getInterfaces();
      for (Class<?> info : interfaces) {
        if (info == AutoIncrement.class) {
          AutoIncrement autoIncrement = (AutoIncrement) list.get(list.size() - 1);
          autoIncrement.updateKey();
          break;
        }
      }

    } catch (Exception e) {
      System.out.println(filename + " 파일을 읽는 중 오류 발생!");
    }
  }

  private void saveJson(String filename, List<Member> memberList) {
    try {
      FileWriter out0 = new FileWriter(filename);
      BufferedWriter out = new BufferedWriter(out0);

      Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").setPrettyPrinting().create();
      String json = gson.toJson(memberList);

      out.write(json);
      out.close();

    } catch (Exception e) {
      System.out.println(filename + " 파일을 저장하는 중 오류 발생!");
    }
  }
}
