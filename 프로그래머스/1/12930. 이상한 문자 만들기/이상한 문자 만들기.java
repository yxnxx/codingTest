/*
* 삼항 연산자를 사용하면 효율적이고 깔끔한 코드를 쓸 수 있다!
* 문자열을 split 해서 String 배열로 저장하면, toString과 같이 복잡한 코드가 필요 없음
*/

class Solution {
    public String solution(String s) {
        String answer = "";
        
        int ind = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ') {
                ind = 0;
                answer += ' ';
                continue;
            }
            if(ind % 2 == 0) {
                answer += Character.toString(s.charAt(i)).toUpperCase();
                ind++;
            }
            else {
                answer += Character.toString(s.charAt(i)).toLowerCase();
                ind++;
            }
        }
        return answer;
    }
}
