/*
* 처음에 전부 같은 문자를 입력한 경우를 생각하지 않고 풀어서 
* 마지막에 같은 개수만큼 입력된 문자가 있는지 검색하는 if 문에서 IndexOutOfBound 에러가 났다.
* 나는 HashMap과 정렬을 사용하여 코드를 짰는데, 아스키 코드를 사용하여 arr에 개수를 저장하는 방법을 많이들 사용하는 것 같다.
* 이 문제에서는 내 코드도 통과가 되었지만, 메모리와 시간을 줄일 수 있는 방법을 고려해 볼 필요도 있겠다.
*/

import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        input = input.toUpperCase();

        if (input.length() == 1) {
            System.out.println(input.charAt(0));
            return;
        }

        HashMap<Character, Integer> alph = new HashMap<>();

        for (int i = 0; i < input.length(); i++) {
            alph.put(input.charAt(i), alph.getOrDefault(input.charAt(i), 0) + 1);
        }

        List<Character> keySet = new ArrayList<>(alph.keySet());
        if (keySet.size() == 1) {
            System.out.println(keySet.get(0));
            return;
        }
        
        keySet.sort(((o1, o2) -> alph.get(o2).compareTo(alph.get(o1))));
        
        if (alph.get(keySet.get(0)).equals(alph.get(keySet.get(1)))) {
            System.out.println("?");
        } else {
            System.out.println(keySet.get(0));
        }
    }
}
