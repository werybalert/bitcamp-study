import java.io.*;
import java.util.*;


public class BOJ_2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int result = 0;

        for (int i = 0; i < number; i++) {
            int number = i;
            int sum = i;


            while (number >0){
                sum += number %10;
                number /=10;
            }

            if (number = n){
                result = i;
                break;
            }
        }
        System.out.println(result);

        
    }
}