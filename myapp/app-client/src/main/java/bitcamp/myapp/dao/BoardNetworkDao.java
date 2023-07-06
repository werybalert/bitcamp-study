package bitcamp.myapp.dao;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.List;
import bitcamp.myapp.vo.Board;
import bitcamp.net.RequestEntity;
import bitcamp.net.ResponseEntity;

public class BoardNetworkDao implements BoardDao {

  String dataName;
  DataInputStream in;
  DataOutputStream out;

  public BoardNetworkDao(String dataName, DataInputStream in, DataOutputStream out) {
    this.dataName = dataName;
    this.in = in;
    this.out = out;
  }

  @Override
  public void insert(Board board) {
    try {
      // Map 객체에 담은 정보를 JSON 문자열로 변환하여 서버에 전송
      out.writeUTF(new RequestEntity().command(dataName + "/insert").data(board).toJson());

      // 서버에 보낼 명령과 데이터를 Map 객체에 담는다.
      // HashMap<String,Object> request = new HashMap<>();
      // request.put("command", dataName + "/insert");
      // request.put("data", gson.toJson(board));

      // 혼합 코드
      // RequestEntity request = new RequestEntity().command(dataName + "/insert").data(board); 담기
      // Gson gson = new Gson();


      // 서버에서 보낸 응답을 받는다.
      ResponseEntity response = ResponseEntity.fromJson(in.readUTF());

      if (response.getStatus().equals(ResponseEntity.ERROR)) {
        throw new RuntimeException(response.getResult());
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public List<Board> list() {
    try {
      out.writeUTF(new RequestEntity().command(dataName + "/list").toJson());

      ResponseEntity response = ResponseEntity.fromJson(in.readUTF());
      if (response.getStatus().equals(ResponseEntity.FAILURE)) {
        throw new RuntimeException(response.getResult());
      }

      return response.getList(Board.class);

    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }



  // @Override
  // public List<Board> list() {
  // try {
  // // 명령을 실행할 떄 사용할 데이터 전송
  // Gson gson = new Gson();
  //
  // // 서버에 보낼 명령과 데이터를 Map 객체에 담는다
  // HashMap<String, Object> request = new HashMap<>();
  // request.put("command", dataName + "/list");
  //
  // out.writeUTF(new RequestEntity().command(dataName + "/list").toJson());
  //
  // Map<String, Object> response = ResponseEntity.fromJson(in.readUTF());
  // if (response.getStatus().equals(ResponseEntity.FAILURE)) {
  // throw new RuntimeException(response.getResult());
  // }
  //
  // return response.getList(Board.class);
  //
  // } catch (Exception e) {
  // System.out.println(e.getMessage());
  // e.printStackTrace();
  // }
  // return null;
  // }

  @Override
  public Board findBy(int no) {
    try {
      out.writeUTF(new RequestEntity().command(dataName + "/findBy").data(no).toJson());

      ResponseEntity response = ResponseEntity.fromJson(in.readUTF());

      if (response.getStatus().equals(ResponseEntity.ERROR)) {
        throw new RuntimeException(response.getResult());
      } else if (response.getStatus().equals(ResponseEntity.FAILURE)) {
        return null;
      }

      return response.getObject(Board.class);

    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public int update(Board board) {
    try {
      out.writeUTF(new RequestEntity().command(dataName + "/update").data(board).toJson());
      ResponseEntity response = ResponseEntity.fromJson(in.readUTF());
      if (response.getStatus().equals(ResponseEntity.ERROR)) {
        throw new RuntimeException(response.getResult());
      } else if (response.getStatus().equals(ResponseEntity.FAILURE)) {
        return 0;
      }
      return response.getObject(Integer.class);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }


  @Override
  public int delete(int no) {
    try {
      out.writeUTF(new RequestEntity().command(dataName + "/delete").data(no).toJson());

      ResponseEntity response = ResponseEntity.fromJson(in.readUTF());

      if (response.getStatus().equals(ResponseEntity.ERROR)) {
        throw new RuntimeException(response.getResult());
      } else if (response.getStatus().equals(ResponseEntity.FAILURE)) {
        return 0;
      }

      return response.getObject(Integer.class);

    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }


}
