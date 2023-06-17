package Algo_study;

import java.io.*;
import java.util.*;

public class BOJ_2750 {
    public static void main(String[] n) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Set<Integer> number = new HashSet<>(); // 중복 제외 저장

        for (int i = 0; i < N; i++){ // N개의 정수 불러오기
            int num = Integer.parseInt(br.readLine());
            number.add(num); // Hashset 저장
        }

        int[] arr = new int[number.size()];
        int index = 0;
        for (int num : number){
            arr[index++] = num;
        }

        for (int num : arr)
            System.out.println(num);
    }
}
