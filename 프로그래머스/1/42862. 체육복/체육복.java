import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        Arrays.sort(lost);
        Arrays.sort(reserve);
        List<Integer> may = new ArrayList<>();
        List<Integer> re = Arrays.stream(reserve)
                            .boxed()
                            .collect(Collectors.toList());
        for(int l : lost) {
            if(re.contains(l)) {
                re.remove(Integer.valueOf(l));
                answer+=1;
                continue;
            }
            may.add(l-1);   
            may.add(l+1);
        }
        
        for(int i = 0; i < may.size(); i+=2) {
            if(re.contains(may.get(i))) {
                re.remove(Integer.valueOf(may.get(i)));
                answer+=1;
                continue;
            }
            if(re.contains(may.get(i+1))) {
                re.remove(Integer.valueOf(may.get(i+1)));
                answer+=1;
            }
        }
        
        return answer;
    }
}