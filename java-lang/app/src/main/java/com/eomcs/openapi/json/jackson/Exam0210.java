// 객체 --> JSON 문자열 : Date 값을 yyyy-MM-dd 형식으로 출력
package com.eomcs.openapi.json.jackson;

import java.sql.Date;
import java.text.SimpleDateFormat;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Exam0210 {
  public static void main(String[] args) throws Exception {

    // 1) 객체 준비
    Member m1 = new Member();
    m1.setNo(101);
    m1.setName("홍길동");
    m1.setEmail("hong@test.com");
    m1.setRegisteredDate(new Date(System.currentTimeMillis()));

    // 2) JSON 처리 객체 준비
    ObjectMapper mapper = new ObjectMapper();

    mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));

    // 3) 객체의 값을 JSON 문자열로 얻기
    String jsonStr = mapper.writeValueAsString(m1);

    System.out.println(jsonStr);
  }
}

