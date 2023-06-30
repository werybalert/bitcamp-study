package bitcamp.myapp.handler;

// 0615 실습
// 핸들러 사용 규칙! => 즉 메서드 호출 규칙을 정의
// => 메서드 시그너처와 리턴 타입을 정의
// 시그너처(signature) : 메서드 명, 파라미터 목록
// => 메서드 몸체 (method bosy) : 작성 x (호출 규칙만 정의하기 때문)

public interface Handler {
  void execute(); // 기본 public abstract

}
