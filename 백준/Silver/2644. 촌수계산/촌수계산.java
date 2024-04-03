/**
 * 빠른 입력을 위해서는 BufferedReader 사용
 * IOException 추가 or try-catch 필요
 */

/*
* 다른 사람들은 result를 따로 설정해서 y == x 시점에 result=cnt로 fix
* 나는 길이 없어 다시 돌아오는 시점에 -1 계산을 하게 구현
* for each문, ArrayList 사용법 등 익히기
* DFS로 푼 것! BFS 풀이 방식도 존재
* BFS 풀이법도 꼭 익혀 두자
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
        DFS(x, y);
        if(flag) System.out.println(cnt);
        else System.out.println(-1);
    }

    public static void DFS(int x, int y) {
        visited.set(x, true);
        if(y == x) {
            flag = true;
            return;
        }
        cnt++;
        for (int next : rel[x]) {
            if (!visited.get(next) && !flag) {
                DFS(next, y);
            }
        }
        if(!flag) cnt--;
    }
}
