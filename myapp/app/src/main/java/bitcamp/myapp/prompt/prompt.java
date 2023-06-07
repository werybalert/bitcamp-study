package bitcamp.myapp.prompt;

import java.util.Random;
import java.util.Scanner;


public class prompt {
    public static Random random = new Random();
    public static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {


    }

    public static int RandomNumber() {
        return random.nextInt(100);
    }

}