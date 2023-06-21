
public class TestMain {

    public static void main(String[] args) {
        Calculator cal1 = new PlusCalcul(100, 200);
        Calculator cal2 = new MinusCalcul(100, 200);

        new TestMain().calRun(cal1);
        new TestMain().calRun(cal2);

        System.out.println("================================");
        new TestMain().calCalRun(cal1);
        new TestMain().calCalRun(cal2);

    }
    private <T extends Calculator> void calRun(T cal) {
        int num1 = 300, num2 = 200, num3 = 100;

        System.out.println("[className] "+cal.getClass().getName());
        System.out.println("Result()");
        System.out.println(cal.getResult());
        System.out.println(cal.getResult(num1, num2));
        System.out.println(cal.getResult(num1, num2, num3));

        System.out.println("run()");
        System.out.println(cal.run());
        System.out.println(cal.run(num1, num2));
        System.out.println(cal.run(num1, num2, num3));
        System.out.println();
        System.out.println();
    }

    private void calCalRun(Calculator cal) {
        int num1 = 300, num2 = 200, num3 = 100;

        if(cal instanceof PlusCalcul) {
            System.out.println("삐용삐용삐용 제발 이렇게 하지마!!!!!!!!!!!");
        }

        System.out.println("[className] "+cal.getClass().getName());
        System.out.println("Result()");
        System.out.println(cal.getResult());
        System.out.println(cal.getResult(num1, num2));
        System.out.println(cal.getResult(num1, num2, num3));

        System.out.println("run()");
        System.out.println(cal.run());
        System.out.println(cal.run(num1, num2));
        System.out.println(cal.run(num1, num2, num3));

        System.out.println();
    }
}
