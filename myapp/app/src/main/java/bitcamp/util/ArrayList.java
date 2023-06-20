package bitcamp.util;

// 06.19 util로 이동

public class ArrayList implements List {
  private Object[] list = new Object[DeFAULT_SIZE];
  private static final int DeFAULT_SIZE = 3;
  private int length;

  // 컴파일러에게 다음 method가 super class의 method를 재정의한것인지
  // 또는 interface에 method를 구현한 것인지
  // 검사해달라는 표시
  @Override
  public boolean add(Object obj) {
    if (this.length == list.length) {
      increase();
    }
    this.list[this.length++] = obj;
    return true;
  } // add end



  private void increase() {
    Object[] arr = new Object[list.length + (list.length >> 1)];
    for (int i = 0; i < list.length; i++) {
      arr[i] = list[i];
    }
    list = arr;
    // System.out.println("배열 확장: " + list.length);
  } // increase end


  @Override
  public Object[] toArray() {
    Object[] arr = new Object[this.length];

    for (int i = 0; i < this.length; i++) {
      arr[i] = this.list[i];
    }
    return arr;
  }


  @Override
  public Object get(int index) {
    if (!isValid(index)) {
      return null;
    }
    return this.list[index];
  }

  @Override
  public boolean remove(Object obj) {
    int deletedIndex = indexOf(obj);
    if (deletedIndex == -1) {
      return false;
    }
    for (int i = deletedIndex; i < this.length - 1; i++) {
      this.list[i] = this.list[i + 1];
    }
    this.list[--length] = null;
    return true;
  }

  @Override
  public Object remove(int index) {
    if (!isValid(index)) {
      return null;
    }

    Object old = this.list[index];

    for (int i = index; i < this.length - 1; i++) {
      this.list[i] = this.list[i + 1];
    }
    this.list[--length] = null;

    return old;
  }


  private boolean isValid(int index) {
    return index >= 0 && index <= this.length;

    // if (index < 0 || index >= this.length) {
    // return false;
    // }
    // return true;
    // 동일 코드
  }

  // 06.19 실습
  @Override
  public int size() {
    return this.length;
  }


  private int indexOf(Object obj) {
    for (int i = 0; i < this.length; i++) {
      Object item = this.list[i];
      if (item.equals(obj)) {
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
