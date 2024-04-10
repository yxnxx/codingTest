import java.io.*;

class Solution {
    public String solution(String s, int n) {
        String answer = "";
        
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ') answer += " ";
            else if(Character.isUpperCase(s.charAt(i))) {
                if(s.charAt(i) + n > 'A' + 25) {
                    answer += (char)('A' + (s.charAt(i) + n - 'A') % 25 - 1);
                }
                else answer += (char)(s.charAt(i) + n);
            }
            else {
                if(s.charAt(i) + n > 'a' + 25) {
                    answer += (char)('a' + (s.charAt(i) + n - 'a') % 25 - 1);
                }
                else answer += (char)(s.charAt(i) + n);
            }
            
        }
        return answer;
    }
}