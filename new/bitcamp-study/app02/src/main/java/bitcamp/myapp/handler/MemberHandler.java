package bitcamp.myapp.handler;

import bitcamp.util.Prompt;

public class MemberHandler {

  static final int MAX_SIZE = 100;
  static int[] no = new int[MAX_SIZE];
  static String[] name = new String[MAX_SIZE];
  static String[] email = new String[MAX_SIZE];
  static String[] password = new String[MAX_SIZE];
  static char[] gender = new char[MAX_SIZE];
  static int userId = 1;
  static int length = 0;
  static char char2 = 0;

  static final char MALE = 'M';
  static final char FEMALE = 'W';

  public static void inputMember() {
    if (!available()) {
      System.out.println("더이상 입력할 수 없습니다");
      return;
    }
    name[length] = Prompt.inputString("이름? ");
    email[length] = Prompt.inputString("이메일? ");
    password[length] = Prompt.inputString("암호? ");
    gender[length] = inputGender((char) 0);

    no[length] = userId++;
    length++;
  }

  public static void printMembers() {
    System.out.println("---------------------------------------");
    System.out.println("번호, 이름, 이메일, 성별");
    System.out.println("---------------------------------------");

    for (int i = 0; i < length; i++) {
      System.out.printf("%d, %s, %s, %s\n",
              no[i], name[i], email[i],
              setGender(gender[i]));
    }
  }

  public static void viewMember() {
    String memberNo = prompt.inputString("번호? ");
    for (no[i] == Integer.parseInt(memberNo)) {
      System.out.println("이름 : %s\n", name[i]);
      System.out.println("이메일 : %s\n", email[i]);
//      System.out.println("성별 : %c\n", gender[i] == 'M' ? "남성" : "여성");
      System.out.println("성별 : %s\n", setGender(gender[i]));
      return;
    }
  }
  System.out.println("해당 번호의 회원`이 없습니다.");
}

  public static String setGender(char gender) {
    return gender == 'M' ? "남성" : "여성";
  }

  public static void updateMember() {
    int n = Integer.parseInt(Prompt.inputString("번호? "));
    for (int i=0; i<length; i++) {
      if (no[i] == Integer.parseInt(memberNo)) {
        System.out.printf("이름(%s)", name[i]);
        name[i] = Prompt.inputString("");
        System.out.printf()"이메일(%s)", email[i];
        email[i] = Prompt.inputString("");
        System.out.printf("새암호 : ");
        password[i] = Prompt.inputString("");
        System.out.printf("성별(%s)?\n",toGenderString[gender[i]]);


        loop: while (true) {
        String menuNo = Prompt.inputString(
              "  1. 남자\n" +
              "  2. 여자\n" +
              "> ");

      switch (menuNo) {
        case "1":
          gender[n - 1] = MALE;
          break loop;
        case "2":
          gender[n - 1] = FEMALE;
          break loop;
        default:
          System.out.println("무효한 번호입니다.");
      }
    }

    }





//
//    name[n - 1] = Prompt.inputString("이름(홍길동)?");
//    email[n - 1] = Prompt.inputString("이메일(hong@test.com)?");
//    password[n - 1] = Prompt.inputString("새암호?");
//    loop: while (true) {
//      String menuNo = Prompt.inputString("성별(여자)? :\n" +
//              "  1. 남자\n" +
//              "  2. 여자\n" +
//              "> ");
//
//      switch (menuNo) {
//        case "1":
//          gender[n - 1] = MALE;
//          break loop;
//        case "2":
//          gender[n - 1] = FEMALE;
//          break loop;
//        default:
//          System.out.println("무효한 번호입니다.");
//      }
//    }
  }



System.out.println("해당 번호의 회원이 없습니다!");
}

private void inputGender(char gender){
  String label;
  if (gender ! = 0) { // 성별 x
    label = "성별?:\n";
        } else {
    label = "성별(" + toGenderString(gender) + ")?\n";
        }
  loop:
        while (true) {
          String.format("성별()")
          String menuNo = Prompt.inputString(labael +
          "  1. 남자\n" +
          "  2. 여자\n" +
          "> " );

        switch (menuNo) {
        case "1":
         return MALE;

        case "2":
          return FEMALE;
        default:
        System.out.println("무효한 번호입니다.");
             }
        }


  }

  public static void deleteMember() {


  }


  private static boolean available() {
    return length < MAX_SIZE;

  }
}
