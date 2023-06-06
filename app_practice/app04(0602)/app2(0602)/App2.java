import java.io.*;
import java.util.StringTokenizer;

public class App2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] arr;
        int sum, count;
        int C = Integer.parseInt(br.readLine());
        for (int i = 0; i < C; i++) {
            sum = 0;
            count = 0;
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            arr = new int[N];
            for (int j = 0; j < N; j++) { //배열 저장
                arr[j] = Integer.parseInt(st.nextToken());
                sum += arr[j];
            }
            for (int j = 0; j < N; j++) {
                if ((float) sum / N < arr[j]) //TYPE CASTING
                    count++;
//                System.out.println( sum / N);
            }
            System.out.printf("%.3f%%\n", ((float) count / N) * 100);
        }
    }
}


//
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    StringTokenizer st;
    int[] arr;
    int testcase = Integer.parseInt(br.readLine());

for(int i = 0 ; i < testcase ; i++) {
        st = new StringTokenizer(br.readLine()," "); // 학생 수 및 성적 입력
        int N = Integer.parseInt(st.nextToken());	//학생 수

        arr = new int[N];

        double sum = 0;	// 성적 누적 합 변수

// 성적 입력부분
        for(int j = 0 ; j < N ; j++) {
        int val = Integer.parseInt(st.nextToken());	// 성적 저장
        arr[j] = val;
        sum += val;	// 성적 누적 합
        }

        double mean = (sum / N) ;
        double count = 0; // 평균 넘는 학생 수 변수

// 평균 넘는 학생 비율 찾기
        for(int j = 0 ; j < N ; j++) {
        if(arr[j] > mean) {
        count++;
        }
        }

        System.out.printf("%.3f%%\n",(count/N)*100);
        }
        }

        }
