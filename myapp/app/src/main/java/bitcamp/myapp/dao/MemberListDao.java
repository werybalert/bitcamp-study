package bitcamp.myapp.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import bitcamp.myapp.vo.AutoIncrement;
import bitcamp.myapp.vo.Member;

public class MemberListDao implements MemberDao {

  ArrayList<Member> list = new ArrayList<>();
  String filename;

  public MemberListDao(String filename) {
    this.filename = filename;
    loadJson(list, Member.class);
  }

  @Override
  public void insert(Member member) {

    // 데이터 입력 시 해당 데이터의 식별 번호는 DAO에서 관리!
    member.setNo(Member.userId++);

    this.list.add(member);

    // 데이터를 등록할떄 마다 즉시 파일에 저장!
    saveJson(list);

  }

  private <T> void loadJson(List<T> list, Class<T> clazz) {
    try {
      FileReader in0 = new FileReader(filename);
      BufferedReader in = new BufferedReader(in0); // <== Decorator 역할을 수행!

      StringBuilder strBuilder = new StringBuilder();
      String line = null;

      while ((line = in.readLine()) != null) {
        strBuilder.append(line);
      }

      in.close();

      Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
      Collection<T> objects = gson.fromJson(strBuilder.toString(),
          TypeToken.getParameterized(Collection.class, clazz).getType());

      list.addAll(objects);

      Class<?>[] interfaces = clazz.getInterfaces();
      for (Class<?> info : interfaces) {
        if (info == AutoIncrement.class) {
          AutoIncrement autoIncrement = (AutoIncrement) list.get(list.size() - 1);
          autoIncrement.updateKey();
          break;
        }
      }

    } catch (Exception e) {
      System.out.println(filename + " 파일을 읽는 중 오류 발생!");
    }
  }

  private void saveJson(List<?> list) {
    try {
      FileWriter out0 = new FileWriter(filename);
      BufferedWriter out = new BufferedWriter(out0);

      Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").setPrettyPrinting().create();
      out.write(gson.toJson(list));

      out.close();

    } catch (Exception e) {
      System.out.println(filename + " 파일을 저장하는 중 오류 발생!");
    }
  }

  @Override
  public List<Member> list()   {
    return this.list();
  }



}
