/*
* 자바의 자료구조에 조금 약한 것 같아서 쉬운 문제들 위주로 풀어 보는 중
* stream 사용법도 익혀야 함!
*/

import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        List<Integer> ans = new ArrayList<>();
        ans.add(arr[0]);
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] != arr[i-1]) ans.add(arr[i]);
        }
        
        int[] answer = ans.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}
