import java.util.*;

class Solution {
    public int solution(int N, int number) {
        if(N == number) return 1;
        
        List<HashSet<Integer>> dp = new ArrayList<>();
        
        dp.add(new HashSet<>());
        for(int i = 1; i < 9; i++) {
            dp.add(new HashSet<>());
            dp.get(i).add(Integer.parseInt(String.valueOf(N).repeat(i)));
        }
        
        int answer = -1;
        for(int i = 1; i < 9; i++) {
            for(int j = 1; j < i; j++) {
                Set<Integer> num1 = new HashSet<>(dp.get(j));
                for(int n1 : num1) {
                    Set<Integer> num2  = new HashSet<>(dp.get(i-j));
                    for(int n2: num2) {
                        dp.get(i).add(n1 + n2);
                        dp.get(i).add(n1 - n2);
                        if(n2!=0) dp.get(i).add(n1 / n2);
                        dp.get(i).add(n1 * n2);
                    }
                }
            }
            if(dp.get(i).contains(number)) {
                answer = i;
                break;
            }
        }
        
        return answer;
    }
    
   
}