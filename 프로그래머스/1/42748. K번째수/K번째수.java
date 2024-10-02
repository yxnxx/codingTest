import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        List<Integer> ans = new ArrayList<>();
        
        List<Integer> arr = 
            Arrays.stream(array)
            .boxed()
            .collect(Collectors.toList());
        
        for(int[] command : commands) {
            int i = command[0];
            int j = command[1];
            int k = command[2];
            List<Integer> newArr = new ArrayList<>(arr.subList(i-1, j));
            
            newArr.sort(Comparator.naturalOrder());
            ans.add(newArr.get(k-1));
        }
        
        answer = ans.stream()
            .mapToInt(Integer::intValue).toArray();
        return answer;
    }
}