package bitcamp.util;

public class MenuPrompt extends Prompt {

  private Queue commandHistory = new Queue();
  private Stack menus = new Stack();
  private Stack breadcrumbs = new Stack();

  public void appendBreadcrumb(String title, String menu) {
    breadcrumbs.push(title);
    this.menus.push(menu);
  }

  public void removeBreadcrumb() {
    this.breadcrumbs.pop();
    this.menus.pop();
  }

  public void printMenu() {
    System.out.println(menus.peek());
  }

  // 0620 실습
  public void printCommandHistory() {
    for (int i = 0; i < commandHistory.size; i++) {
      System.out.println(commandHistory.get(i));
    }
  }


  public String inputMenu() {
    StringBuilder titleBuilder = new StringBuilder(); // 예) 메인/ 회원>
    for (int i = 0; i < this.breadcrumbs.size(); i++) {
      if (titleBuilder.length() > 0) {
        titleBuilder.append("/");
      }
      titleBuilder.append(this.breadcrumbs.get(i));
    }
    titleBuilder.append("> ");

    String command = null;
    // this.inputString(titleBuilder.toString());

    while (true) {
      command = this.inputString(titleBuilder.toString());
      if (command.equals("history")) {
        this.printCommandHistory();
      } else if (command.equals("menu")) {
        this.printMenu();
      } else if (findMenuItem(command) == null) {
        System.out.println("메뉴 번호가 옳지 않습니다.");
      } else {
        break;
      }
    }



    // 사용자가 입력한 명령어를 history에 보관
    if (commandHistory.size() == 10) {
      // 명령어 목록은 최대 10개 유지
      // 10개 초과할 경우 맨앞 기록을 제거!
      commandHistory.poll();
    }

    String menuItem = findMenuItem(command);
    if (menuItem != null) {
      commandHistory.offer(titleBuilder.toString() + ":" + menuItem);
    } else {
      commandHistory.offer(command);
    }
    return command;
  }

  // 예시)
  // 메인> history
  // menu
  // 메인> :2.게시글
  // 메인/게시글> :1메인
  // 메인/게시글> :1메인
  // 15
  // 메인/게시글> :5.삭제
  // 메인/게시글> :2.등록
  // 0
  // haha
  // 01010

  private String findMenuItem(String command) {
    String menuTitle = null;

    // command에 해당하는 메뉴가 있다면 그 메뉴 이름을 return 하고
    // 없다면 원래 command 값을 return

    // 1) 현재 메뉴를 알아낸다. 메뉴 스택에서 맨 마지막에 입력한 메뉴 조회
    String menu = (String) menus.peek();

    // 2) 꺼낸 메뉴에서 해당 번호의 메뉴 검색
    String[] menuitems = menu.split("\n");
    for (String menuitem : menuitems) {
      if (menuitem.startsWith(command)) { // startsWith = true 출력
        return menuitem;
      }
    }
    return menuTitle;
  }
}
