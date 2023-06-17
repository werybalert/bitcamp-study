
package bitcamp.myapp;


import java.util.Scanner;

public class App {
  
  public static void main(String[] args) {

    System.out.println("랜덤으로 값을 맞추는 게임");
    System.out.println("----------------------------------");    
    
    Scanner scanner = new Scanner(System.in);
    
    System.out.println("1. 게임 시작 > 이름 성별 입력");
    
    System.out.print("번호? ");
    int no = scanner.nextInt();
    
    System.out.printf("이름: ");
    String name = scanner.next();    
    
    System.out.printf("성별(남자(M), 여자(W)): ");
    String str = scanner.next();
    char gender = str.charAt(0);

    System.out.println("---------------------------------------");

    System.out.printf("번호: %d\n", no);
    System.out.printf("이름: %s\n", name);
    System.out.printf("성별(남자(M), 여자(W)): %c\n", gender);

    scanner.close();
    
    
  }
}
