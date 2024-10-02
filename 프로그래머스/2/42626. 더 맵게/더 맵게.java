import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for(int s : scoville) {
            minHeap.add(s);
        }
        
        while(true) {
            int minSc = minHeap.poll();
            if(minHeap.size() == 0 && minSc < K) {
                answer = -1;
                break;
            }
            if(minSc >= K) break;
            int secondSc = minHeap.poll();
            int newSc = minSc + secondSc*2;
            minHeap.add(newSc);
            answer += 1;
        }
        return answer;
    }
}