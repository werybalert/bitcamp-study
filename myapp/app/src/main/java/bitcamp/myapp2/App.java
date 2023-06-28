package bitcamp.myapp2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import bitcamp.io.DataInputStream;
import bitcamp.io.DataOutputStream;
import bitcamp.myapp2.handler.BoardAddListener;
import bitcamp.myapp2.handler.BoardDeleteListener;
import bitcamp.myapp2.handler.BoardDetailListener;
import bitcamp.myapp2.handler.BoardListListener;
import bitcamp.myapp2.handler.BoardUpdateListener;
import bitcamp.myapp2.handler.FooterListener;
import bitcamp.myapp2.handler.HeaderListener;
import bitcamp.myapp2.handler.HelloListener;
import bitcamp.myapp2.handler.MemberAddListener;
import bitcamp.myapp2.handler.MemberDeleteListener;
import bitcamp.myapp2.handler.MemberDetailListener;
import bitcamp.myapp2.handler.MemberListListener;
import bitcamp.myapp2.handler.MemberUpdateListener;
import bitcamp.myapp2.vo.Board;
import bitcamp.myapp2.vo.Member;
import bitcamp.util.BreadcrumbPrompt;
import bitcamp.util.Menu;
import bitcamp.util.MenuGroup;

public class App {

  ArrayList<Member> memberList = new ArrayList<>();
  LinkedList<Board> boardList = new LinkedList<>();
  LinkedList<Board> readingList = new LinkedList<>();

  BreadcrumbPrompt prompt = new BreadcrumbPrompt();

  MenuGroup mainMenu = new MenuGroup("메인");

  public App() {
    prepareMenu();
  }

  public static void main(String[] args) {
    new App().execute();
  }

  static void printTitle() {
    System.out.println("나의 목록 관리 시스템");
    System.out.println("----------------------------------");
  }

  public void execute() {
    printTitle();

    loadData();
    mainMenu.execute(prompt);
    saveData();

    prompt.close();
  }

  private void loadData() {
    loadMember();
    loadBoard("board.data", boardList);
    loadBoard("reading.data", readingList);
  }

  private void saveData() {
    saveMember();
    saveBoard("board.data", boardList);
    saveBoard("reading.data", readingList);
  }

  private void prepareMenu() {
    MenuGroup memberMenu = new MenuGroup("회원");
    memberMenu.add(new Menu("등록", new MemberAddListener(memberList)));
    memberMenu.add(new Menu("목록", new MemberListListener(memberList)));
    memberMenu.add(new Menu("조회", new MemberDetailListener(memberList)));
    memberMenu.add(new Menu("변경", new MemberUpdateListener(memberList)));
    memberMenu.add(new Menu("삭제", new MemberDeleteListener(memberList)));
    mainMenu.add(memberMenu);

    MenuGroup boardMenu = new MenuGroup("게시글");
    boardMenu.add(new Menu("등록", new BoardAddListener(boardList)));
    boardMenu.add(new Menu("목록", new BoardListListener(boardList)));
    boardMenu.add(new Menu("조회", new BoardDetailListener(boardList)));
    boardMenu.add(new Menu("변경", new BoardUpdateListener(boardList)));
    boardMenu.add(new Menu("삭제", new BoardDeleteListener(boardList)));
    mainMenu.add(boardMenu);

    MenuGroup readingMenu = new MenuGroup("독서록");
    readingMenu.add(new Menu("등록", new BoardAddListener(readingList)));
    readingMenu.add(new Menu("목록", new BoardListListener(readingList)));
    readingMenu.add(new Menu("조회", new BoardDetailListener(readingList)));
    readingMenu.add(new Menu("변경", new BoardUpdateListener(readingList)));
    readingMenu.add(new Menu("삭제", new BoardDeleteListener(readingList)));
    mainMenu.add(readingMenu);

    Menu helloMenu = new Menu("안녕!");
    helloMenu.addActionListener(new HeaderListener());
    helloMenu.addActionListener(new HelloListener());
    helloMenu.addActionListener(new FooterListener());
    mainMenu.add(helloMenu);
  }

  private void loadMember() {
    try {
      DataInputStream in = new DataInputStream("member.data");

      int size = in.readShort();

      // int size = in.read() << 8;
      // size |= in.read();
      //
      // byte[] buf = new byte[1000];

      for (int i = 0; i < size; i++) {
        Member member = new Member();
        member.setNo(in.readInt());
        member.setName(in.readUTF());
        member.setEmail(in.readUTF());
        member.setPassword(in.readUTF());
        member.setGender(in.readChar());
        memberList.add(member);



        // member.setNo(in.read() << 24 | in.read() << 16 | in.read() << 8 | in.read());
        //
        // int length = in.read() << 8 | in.read();
        // in.read(buf, 0, length);
        // member.setName(new String(buf, 0, length, "UTF-8"));
        //
        // length = in.read() << 8 | in.read();
        // in.read(buf, 0, length);
        // member.setEmail(new String(buf, 0, length, "UTF-8"));
        //
        // length = in.read() << 8 | in.read();
        // in.read(buf, 0, length);
        // member.setPassword(new String(buf, 0, length, "UTF-8"));
        //
        // member.setGender((char) (in.read() << 8 | in.read()));
        //
        // memberList.add(member);
        // Member.userId = member.getNo() + 1;
      }

      // 데이터를 로딩한 이후에 추가할 회원의 번호를 설정한다.
      Member.userId = memberList.get(memberList.size() - 1).getNo() + 1;

      in.close();

    } catch (Exception e) {
      System.out.println("회원 정보를 읽는 중 오류 발생!");
    }
  }

