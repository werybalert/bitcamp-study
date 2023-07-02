import java.io.*;
import java.util.*;
//주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.
public class BOJ_1978 {
    public static void main(String[] args) throws IOException{

        int in;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int mino = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int cnt = 0;

        for (int i=0; i < mino; i++){
            int num = Integer.parseInt(st.nextToken());
            for (int j = 2; j<=num; j++) {
                if ( j == num) {
                    cnt++;
                }
                if (num %j == 0) {
                    break;
                }
            }
        }
        System.out.println(cnt);
    }
}