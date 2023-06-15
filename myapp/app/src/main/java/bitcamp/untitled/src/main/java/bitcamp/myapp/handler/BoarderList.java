package main.java.bitcamp.myapp.handler;

public class BoarderList {

    private static final int DEFAULT_SIZE = 3;
    private Board[] boards = new Board[DEFAULT_SIZE];
    private int length;


    public void add(Board b) {

        increase();

        this.boards[this.length++] = b;
    }

    private void increase() {

        if (this.length == boards.length) {
            Board[] arr = new Board[boards.length + (boards.length >> 1)];
            // (boards.length >> 1)는 boards.length의 비트를 오른쪽으로 1만큼 이동시킨 값을 나타냅니다. 이는 boards.length를 2로 나눈
            // 결과와 같습니다

            // 기존 배열의 값을 새 배열로 복사
            for (int i = 0; i < boards.length; i++) {
                arr[i] = boards[i];
            }
            // boards 레퍼런스가 새 배열을 지목하도록 유도
            boards = arr;
            // System.out.println("배열 확장 :" + boards.length);
        }
    }

    public Board[] list() {
        // 리턴할 값을 담을 배열 생성
        Board[] arr = new Board[this.length];

        // 원본 배열에서 입력된 인스턴스 주소를 꺼내 새 배열에 담음
        for (int i = 0; i < this.length; i++) {
            arr[i] = this.boards[i];
        }
        // 새 배열을 리턴
        return arr;
    }

    public Board get(int no) {
        for (int i = 0; i < this.length; i++) {
            Board b = this.boards[i];
            if (b.getNo() == no) {
                b.setViewCount(b.getViewCount() + 1);
                return b;
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
            this.boards[i] = this.boards[i + 1];
        }
        this.boards[--length] = null;
        return true;
    }



    private int indexOf(int boardNo) {
        for (int i = 0; i < this.length; i++) {
            Board board = this.boards[i];
            if (board.getNo() == boardNo) {
                return i;
            }
        }
        return -1;
    }
}
