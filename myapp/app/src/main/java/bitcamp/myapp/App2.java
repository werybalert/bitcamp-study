import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;

public class App2 {

    private static Random random = new Random();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        playGuessNumberGame();
        scanner.close();
    }

    public static void playGuessNumberGame() {
        while (true) {
            int low = 0; // 카드 값의 최소 범위
            int high = 99; // 카드 값의 최대 범위
            int card = generateRandomNumber(); // 카드에 적힌 번호 값(숨기는 값, 정답)
            System.out.println("Up & Down 게임입니다. 숨겨진 수를 맞추어 보세요");

            int attempts = 0; // 사용자의 시행 횟수
            while (true) {
                printRange(low, high); // 값의 범위 출력
                System.out.print(attempts + 1 + ">>"); // 시행 횟수 출력

                int guess = readNumber(); // 수를 입력받는다.

                if (isGuessOutOfRange(guess, low, high)) {
                    System.out.println("범위를 벗어났어요");
                } else {
                    if (isGuessCorrect(guess, card)) {
                        System.out.println("맞았습니다.");
                        break;
                    } else if (isGuessHigher(guess, card)) {
                        System.out.println("더 낮게");
                        high = guess;
                    } else {
                        System.out.println("더 높게");
                        low = guess;
                    }
                }
                attempts++;
            }

            if (!playAgain()) {
                break;
            }
        }
    }

    public static int generateRandomNumber() {
        return random.nextInt(100);
    }

    public static void printRange(int low, int high) {
        System.out.println(low + "-" + high);
    }

    public static int readNumber() {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("정수만 입력하셔야 합니다!!");
                scanner.nextLine();
            }
        }
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

    public static boolean playAgain() {
        System.out.print("다시하시겠습니까(y/n)>>");
        String answer = scanner.next();
        return answer.equalsIgnoreCase("y");
    }
}
