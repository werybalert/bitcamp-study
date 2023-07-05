package bitcamp.myapp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import com.google.gson.Gson;
import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.dao.BoardListDao;
import bitcamp.myapp.dao.MemberDao;
import bitcamp.myapp.dao.MemberListDao;

public class ServerApp {

  int port;
  ServerSocket serverSocket;


  MemberDao memberDao = new MemberListDao("member.json");
  BoardDao boardDao = new BoardListDao("board.json");
  BoardDao readingDao = new BoardListDao("reading.json");


  public ServerApp(int port) throws Exception {
    this.port = port;
  }

  public void close() throws Exception {
    serverSocket.close();
  }

  public static void main(String[] args) throws Exception {
    if (args.length < 1) {
      System.out.println("실행 예) java -cp bin/main bitcamp.myapp.ServerApp 포트번호");
      return;
    }

    ServerApp app = new ServerApp(Integer.parseInt(args[0]));
    app.execute();
    app.close();
  }


  public void execute() throws Exception {
    System.out.println("[MyList 서버 애플리케이션]");

    this.serverSocket = new ServerSocket(port);
    System.out.println("서버 실행 중...");

    Socket socket = serverSocket.accept();
    DataOutputStream out = new DataOutputStream(socket.getOutputStream());
    DataInputStream in = new DataInputStream(socket.getInputStream());


    Gson gson = new Gson();
    while (true) {
      String command = in.readUTF();
      if (command.equals("quit")) {
        break;
      }

      System.out.println(command);

      HashMap<String, String> response = new HashMap<>();
      response.put("status", "failure");
      response.put("message", "nop");

      out.writeUTF(gson.toJson(response));
    }

    in.close();
    out.close();
    socket.close();
  }
}
