import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = {};
        
        HashMap<Integer, Integer> suc = new HashMap<>();
        for(int st : stages) {
            suc.put(st, suc.getOrDefault(st, 0) + 1);
        }
        
        int user = stages.length;
        HashMap<Integer, Double> fail = new HashMap<>();
        for(int i = 1; i <= N; i++) {
            if(user == 0) {
                fail.put(i, 0.0);
                continue;
            }
            int sucUser = suc.containsKey(i) ? suc.get(i) : 0;
            fail.put(i, (double)sucUser/user);
            user = user - sucUser;
        }
        
        
        List<Integer> failKey = new ArrayList<>(fail.keySet());
        failKey.sort(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                if(Double.compare(fail.get(o1), fail.get(o2)) == 0) {
                    return o1 - o2;
                }
                else return fail.get(o2).compareTo(fail.get(o1));
            }
        });
        
        answer = new int[N];
        for(int i = 0; i < N; i++) {
            answer[i] = failKey.get(i);
        }

        return answer;
    }
}