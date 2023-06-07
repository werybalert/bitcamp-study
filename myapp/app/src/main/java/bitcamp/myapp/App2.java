package bitcamp.myapp;

import bitcamp.myapp.prompt.prompt;

import java.util.InputMismatchException;
// 6/5 과제 프로젝트

public class App2 {
//App2 클래스에선 출력할 화면과 에러를 구성했다.

    public static void main(String[] args) {
        playGuessNumberGame.GuessNumGame();
        prompt.scanner.close();
    }

    public static void printRange(int low, int high) {
        System.out.println(low + "-" + high);
    }

    public static int readNumber() {
        while (true) {
            try {
                return prompt.scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("정수만 입력하셔야 합니다!!");
                prompt.scanner.nextLine();
            }
            //try 내부의 코드가 InputMismatchException 을 던진다면, 예외를 받아온다.
            //catch가 실행되는 동안은 Program 이 종료되지 않는다.
        }
    }

    public static boolean playAgain() {
        System.out.print("다시하시겠습니까(y/n)>>");
        String answer = prompt.scanner.next();
        return answer.equalsIgnoreCase("y");
    }

    public static boolean isGuessOutOfRange(int guess, int low, int high) {
        return guess > high || guess < low;
    }

    public static boolean isGuessCorrect(int guess, int card) {
        return guess == card;
    }

    public static boolean isGuessHigher(int guess, int card) {
        return guess > card;
    }


}
