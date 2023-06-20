package bitcamp.util; // util 밑에다 class 생성하시오

public class Stack extends LinkedList {

  public static void main(String[] args) {
    Stack s = new Stack();
    s.push("홍길동");
    s.push("임꺽정");
    s.push("유관순");
    s.push("안중근");
    s.push("윤봉길");


    System.out.println(s.pop());
    System.out.println(s.pop());
    System.out.println(s.pop());
    System.out.println(s.pop());
    System.out.println(s.pop());

    System.out.println(s.pop());

    // 윤봉길
    // 안중근
    // 유관순
    // 임꺽정
    // 홍길동
    // null


  }

  public void push(Object value) {

    // 목록 맨 끝에 추가
    // 따로 생성 필요 x
    // super class에 있는 method를 이용하여 기능 구현

    this.add(value); // 상속받은 method = sub class에서 사용할 수 있는 super class의 method
  }

  public Object pop() {
    // 목록 맨 끝에 추가
    if (this.empty()) {
      return null;
    }
    return this.remove(this.size() - 1); // -1하는 이유는 마지막껄 꺼낸다
  }

  public Object peek() {
    if (this.empty()) {
      return null;
    }
    return this.get(this.size() - 1); // -1하는 이유는 마지막껄 꺼낸다

  }

  public boolean empty() {
    return this.size() == 0;
  }

}
