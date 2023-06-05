import java.util.Scanner;

public class App02 {
  public static void main(String[] args) {

    /*
     Scanner keyScan = new Scanner(System.in);

    System.out.print("값1? ");
    int a = keyScan.nextInt();

    System.out.print("값2? ");
    int b = keyScan.nextInt();

    System.out.print("연산자(+,-,*,/)? ");
    String op = keyScan.next();

    keyScan.close();

    int result = 0;
    if (op.equals("+")) {
      result = a + b;
    } else if (op.equals("-")) {
      result = a - b;
    } else if (op.equals("*")) {
      result = a * b;
    } else if (op.equals("/")) {
      result = a / b;
    } else {
      System.out.println("=> 사용할 수 없는 연산자입니다.");
      return;
    }

    System.out.printf("=> %d %s %d = %d\n", a, op, b, result);

    // 값1? 15
    // 값2? 30
    // 연산자(+,-,*,/)? *
    // => 15 * 30 = 450
  */

   // 컴퓨터의 가위, 바위, 보 계산하기
   Scanner keyScan = new Scanner(System.in);
    
   System.out.print("가위,바위,보? ");
   String user = keyScan.nextLine();
   System.out.printf("사용자: %s\n", user);

   int random = (int)(Math.random() * 3);
   String computer;
   if (random == 0) 
     computer = "가위";
   else if (random == 1) 
     computer = "바위";
   else 
     computer = "보";
   
   System.out.printf("컴퓨터: %s\n", computer);
   
   if (user.equals("가위")) {
     if (computer.equals("보")) {
       System.out.println("=> 당신이 이겼습니다.");
       return;
     }
   } else if (user.equals("바위")) {
     if (computer.equals("가위")) {
       System.out.println("=> 당신이 이겼습니다.");
       return;
     }
   } else {
     if (computer.equals("바위")) {
       System.out.println("=> 당신이 이겼습니다.");
       return;
     }
   }
   
   System.out.println("=> 당신은 비기거나 졌습니다.");
   
   keyScan.close();

   
  //  가위,바위,보? 가위 
  //  사용자: 가위
  //  컴퓨터: 보
  //  => 당신이 이겼습니다.
  
  }

}
