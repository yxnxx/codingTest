import java.util.*;
import java.io.*;

class Main {
    static int N;
    static int M;
    static int[][] paper;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        paper = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;
        ArrayList<Integer> maxArr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                maxArr.add(tet1(i, j));
                maxArr.add(tet2(i, j));
                maxArr.add(tet3(i, j));
                maxArr.add(tet4(i, j));
                maxArr.add(tet5(i, j));
            }
            maxArr.sort(Collections.reverseOrder());
            max = Math.max(max, maxArr.get(0));
            maxArr.clear();
        }

        System.out.println(max);
    }

    static int tet1(int i, int j) {
        int x, y;
        if (j + 3 >= M) x = -1;
        else x = paper[i][j] + paper[i][j + 1] + paper[i][j + 2] + paper[i][j + 3];

        if (i + 3 >= N) y = -1;
        else y = paper[i][j] + paper[i + 1][j] + paper[i + 2][j] + paper[i + 3][j];

        return Math.max(x, y);
    }

    static int tet2(int i, int j) {
        if (i + 1 >= N || j + 1 >= M) return -1;
        else return paper[i][j] + paper[i + 1][j] + paper[i][j + 1] + paper[i + 1][j + 1];
    }

    static int tet3(int i, int j) {
        int x, y;
        ArrayList<Integer> maxArr = new ArrayList<>();
        if (i + 2 >= N || j + 1 >= M) x = -1;
        else {
            maxArr.add(paper[i][j] + paper[i + 1][j] + paper[i + 2][j] + paper[i + 2][j + 1]);
            maxArr.add(paper[i][j] + paper[i][j + 1] + paper[i + 1][j + 1] + paper[i + 2][j + 1]);
            maxArr.add(paper[i+2][j] + paper[i][j+1] + paper[i+1][j+1] + paper[i+2][j+1]);
            maxArr.add(paper[i][j] + paper[i][j+1] + paper[i+1][j] + paper[i+2][j]);
            x = maxArr.stream().mapToInt(o->o).max().getAsInt();
        }

        maxArr.clear();
        if (i + 1 >= N || j + 2 >= M) y = -1;
        else {
            maxArr.add(paper[i + 1][j] + paper[i + 1][j + 1] + paper[i][j + 2] + paper[i + 1][j + 2]);
            maxArr.add(paper[i][j] + paper[i + 1][j] + paper[i + 1][j + 1] + paper[i + 1][j + 2]);
            maxArr.add(paper[i][j] + paper[i][j+1] + paper[i][j+2] + paper[i+1][j+2]);
            maxArr.add(paper[i][j] + paper[i][j+1] + paper[i][j+2] + paper[i+1][j]);
            y = maxArr.stream().mapToInt(o->o).max().getAsInt();
        }

        return Math.max(x, y);
    }

    static int tet4(int i, int j) {
        int x, y;
        if (i + 2 >= N || j + 1 >= M) x = -1;
        else {
            x = Math.max(paper[i][j] + paper[i + 1][j] + paper[i + 1][j + 1] + paper[i + 2][j + 1],
                    paper[i][j+1] + paper[i+1][j] + paper[i+1][j+1] + paper[i+2][j]);
        }

        if (i + 1 >= N || j + 2 >= M) y = -1;
        else {
            y = Math.max(paper[i][j + 1] + paper[i][j + 2] + paper[i + 1][j] + paper[i + 1][j + 1],
                    paper[i][j] + paper[i][j+1] + paper[i+1][j+1] + paper[i+1][j+2]);
        }

        return Math.max(x, y);
    }

    static int tet5(int i, int j) {
        int x, y;
        if (i + 1 >= N || j + 2 >= M) x = -1;
        else {
            x = Math.max(paper[i][j] + paper[i][j+1] + paper[i][j+2] + paper[i+1][j+1],
                    paper[i][j+1] + paper[i+1][j] + paper[i+1][j+1] + paper[i+1][j+2]);
        }

        if (i + 2 >= N || j + 1 >= M) y = -1;
        else {
            y = Math.max(paper[i+1][j] + paper[i][j+1] + paper[i+1][j+1] + paper[i+2][j+1],
                    paper[i][j] + paper[i+1][j] + paper[i+2][j] + paper[i+1][j+1]);
        }
        return Math.max(x, y);
    }
}
