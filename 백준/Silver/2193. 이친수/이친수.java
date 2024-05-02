import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if(N < 2) {
            System.out.println(1);
            return;
        }

        long[] count = new long[N];
        count[0] = 1;
        count[1] = 1;

        for(int i = 2; i < N; i++) {
            count[i] = count[i-1] + count[i-2];
        }

        System.out.println(count[N-1]);
    }
}