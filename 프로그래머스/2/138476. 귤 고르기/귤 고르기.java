/*
* 효율적인 풀이 방법은 HashMap을 사용하는 것!
* getOrDefault라는 메서드를 사용할 수 있음!
* HashMap을 List로 바꿔서 sort
* HashMap을 활용한 문제는 처음이라 생각을 못 했음.
* 다양한 유형의 문제를 풀면서 여러 자료구조를 사용하는 방법을 익히자!
*/

import java.util.*;
import java.io.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Arrays.sort(tangerine);
        int maxNum = tangerine[tangerine.length-1];
        
        int answer = 0;

        // 처음에 크기가 다 이어져 있다고 가정해 버려서 max 값 말고 max-min의 범위로 초기화 했음
        // -> 런타임 에러!!
        int[] tangN = new int[maxNum + 1];
        for(int i = 0; i < tangerine.length; i++) {
            tangN[tangerine[i]]++;
        }
        
        Integer[] tangInt = Arrays.stream(tangN).boxed().toArray(Integer[]::new);
        Arrays.sort(tangInt, Collections.reverseOrder());
        
        for(Integer n : tangInt) {
            if(n == 0) continue;
            if(k - n > 0) {
                k -= n;
                answer++;
            }
            else {
                answer++;
                break;
            }
        }
        return answer;
    }
}
