import java.util.*;

/**
* 처음에 string -> Integer.parseInt
* 테스트케이스는 다 맞는데 제출 시 런타임 에러!
* 문자열 길이가 10,000까지였으므로 주의했어야 함.
*/
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
