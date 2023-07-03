
// 객체 --> JSON 문자열 : 객체의 필드 값을 json 형식의 문자열로 만들기
package com.eomcs.openapi.json.gson;

import java.lang.reflect.Type;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.xml.crypto.Data;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class Exam0112 {
  public static void main(String[] args) {

    // 1) 객체 준비
    Member m = new Member();
    m.setNo(100);
    m.setName("홍길동");
    m.setEmail("hong@test.com");
    m.setPassword("1111");
    m.setPhoto("hong.gif");
    m.setTel("010-2222-1111");
    m.setRegisteredDate(new Date(System.currentTimeMillis()));

    // 2) JSON 처리 객체 준비
    // Date 타입의 값을 내보내고 가져올 떄 사용할 변환 도구를 준비
    class GsonDateFormatAdapter implements JsonSerializer<Date> {
      private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

      @Override
      public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
        // 객체를 JSON 문자열로 변환할떄 호출
        // 그 중 Date 타입의 property 값을 JSON 문자열로 바꿀때 호출
        return new JsonPrimitive(dateFormat.format(src));
      }

    }

    // Gson 객체를 만들어줄 도우미 객체
    GsonBuilder builder = new GsonBuilder();

    // Date 타입의 프로퍼티 값을 JSON 형식의 문자열로 바꿔줄 변환기를 등록
    builder.registerTypeAdapter(Data.class, // 원래 데이터의 타입
        new GsonDateFormatAdapter()// Date형식의 데이터를 JSON 문자열로 바꿔줄 변환기
    );

    Gson gson = builder.create();

    // 3) 객체의 값을 JSON 문자열로 얻기
    String jsonStr = gson.toJson(m);
    System.out.println(jsonStr);
  }
}