  private void loadBoard(String filename, List<Board> list) {
    try {
      DataInputStream in = new DataInputStream(filename);
      int size = in.readShort();

//      byte[] buf = new byte[1000];

      for (int i = 0; i < size; i++) {
        Board board = new Board();
        board.setNo(in.readInt());
        board.setTitle(in.readUTF());
        board.setContent(in.readUTF());
        board.setWriter(in.readUTF());
        board.setPassword(in.readUTF());
        board.setViewCount(i);
        board.setCreatedDate(size);
        list.add(board);

        /*
         * board.setNo(in.read() << 24 | in.read() << 16 | in.read() << 8 | in.read());
         *
         * int length = in.read() << 8 | in.read(); in.read(buf, 0, length); board.setTitle(new
         * String(buf, 0, length, "UTF-8"));
         *
         * length = in.read() << 8 | in.read(); in.read(buf, 0, length); board.setContent(new
         * String(buf, 0, length, "UTF-8"));
         *
         * length = in.read() << 8 | in.read(); in.read(buf, 0, length); board.setWriter(new
         * String(buf, 0, length, "UTF-8"));
         *
         * length = in.read() << 8 | in.read(); in.read(buf, 0, length); board.setPassword(new
         * String(buf, 0, length, "UTF-8"));
         *
         * board.setViewCount(in.read() << 24 | in.read() << 16 | in.read() << 8 | in.read());
         *
         * board.setCreatedDate((long) in.read() << 56 | (long) in.read() << 48 | (long) in.read()
         * << 40 | (long) in.read() << 32 | (long) in.read() << 24 | (long) in.read() << 16 | (long)
         * in.read() << 8 | in.read());
         *
         * list.add(board);
         *
         *
         *
         */
      }

      Board.boardNo = Math.max(Board.boardNo, list.get(list.size() - 1).getNo() + 1);

      in.close();

    } catch (Exception e) {
      System.out.println(filename + " 파일을 읽는 중 오류 발생!");
    }
  }

  private void saveMember() {
    try {
      DataOutputStream out = new DataOutputStream("member.data");

      // 저장할 데이터의 개수를 먼저 출력한다.
      out.writeShort(memberList.size());

      // 본 코드를 간략화 하기(DataOUtputstream 생성 후)
      // int size = memberList.size();
      // out.writeShort(size >> 8);



      for (Member member : memberList) {
        out.writeInt(member.getNo());
        out.writeUTF(member.getName());
        out.writeUTF(member.getEmail());
        out.writeUTF(member.getPassword());
        out.writeChar(member.getGender());

        /*
         * writeUTF 생성
         *
         * byte[] bytes = member.getName().getBytes("UTF-8"); // 출력할 바이트의 개수를 2바이트로 표시한다.
         * out.write(bytes.length >> 8); out.write(bytes.length);
         *
         * // 문자열의 바이트를 출력한다. out.write(bytes);
         *
         *
         * bytes = member.getEmail().getBytes("UTF-8"); out.write(bytes.length >> 8);
         * out.write(bytes.length); out.write(bytes);
         *
         * bytes = member.getPassword().getBytes("UTF-8"); out.write(bytes.length >> 8);
         * out.write(bytes.length); out.write(bytes);
         *
         *
         * char gender = member.getGender(); out.write(gender >> 8); out.write(gender);
         */
      }
      out.close();

    } catch (Exception e) {
      System.out.println("회원 정보를 저장하는 중 오류 발생!");
    }
  }

  private void saveBoard(String filename, List<Board> list) {
    try {
      DataOutputStream out = new DataOutputStream(filename);

      // 저장할 데이터의 개수를 먼저 출력한다.
      out.writeShort(list.size());


      for (Board board : list) {
        out.writeInt(board.getNo());
        out.writeUTF(board.getTitle());
        out.writeUTF(board.getContent());
        out.writeUTF(board.getWriter());
        out.writeUTF(board.getPassword());
        out.writeInt(board.getViewCount());
        out.writeLong(board.getCreatedDate());


        /*
         *
         * byte[] bytes = board.getTitle().getBytes("UTF-8"); out.write(bytes.length >> 8);
         * out.write(bytes.length); out.write(bytes);
         *
         *
         * bytes = board.getContent().getBytes("UTF-8"); out.write(bytes.length >> 8);
         * out.write(bytes.length); out.write(bytes);
         *
         * bytes = board.getWriter().getBytes("UTF-8"); out.write(bytes.length >> 8);
         * out.write(bytes.length); out.write(bytes);
         *
         * bytes = board.getPassword().getBytes("UTF-8"); out.write(bytes.length >> 8);
         * out.write(bytes.length); out.write(bytes);
         *
         * int viewCount = board.getViewCount(); out.write(viewCount >> 24); out.write(viewCount >>
         * 16); out.write(viewCount >> 8); out.write(viewCount);
         *
         * long createdDate = board.getCreatedDate(); out.write((int) (createdDate >> 56));
         * out.write((int) (createdDate >> 48)); out.write((int) (createdDate >> 40));
         * out.write((int) (createdDate >> 32)); out.write((int) (createdDate >> 24));
         * out.write((int) (createdDate >> 16)); out.write((int) (createdDate >> 8));
         * out.write((int) createdDate);
         */
      }
      out.close();

    } catch (Exception e) {
      System.out.println(filename + " 파일을 저장하는 중 오류 발생!");
    }
  }
}
