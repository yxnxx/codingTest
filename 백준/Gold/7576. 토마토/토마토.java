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
        int boxes = N * M;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                tomato[i][j] = Integer.parseInt(st.nextToken());
                if(tomato[i][j] == 1) q.offer(new Pair(i, j));
                if (tomato[i][j] == -1) boxes--;
            }
        }


        date = 0;
        box = 0;
        DFS(q);
        
        if(box != boxes) System.out.println(-1);
        else System.out.println(date);
    }

    static void DFS(Queue<Pair> q) {
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
        DFS(newQ);
        date++;
    }
}