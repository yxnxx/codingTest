import java.io.*;

class Solution {
    public String solution(String s, int n) {
        String answer = "";
        
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ') answer += " ";
            else if(Character.isUpperCase(s.charAt(i))) {
                answer += (char)('A' + (s.charAt(i) + n - 'A') % 26);
            }
            else {
                answer += (char)('a' + (s.charAt(i) + n - 'a') % 26);
            }
        }
        return answer;
    }
}