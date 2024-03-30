/*
    그냥 answer = 1부터 시작해서 while문 돌리고,
    n % answer = 1이 되면 return 하면 됐다.
*/
class Solution {
    public int solution(int n) {
        int answer = n - 1;
        for(int i = 2; i < answer; i++) {
            if(answer % i == 0) {
                answer = i;
                break;
            }
        }
        return answer;
    }
}
