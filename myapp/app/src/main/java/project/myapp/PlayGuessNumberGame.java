package project.myapp;

import java.util.InputMismatchException;
import java.util.List;
import project.myapp.vo.Member;
import project.util.ActionListener;
import project.util.BreadcrumbPrompt;
import project.util.Life;
import project.util.Totalpoint;

public class PlayGuessNumberGame implements ActionListener {

  public static int low;
  public static int high;
  public static int card;
  public static int point;

  protected List<Member> list;
  protected Member currentMember; // 현재 게임 참여한 Member 객체


  public PlayGuessNumberGame(List<Member> list) {
    this.list = list; // 전달받은 list로 초기화
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    boolean playAgain = true;
    while (playAgain) {
      Member m = new Member();
      m.setName(prompt.inputString("이름? "));
      m.setGender(inputGender((char) 0, prompt));

      this.list.add(m);

      playGame(prompt);


      // 현재 게임 참여한 Member 객체 설정
      currentMember = m;

      break;
    }

    System.out.println("****************");

  }


  protected static String toGenderString(char gender) {
    return gender == 'M' ? "남성" : "여성";
  }


  private char inputGender(char gender, BreadcrumbPrompt prompt) {

    String label;
    if (gender == 0) {
      label = "성별?\n";
    } else {
      label = String.format("성별(%s)?\n", toGenderString(gender));
    }

    while (true) {
      String menuNo = prompt.inputString(label + "  1. 남자\n" + "  2. 여자\n" + "> ");

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


  private void playGame(BreadcrumbPrompt prompt) {

    while (true) {
      low = 0;
      high = 50;
      card = prompt.RandomNumber();

      System.out.println("Up & Down 게임입니다. 숨겨진 수를 맞추어 보세요");

      Life.resetLives(); // 게임 시작 시 목숨 초기화
      int i = 0;

      while (Life.lives > 0) {
        Life.displayRangeAndStats(i);
        int n = getInput(prompt);

        if (n == -1) {
          continue;
        }

        if (prompt.isOutOfRange(n)) {
          System.out.println("범위를 벗어났어요");
        } else {
          if (n == card) {
            System.out.println("맞았습니다.");
            point += 50; // 맞추면 50점 추가
            break;
          } else if (n > card) {
            System.out.println("더 낮게");
            high = n;
          } else {
            System.out.println("더 높게");
            low = n;
          }
          Life.lives--;
        }
        i++;
      }

      if (Life.lives == 0) {
        System.out.println("게임 종료! 숨겨진 수는 " + card + "입니다.");
        System.out.println("획득한 점수: " + point + "점");
      }



      System.out.print("다시 하시겠습니까? (y/n) >>");
      String playAgain = prompt.scanner.next();
      if (playAgain.equalsIgnoreCase("n")) {
        break; // while 루프를 종료하여 게임을 완전히 종료합니다
      } else if (playAgain.equalsIgnoreCase("y")) {
        continue; // playGame 메서드를 다시 실행합니다.
      } else {
        System.out.println("잘못된 입력입니다. 게임을 종료합니다.");
        break; // 잘못된 입력이므로 게임을 종료합니다.
      }
    }

    Life.displayResult();
    if (list.size() > 0) {
      // 현재 게임 참여한 Member 객체 가져오기
      currentMember = list.get(list.size() - 1);
      System.out.println("플레이어 이름 : " + currentMember.getName());
      // Totalpoint 객체 생성
      Totalpoint totalpoint = new Totalpoint();
      // point 값을 Member 객체에 추가
      totalpoint.addPoints(currentMember, point);
    }
  }

  private int getInput(BreadcrumbPrompt prompt) {
    int n = 0;
    try {
      n = BreadcrumbPrompt.scanner.nextInt();
    } catch (InputMismatchException e) {
      System.out.println("정수만 입력하셔야 합니다!!");
      BreadcrumbPrompt.scanner.nextLine();
      return -1;
    }
    return n;
  }

  @Override
  public void service(BreadcrumbPrompt prompt, List<Member> list) {
    // TODO Auto-generated method stub

  }


}
