/*
* 나는 일별로 처리하게 되는 토마토를 큐에 담고, 해당 토마토에 대한 처리가 끝나면 BFS 함수를 다시 호출하는 식으로 구현
* 그러나 토마토 위치와 date 정보까지 담은 클래스를 만들거나, 이차원 배열 자체에 date 정보를 담아서 구현할 수 있었음!
*/

import java.util.*;
import java.io.*;

class Main {
    public static class Pair {
        int n;
        int m;
        Pair(int n, int m) {
            this.n = n;
            this.m = m;
        }
    }

    static int[] dn = {0, 0, 1, -1};
    static int[] dm = {1, -1, 0, 0};

    static int[][] tomato;

    static int N;
    static int M;

    static int date;
    static int box;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        tomato = new int[N][M];
        Queue<Pair> q = new LinkedList<>();
        int tomatoNum = N * M;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                tomato[i][j] = Integer.parseInt(st.nextToken());
                if(tomato[i][j] == 1) q.offer(new Pair(i, j));
                if (tomato[i][j] == -1) tomatoNum--;
            }
        }


        date = 0;
        box = 0;
        BFS(q);
        
        if(box != tomatoNum) System.out.println(-1);
        else System.out.println(date);
    }

    static void BFS(Queue<Pair> q) {
        Queue<Pair> newQ = new LinkedList<>();
        while (!q.isEmpty()) {
            box++;
            Pair p = q.poll();
            for (int i = 0; i < 4; i++) {
                int newN = p.n + dn[i];
                int newM = p.m + dm[i];
                if (newN < 0 || newM < 0 || newN >= N || newM >= M) continue;
                if (tomato[newN][newM] == 0) {
                    tomato[newN][newM] = 1;
                    newQ.offer(new Pair(newN, newM));
                }
            }
        }
        if(newQ.isEmpty()) return;
        BFS(newQ);
        date++;
    }
}
