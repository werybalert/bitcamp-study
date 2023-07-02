import java.io.*;
import java.util.*;

public class BOJ_10798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] letters = new char[5][15];
        int max = 0;

        for (int i =0; i < letters.length; i++) {
            String line = br.readLine();
            if (max < line.length())
                max = line.length();
            for (int j=0; j<line.length(); j++) {
                letters[i][j] = line.charAt(j);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < 5 ; j++) {
                if (letters[i][j] =='\0')
                    continue;
                sb.append(letters[i][j]);
            }
        }
        System.out.println(sb);
    }
}