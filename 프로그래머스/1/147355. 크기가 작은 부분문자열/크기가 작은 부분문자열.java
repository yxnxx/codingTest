import java.util.*;

class Solution {
    public int solution(String t, String p) {
        long tval = 0;
        long pval = Long.parseLong(p);
        int plen = p.length();
        
        int answer = 0;
        for(int i = 0; i <= t.length()-plen; i++) {
            tval = Long.parseLong(t.substring(i, i+plen));
            
            if (tval <= pval) answer++;
        }
        return answer;
    }
}