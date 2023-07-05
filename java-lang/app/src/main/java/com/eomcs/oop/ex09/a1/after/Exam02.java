// Worker 구현체 사용
package com.eomcs.oop.ex09.a1.after;

public class Exam02 {
  public static void main(String[] args) {
    work(new BlueWorker());
    work(new JubuWorker());
    work(new WhiteWorker());
    // work(new HulWorker()); // HulWorker는 공식적으로 worker 규칙을 따르지 않는다.
    // => 인터 페이스에 선언된 메서드를 갖고있따고 해결될 문제 x
    // 반드시 클래스 선언부에 인터페이스를 구현한다고 표시
  }

  static void work(Worker worker) {
    worker.execute();
  }

}


