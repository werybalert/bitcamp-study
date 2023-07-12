package bitcamp.test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// static Pattern pattern = Pattern.compile("[0-9]+|\\p{Punct}");

// Pattern.compile("[0-9]+|\\p{Punct}")는 두 개의 패턴을 포함하고 있습니다. 첫 번째 패턴인 [0-9]+은 이전과 동일하게 숫자로 이루어진
// 문자열을 매칭합니다. 두 번째 패턴인 \\p{Punct}는 \p{Punct}라는 특수한 정규 표현식 패턴을 사용하며, 이는 구두점 문자를 의미합니다.
//
// \\p{Punct}는 \p 접두사를 사용하여 Unicode 문자 클래스를 참조하는 것을 의미합니다. {Punct}는 Unicode 표준에서 정의된 구두점 문자 클래스를
// 나타냅니다. 이렇게 정의된 구두점 문자 클래스에는 마침표, 쉼표, 느낌표, 물음표, 따옴표 등과 같은 일반적인 구두점 문자들이 포함됩니다.
//
// 이렇게 확장된 패턴을 사용하여 매칭 작업을 수행하면,
// 숫자로 이루어진 문자열 또는 구두점 문자로 이루어진 문자열에 대해 매칭 여부를 확인할 수 있습니다.

// stateful 방식으로 통신하기
public class CalcClient1 {
  static Pattern pattern = Pattern.compile("[0-9]+|\\p{Punct}");

  public static void main(String[] args) {

    try (Socket socket = new Socket("localhost", 8888);
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        DataInputStream in = new DataInputStream(socket.getInputStream());
        Scanner keyscan = new Scanner(System.in);) {

      while (true) {
        System.out.print("계산식(예: +3) >");
        String input = keyscan.nextLine();
        if (input.equals("quit")) {
          out.writeUTF("quit");
          break;
        }

        try {
          Expression expr = parseExpression(input);

          out.writeUTF(expr.op);
          out.writeInt(expr.value);

          String result = in.readUTF();
          System.out.printf("결과 : %s\n", result);

        } catch (ExpressionParseException e) {
          System.out.println(e.getMessage());
        }
      }

    } catch (Exception e) {
      System.out.println("서버 통신 오류!");
    }
  }

  public static Expression parseExpression(String expr) throws ExpressionParseException {
    try {
      Matcher matcher = pattern.matcher(expr);

      ArrayList<String> values = new ArrayList<>();
      while (matcher.find()) {
        values.add(matcher.group());
      }

      if (values.size() != 2) {
        throw new Exception("계산식이 옳지 않습니다!");
      }

      Expression obj = new Expression();
      obj.op = values.get(0);
      obj.value = Integer.parseInt(values.get(1));

      return obj;

    } catch (Exception e) {
      throw new ExpressionParseException(e);
    }
  }

  // 중첩클래스
  static class Expression {
    String op;
    int value;

  }
}


