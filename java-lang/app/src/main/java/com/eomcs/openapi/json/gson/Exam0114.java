
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

public class Exam0114 {
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


    // 0703 실습
    // 2) JSON 처리 객체 준비
    DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");

    Gson gson = new GsonBuilder().registerTypeAdapter(Data.class, new JsonSerializer<Date>() {

      @Override
      public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(dateformat.format(src));
      }
    }).create();
    // System.out.println(builder == builder2); // true

    // 3) 객체의 값을 JSON 문자열로 얻기
    String jsonStr = gson.toJson(m);
    System.out.println(jsonStr);
  }
}
