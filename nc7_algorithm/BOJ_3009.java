import java.io.*;
import java.util.*;

//세 점이 주어졌을 때, 축에 평행한 직사각형을 만들기 위해서 필요한 네 번째 점을 찾는 프로그램을 작성하시오.
public class BOJ_3009 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int[] x = new int[3];
        int[] y = new int[3];

        for (int i=0; i<3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());

        }

        int X = x[0];
        int Y = y[0];

        if (x[0] == x[1]) {
            X = x[2];
        } else if (x[0] == x[2]) {
            X = x[1];
        }

        if (y[0] == y[1]) {
            Y = y[2];
        } else if (y[0] == y[2]) {
            Y = y[1];
        }
        System.out.println(X + " " + Y);
    }
}