import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> partMap = new HashMap<>();
        
        for(String p: participant) {
            partMap.put(p, partMap.getOrDefault(p, 0) + 1);
        }
        
        for(String c: completion) {
            partMap.put(c, partMap.get(c)-1);
        }
        
        for(String n : partMap.keySet()) {
            if(partMap.get(n) == 1) {
                answer = n;
                break;
            }
        }
        return answer;
    }
}