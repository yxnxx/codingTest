import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        // initialize
        List<Integer>[] v = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++) {
            v[i] = new ArrayList<>();
        }
        
        // add vertex bidirection
        for(int[] e: edge) {
            v[e[0]].add(e[1]);
            v[e[1]].add(e[0]);
        }
        
        // store dist
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        dist[1] = 0;
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        while(!q.isEmpty()) {
            int curr = q.poll();
            for(int e: v[curr]) {
                if(dist[e] < 0) {
                    dist[e] = dist[curr] + 1;
                    q.offer(e);
                // } else if(dist[e] < dist[curr] + 1) {
                //     continue;
                // } else {
                //     dist[e] = dist[curr] + 1;
                }
                // q.offer(e);
            }
        }
        
        int maxDist = Arrays.stream(dist).max().orElse(0);
        answer = (int) Arrays.stream(dist).filter(d -> d==maxDist).count();
        return answer;
    }
}