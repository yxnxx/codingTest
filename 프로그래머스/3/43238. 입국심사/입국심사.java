import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        long min_time = 1;
        long max_time = Arrays.stream(times).max().getAsInt() * (long)n;
        while(min_time <= max_time) {
            long mid = (min_time + max_time) / 2;
            long tot = 0;
            for(int t: times) {
                tot += mid/t;
            }
            if(tot < n) {
                min_time = mid + 1;
            } else {
                answer = mid;
                max_time = mid - 1;
            }
        }
        return answer;
    }
}