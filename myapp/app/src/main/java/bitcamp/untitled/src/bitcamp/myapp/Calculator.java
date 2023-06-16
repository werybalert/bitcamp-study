package bitcamp.myapp;

public abstract class Calculator implements CalInterface{
    public int num1;
    public int num2;

    public Calculator(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }
    public int getResult() {
        return this.run();
    }
    public int getResult(int num1, int num2) {
        return this.run(num1, num2);
    }
    public int getResult(int num1, int num2, int num3) {
        return this.run(num1, num2, num3);
    }

    protected void setHttpCode(int i) {
    }
}
