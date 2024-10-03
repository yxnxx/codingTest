import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = dfs(numbers, target, 0, 0);
        return answer;
    }
    
    int dfs(int[] numbers, int target, int ind, int sum) {
        if(ind == numbers.length) {
            return (sum == target) ? 1:0;
        }
        return dfs(numbers, target, ind+1, sum+numbers[ind]) + 
            dfs(numbers, target, ind+1, sum-numbers[ind]);
    }
}