/*
* 학교 수업에서 배웠던 알고리즘인데 문제 풀 때 기억이 안 나서 BFS로 접근했다.
* 경우의 수가 너무 커서 시간 초과!
* 접근 방법이 잘 기억이 안 나서 결국 검색을 했다...
* int 자료형으로 했을 땐 오류! -> 90을 넣었을 때 답이 마이너스로 나오는 걸 보고 자료형을 long으로 바꾸어 주었다.
* 가장 큰 경우에 답이 제대로 나오는지 꼭 체크해 보자.
*/

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
