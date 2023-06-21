package bitcamp.myapp;

public class MinusCalcul extends Calculator{


    public MinusCalcul(int num1, int num2) {
        super(num1, num2);
    }

    @Override
    public int run() {
        return num1-num2;
    }

    @Override
    public int run(int num1, int num2) {
        return num1-num2;
    }

    @Override
    public int run(int num1, int num2, int num3) {
        return num1-num2-num3;

    }
}
