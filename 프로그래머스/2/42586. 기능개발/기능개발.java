import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        Queue<Integer> q = new LinkedList<>();
        int[] time = new int[progresses.length];
        for(int i = 0; i < progresses.length; i++) {
            q.offer((int)Math.ceil((100.0 - progresses[i])/speeds[i]));
        }
        
        int dep = q.poll();
        int cnt = 1;
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()) {
            if(q.peek() > dep) {
                ans.add(cnt);
                cnt = 1;
                dep = q.poll();
            }
            else {
                q.poll();
                cnt += 1;
            }
        }
        ans.add(cnt);
        answer = ans.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}