package bitcamp.myapp;

import bitcamp.myapp.prompt.prompt;

import static bitcamp.myapp.App2.printRange;

public class playGuessNumberGame {
    public static void main(String[] args) {
// playGuessNumberGame클래스에선 게임에 필요한 환경을 구성했다.
    }

    public static void GuessNumGame() {

        while (true) {
            int low = 0; // 카드 값의 최소 범위
            int high = 99; // 카드 값의 최대 범위
            int card = prompt.RandomNumber(); // 카드에 적힌 번호 값(숨기는 값, 정답)
            System.out.println("Up & Down 게임입니다. 숨겨진 수를 맞추어 보세요");

            int attempts = 0; // 사용자의 시행 횟수
            while (true) {
                printRange(low, high); // 값의 범위 출력
                System.out.print(attempts + 1 + ">>"); // 시행 횟수 출력

                int guess = App2.readNumber(); // 수를 입력받는다.

                if (App2.isGuessOutOfRange(guess, low, high)) {
                    System.out.println("범위를 벗어났어요");
                    //만약 입력된 수가 범위를 벗어났다면 "범위를 벗어났어요" 메시지를 출력합니다.
                } else {
                    if (App2.isGuessCorrect(guess, card)) {
                        System.out.println("맞았습니다.");
                        break;
                    } else if (App2.isGuessHigher(guess, card)) {
                        System.out.println("더 낮게");
                        high = guess;
                    } else {
                        System.out.println("더 높게");
                        low = guess;
                    }
                }
                attempts++;
            }

            if (!App2.playAgain()) {
                break;
            }
        }
    }

}
