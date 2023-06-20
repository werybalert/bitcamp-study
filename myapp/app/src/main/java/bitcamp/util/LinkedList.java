package bitcamp.util;


public class LinkedList implements List {

  Node head;
  Node tail;
  int size;

  // -------------------------임시 출력문----------------------------------
  public static void main(String[] args) {
    LinkedList list = new LinkedList();
    list.add(Integer.valueOf(100)); // index : 0
    list.add(Integer.valueOf(200));// index : 1
    list.add(Integer.valueOf(300));// index : 2
    list.add(Integer.valueOf(400));// index : 3
    list.add(Integer.valueOf(500));// index : 4
    /*
     *
     * list.remove(300); // 100, 200, 400, 500,
     *
     * list.remove(400); // 100, 200, 500,
     *
     * list.remove(500); // 300도 포함 100, 200, 400,
     *
     * list.remove(100); list.remove(200); list.remove(400); list.remove(600); // 출력 x
     *
     */

    /*
     *
     * System.out.println(list.remove(Integer.valueOf(100)));
     * System.out.println(list.remove(Integer.valueOf(200)));
     * System.out.println(list.remove(Integer.valueOf(300)));
     * System.out.println(list.remove(Integer.valueOf(400)));
     * System.out.println(list.remove(Integer.valueOf(500)));
     * System.out.println(list.remove(Integer.valueOf(600))); // true // true // true // true //
     * true // false
     *
     */

    System.out.println(list.remove(2));
    System.out.println(list.remove(3)); // 500은 300이 지워짐으로써 index가 한칸 땡겨진다 : index : 4 > 3
    // 100, 200, 400, 1000, 2000,


    System.out.println(list.remove(0));
    System.out.println(list.remove(0));
    System.out.println(list.remove(0));

    list.add(Integer.valueOf(1000));

    print(list);
    // 1000, - 모두 지워지고 1000만 남은걸 확인


  }

  static void print(List list) {
    Object[] arr = list.toArray();
    for (Object obj : arr) {
      System.out.print(obj);
      System.out.print(", ");
    }
    System.out.println();
  }
  // -----------------------------------------------------------

  @Override
  public boolean add(Object value) {
    // 1. 새 node 생성
    Node node = new Node();

    // 2. 새 node 값 저장
    node.value = value;

    if (head == null) { // null이 아니면 최소 한개의 노드는 존재!
      head = node;
    } else if (this.tail != null) {
      // 3. 리스트 마지막 노드에 새 노드 연결
      this.tail.next = node;
    }

    tail = node;
    size++;
    return true;
  }

  @Override
  public Object[] toArray() {
    Object[] arr = new Object[this.size];

    Node cursor = this.head;
    for (int i = 0; i < this.size; i++) {
      arr[i] = cursor.value;
      cursor = cursor.next; // 주소 입력받고 증가
    }

    return arr;
  }

  @Override
  public Object get(int index) {
    if (!isValid(index)) {
      return null;
    }
    Node cursor = this.head;

    for (int i = 0; i < index; i++) {
      cursor = cursor.next;
    }
    return cursor.value;
  }

  @Override
  public boolean remove(Object value) {
    Node cursor = this.head;
    Node prev = null;

    while (cursor != null) {
      if (cursor.value.equals(value)) {

        if (prev == null) {
          // 삭제할 node가 시작이라면
          head = cursor.next; // cusor 다음 head 넘기기

          if (head == null) { // 만약 삭제할 node가 시작 node이자 끝 node일 경우
            tail = null; // cusor와 tail에 둘다 null 값 대입
          }
        } else if (cursor.next == null) { // 삭제할 node가 끝 node일 경우
          tail = prev; // tail의 이전 노드가 prev

          tail.next = null;

        } else {
          prev.next = cursor.next; // 중간 node라면, 다음 노드의 주소를 이전 node에 저장
        }
        size--;

        // 0619 실습
        // garbage 객체를 초기화시켜서 garbage가 instance를 가리키지 않도록 한다.
        // 최근 garbage collector는 자동으로 값을 지정하여 읽히지 않도록 함.
        cursor.next = null;
        cursor.value = null;

        return true;
      }
      // 현재 cursor가 가리키는 node를 prev에 보관
      prev = cursor;

      // 현재 cursor를 다음 node로 이동
      cursor = cursor.next;
    }
    return false;
  }

  @Override
  public Object remove(int index) {

    if (!isValid(index)) {
      return null;
    }

    // 삭제하려는 값이 있는 node까지 이동
    Node cursor = this.head;
    Node prev = null;


    for (int i = 0; i < index; i++) {
      prev = cursor; // 다음 node로 이동하기 전에 현제 cursor가 가리키는 node를 prev에 보관
      cursor = cursor.next; // 커서를 다음 node로 이동한다.
    }

    // 삭제할 값을 return 할수 있도록 보관 필수
    Object old = cursor.value;

    if (prev == null) {
      head = cursor.next;

      if (head == null) {
        tail = null;
      }
    } else if (cursor.next == null) {
      tail = prev;

      tail.next = null;
    } else {
      prev.next = cursor.next; // 현재 cursor의 다음 노드를 현재 cursor의 이전 node와 연결
    }
    size--;
    cursor.next = null;
    cursor.value = null;
    return old;

  }

  @Override
  public int size() {
    return this.size;
  }


  private boolean isValid(int index) {
    return index >= 0 && index <= this.size;
  }



  // 06.19 실습
  // 중첩클래스문
  static class Node {

    Node next;
    Object value;// 이 타입은 자손 객체의 주소를 저장하기에 탁월하다~
  }
}
