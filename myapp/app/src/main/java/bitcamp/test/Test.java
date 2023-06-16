package bitcamp.test;

public class Test {

  public static void main(String[] args) {
    /*
     * Calculator c1 = new Calculator(); int result = c1.plus(100, 200); System.out.println(result);
     * //300
     */

    Calculator c = new Calculator2();
    // 주어진 코드는 다형성의 개념
    // Calculator라는 클래스가 존재, Calculator2는 Calculator 클래스를 상속받은 서브클래스
    // 다형성은 하나의 클래스 타입으로 다양한 타입의 객체를 참조할 수 있는 능력
    // 이 코드에서 Calculator 타입의 변수 c를 선언하고 new Calculator2()를 통해 Calculator2의 객체를 생성하여 할당
    // 이는 다형성의 예시입니다. Calculator2는 Calculator 클래스를 상속받았기 때문에 Calculator2 객체는
    // Calculator 타입으로 간주될 수 있습니다.
    // 따라서 c는 Calculator2 객체를 참조할 수 있지만, 실제로 Calculator2의 특성과 메서드를 사용할 수 있습니다.

    // Calculator2 c2 = null;
    // Exception in thread "main" java.lang.NullPointerException:
    // Cannot invoke "bitcamp.test.Calculator2.minus(int, int)" because "c2" is null


    // Calculator c = new Calculator();
    // Exception in thread "main" java.lang.ClassCastException: class bitcamp.test.Calculator cannot
    // be cast to class bitcamp.test.Calculator2 (bitcamp.test.Calculator and
    // bitcamp.test.Calculator2 are in unnamed module of loader 'app')
    // at bitcamp.test.Test.main(Test.java:27)


    Calculator2 c2 = (Calculator2) c;
    // 객체의 타입 변환을 수행하는 코드
    // (Calculator2) c는 c 변수의 참조 타입을 Calculator2로 강제로 변환하는 것을 의미
    // 앞서 설명한 것처럼, c 변수는 Calculator 타입으로 선언되었지만, 실제로는 Calculator2 객체를 참조하고 있습니다.

    // 따라서 c 변수를 Calculator2 타입으로 변환하여 Calculator2 객체에 접근하고자 할 때, 타입 캐스팅을 사용해야 합니다.
    // 타입 캐스팅은 상속 관계에 있는 클래스 간에만 가능하며, 해당 클래스의 객체가 실제로 캐스팅하려는 타입과 호환될 때만
    // 성공적으로 수행됩니다.

    // 따라서 (Calculator2) c의 경우, c가 실제로 Calculator2 객체를 참조하고 있으므로 타입 캐스팅은 성공적으로 이루어집니다.

    // 이후에 Calculator2 c2 = (Calculator2) c; 코드를 통해 c 변수를 Calculator2 타입의 c2 변수에 할당
    // c2를 통해 Calculator2 객체의 특성과 메서드에 접근할 수 있습니다.


    System.out.println((((Calculator2) c).minus(100, 200)));
    // 같은 의미
    // System.out.println(c2.minus(100, 200));


    System.out.println(c.plus(100, 200));
    // extend 후 정상 작동
    // -100
    // 300

  }

}
