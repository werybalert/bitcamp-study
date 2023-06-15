package bitcamp.myapp.handler;

import bitcamp.myapp2.vo.Member;

public class MemberList {
  private Member[] members = new Member[MAX_SIZE];
  private static final int MAX_SIZE = 3;
  private int length;


  public void add(Member m) {

    increase();

    this.members[this.length++] = m;
    // this.members[this.length++] = m;
    // return true;
  }

  private void increase() {
    if (this.length == members.length) {
      Member[] arr = new Member[members.length + (members.length >> 1)];

      for (int i = 0; i < members.length; i++) {
        arr[i] = members[i];
      }
      members = arr;
      System.out.println("배열이 확장됬당꼐");
    }
  }

  public Member[] list() {
    // 리턴할 값을 담을 배열 생성
    Member[] arr = new Member[this.length];

    // 원본 배열에서 입력된 인스턴스 주소를 꺼내 새 배열에 담음
    for (int i = 0; i < this.length; i++) {
      arr[i] = this.members[i];
    }
    // 새 배열을 리턴
    return arr;
  }

  public Member get(int no) {
    for (int i = 0; i < this.length; i++) {
      Member m = this.members[i];
      if (m.getNo() == no) {
        return m;
      }
    }
    return null;
  }

  public boolean delete(int no) {
    int deletedIndex = indexOf(no);
    if (deletedIndex == -1) {
      return false;
    }
    for (int i = deletedIndex; i < this.length - 1; i++) {
      this.members[i] = this.members[i + 1];
    }
    this.members[--length] = null;
    return true;
  }

  private int indexOf(int memberNo) {
    for (int i = 0; i < this.length; i++) {
      Member m = this.members[i];
      if (m.getNo() == memberNo) {
        return i;
      }
    }
    return -1;
  }

  // 배열 증가로 필요성이 없어짐!
  // private boolean available() {
  // return this.length < MAX_SIZE;
  // }



}
