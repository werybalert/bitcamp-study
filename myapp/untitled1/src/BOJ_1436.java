import java.io.*;
import java.util.*;

public class BOJ_1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt((br.readLine()));

        int count = 1;
        int num = 666;

        while (count != N){
            num++;
            if ( String.valueOf(num).contains("666")){
                count++;
            }
        }
        System.out.println(num);
    }
}
