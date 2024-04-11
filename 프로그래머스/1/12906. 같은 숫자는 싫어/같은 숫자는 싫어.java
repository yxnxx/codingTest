import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        List<Integer> ans = new ArrayList<>();
        ans.add(arr[0]);
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] != arr[i-1]) ans.add(arr[i]);
        }
        
        int[] answer = ans.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}