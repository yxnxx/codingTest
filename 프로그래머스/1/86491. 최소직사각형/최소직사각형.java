import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int W_MAX = -1;
        int H_MAX = -1;
        for(int[] s : sizes) {
            if(W_MAX < s[0]) {
                W_MAX = s[0];
            }
            if(H_MAX < s[1]) {
                H_MAX = s[1];
            }
        }
        
        boolean isMaxW = true; // max가 w
        if(W_MAX > H_MAX) {
            Arrays.sort(sizes, 
                        Comparator.comparingInt((int[] s) -> s[0]).reversed());
        } else {
            isMaxW = false;
            Arrays.sort(sizes, 
                        Comparator.comparingInt((int[] s) -> s[1]).reversed());
        }
        
        int ansL = sizes[0][0];
        int ansR = sizes[0][1];
        for(int i = 1; i < sizes.length; i++) {
            if (!isMaxW) {   // 세로가 max
                if(sizes[i][0] > ansL) {
                    if(sizes[i][1] > ansL) {
                        ansL = Math.min(sizes[i][0], sizes[i][1]);
                    }
                }
            }
            else {
                if(sizes[i][1] > ansR) {
                    if(sizes[i][0] > ansR) {
                        ansR = Math.min(sizes[i][0], sizes[i][1]);
                    }
                }
            }
        }
        answer = ansL * ansR;
        return answer;
    }
}