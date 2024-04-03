/**
 * 빠른 입력을 위해서는 BufferedReader 사용
 * IOException 추가 or try-catch 필요
 */

import java.io.*;
import java.util.*;
public class Main {

    public static int cnt;
    public static List<Boolean> visited;
    public static ArrayList<Integer>[] rel;
    public static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        rel = new ArrayList[n];
        visited = new ArrayList<>(n);
        int i;
        for (i = 0; i < n; i++) {
            rel[i] = new ArrayList<Integer>();
            visited.add(false);
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken()) - 1;
        int y = Integer.parseInt(st.nextToken()) - 1;

        int m = Integer.parseInt(br.readLine());

        for (i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int input_x = Integer.parseInt(st.nextToken()) - 1;
            int input_y = Integer.parseInt(st.nextToken()) - 1;
            rel[input_x].add(input_y);
            rel[input_y].add(input_x);
        }

        cnt = 0;
        BFS(x, y);
        if(flag) System.out.println(cnt);
        else System.out.println(-1);
    }

    public static void BFS(int x, int y) {
        visited.set(x, true);
        if(y == x) {
            flag = true;
            return;
        }
        cnt++;
        for(int i = 0; i < rel[x].size(); i++) {
            int next = rel[x].get(i);
            if(!visited.get(next) && !flag) {
                BFS(next, y);
            }
        }
        if(!flag) cnt--;
    }
}