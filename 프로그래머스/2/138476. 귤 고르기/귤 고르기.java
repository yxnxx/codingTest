import java.util.*;
import java.io.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Arrays.sort(tangerine);
        int maxNum = tangerine[tangerine.length-1];
        
        int answer = 0;
        
        int[] tangN = new int[maxNum + 1];
        for(int i = 0; i < tangerine.length; i++) {
            tangN[tangerine[i]]++;
        }
        
        Integer[] tangInt = Arrays.stream(tangN).boxed().toArray(Integer[]::new);
        Arrays.sort(tangInt, Collections.reverseOrder());
        
        for(Integer n : tangInt) {
            if(n == 0) continue;
            if(k - n > 0) {
                k -= n;
                answer++;
            }
            else {
                answer++;
                break;
            }
        }
        return answer;
    }
}