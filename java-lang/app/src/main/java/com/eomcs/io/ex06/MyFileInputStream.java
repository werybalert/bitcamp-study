package com.eomcs.io.ex06;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MyFileInputStream extends FileInputStream {

  byte[] buf = new byte[8192]; // 8KB
  int length; // 버퍼에 저장한 바이트 수
  int pos; // 읽을 바이트의 인덱스

  public MyFileInputStream(String name) throws FileNotFoundException {
    super(name);
  }

  @Override
  public int read() throws IOException {
    if (pos == length) { // 버퍼의 데이터를 다 읽었다면,
      length = this.read(buf); // 버퍼 크기만큼 파일에서 데이터를 읽기.

      if (length == -1) {
        return -1;
      }

      pos = 0; // 버퍼 시작부터 읽을수 있도록 위치를 0으로 설정
      System.out.println(length + "바이트 읽었음!");
    }
    return buf[pos++] & 0x000000ff;
  }

}


/*
 * @Override public int read() throws IOException { if (size == -1 || cursor == size) { // 바이트 배열에
 * 저장되어 있는 데이터를 모두 읽었다면, if ((size = super.read(buf)) == -1) { // 다시 파일에서 바이트 배열로 데이터를 왕창 읽어 온다.
 * return -1; } readCount++; System.out.printf("==>버퍼로 왕창 읽었음! - %d 번째\n", readCount); cursor = 0; }
 * 
 * return buf[cursor++] & 0x000000ff;
 * 
 * // 위의 리턴 문장은 컴파일 할 때 아래의 문장으로 바뀐다. // int temp; // temp = buf[cursor]; // cursor++; // return
 * temp & 0x000000ff;
 * 
 * }
 * 
 */

