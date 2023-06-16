package bitcamp.myapp;

public class PlusCalcul extends Calculator{

    public PlusCalcul(int num1, int num2) {
        super(num1, num2);
    }

    @Override
    public int run() {
        return num2+num1;
    }

    @Override
    public int run(int num1, int num2) {
        return num2+num1;
    }

    @Override
    public int run(int num1, int num2, int num3) {
        return num1+num2+num3;
    }
}
