package Algo_study;

import java.io.*;
import java.util.*;

public class BOJ_1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];

        Set<String> wordy = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            wordy.add(word);
        }

        // Set을 배열로 변환
        String[] words = wordy.toArray(new String[0]);

        // 정렬
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() != s2.length()) {
                    return s1.length() - s2.length();
                } else {
                    return s1.compareTo(s2);
                }
            }
        });

        // 출력
        for (String word : words) {
            System.out.println(word);
        }
    }
}





