
package bitcamp.myapp;

import bitcamp.util.Calculator;

public class Test0605 {
    public static void main(String[] args) {

        Calculator.init(2);
        Calculator.multiple(3);
        Calculator.plus(7);
        Calculator.minus(2);
        Calculator.divide(2);
        System.out.println(Calculator.result);
    }
}