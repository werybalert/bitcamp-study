package main.java.bitcamp.myapp.handler;

import main.java.bitcamp.myapp.vo.Member;
import main.java.bitcamp.util.Prompt;

public class MemberList {

    public class MemberHandler {

        private static final int MAX_SIZE = 100;

        private Prompt prompt;
        private Member[] members = new Member[MAX_SIZE];
        private int length;
        private String title;
}
