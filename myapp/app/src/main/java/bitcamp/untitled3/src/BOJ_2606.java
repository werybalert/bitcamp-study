
import java.io.*;
import java.util.*;

public class BOJ_2606 {

    static boolean[] check;
    static int[][] arr;
    static int count = 0;
    static int node, line;
    static Queue<Integer> queue = new LinkedList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        node = Integer.parseInt(br.readLine());
        line = Integer.parseInt(br.readLine());

        arr = new int[node + 1][node + 1];
        check = new boolean[node + 1];

        for (int i=0; i < line; i++){ // 네트워크 상에서 직접 연결되어 있는 컴퓨터 쌍의 수만큼 반복해야한다!
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = arr[b][a] = 1;
        }

        bfs(1);
        count -=1;
        System.out.println(count);

    }
    public static void bfs(int start) {
        queue.offer(start);
        check[start] = true;
        count++;

        while (!queue.isEmpty()){
            int x = queue.poll();


//            = : 할당
//            == : 비교연산

            for(int i=1; i <= node ; i++) {
                if(arr[x][i] == 1 && !check[i]){
                    queue.offer(i); // 다음 노드로 갈 길을 알림
                    check[i] = true;
                    count++;
                }
            }

        }
    }




}
