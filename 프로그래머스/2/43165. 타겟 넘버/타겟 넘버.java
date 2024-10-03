import java.util.*;

class Solution {
    int CNT = 0;
    public int solution(int[] numbers, int target) {
        int answer = 0;
        dfs(numbers, target, 0, 0);
        answer = CNT;
        return answer;
    }
    
    public void dfs(int[] numbers, int target, int ind, int sum) {
        if(ind+1 > numbers.length) {
            if(sum == target) {
                CNT++;
            }
            return;
        }
        dfs(numbers, target, ind+1, sum+numbers[ind]);
        dfs(numbers, target, ind+1, sum-numbers[ind]);
    }
}