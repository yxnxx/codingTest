import java.util.*;
import java.io.*;

class Main {

    static int[] mat;
    static int cnt;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        mat = new int[N];

        for(int i = 0; i < N; i++) {
            mat[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(mat);
        cnt = 0;
        countNum(0, N - 1);

        System.out.println(cnt);
    }

    static void countNum(int start, int end) {
        if(start >= end) return;
        if(mat[start] + mat[end] == M) {
            cnt++;
            countNum(start + 1, end - 1);
        }
        else if(mat[start] + mat[end] > M) {
            countNum(start, end - 1);
        }
        else {
            countNum(start + 1, end);
        }
    }
}