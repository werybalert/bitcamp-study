package Algo_study;

import java.io.*;
import java.util.*;
public class BOJ_2751 {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] number = new int[N];

        for (int i=0; i <N; i++) {
             number[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(number);

        for (int numbers : number){
            System.out.println(numbers);
        }




    }
}
