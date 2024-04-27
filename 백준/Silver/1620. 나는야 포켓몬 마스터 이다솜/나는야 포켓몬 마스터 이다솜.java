/*
* 처음에는 List에 저장하고 포켓몬 이름이 들어오는 경우 indexOf 사용함. 시간 초과! 이유는?
* N, M 값이 각각 최대 십만 - 최대 백억 번 연산, 시간 제한은 2초 (2억까지 연산 가능) -> 조건, 시간 제한 꼭 잘 따져 보기!!
* 이분탐색을 도입하자!
* HashMap에 포켓몬 번호, 이름 순으로 저장하고 이름을 오름차순 순으로 정렬한 keySet을 하나 만든다. 
* 정렬 시 람다 식을 사용했는데, intellij에서 Comparator.comparing()을 알려 주었다. (블로그에 옮기면서 자세히 써 보자)
* findIndex 함수에서 마지막에 return 할 때 포켓몬 번호가 아니라 index를 return 하는 바람에 틀린 부분 찾는 데 시간이 걸렸다.
* 다른 사람들의 코드를 보니 HashMap을 두 개 만들어서 이름, 번호 순으로 저장하기도 하였다.
* 혹은 (이름, 번호) 순으로 저장된 하나의 HashMap을 가지고 번호로 검색해야 하는 경우에는 arr[ind]를 사용하여 값을 찾기도 하였다.
*/


import java.util.*;
import java.io.*;

class Main {

    public static HashMap<Integer, String> poket;
    public static List<Integer> keySet;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        poket = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            poket.put(i, br.readLine());
        }

        keySet = new ArrayList<>(poket.keySet());

        keySet.sort(Comparator.comparing(o -> poket.get(o)));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String input = br.readLine();

            if(input.chars().allMatch(Character::isDigit)) {
                int ind = Integer.parseInt(input);
                sb.append(poket.get(ind));
            } else {
                sb.append(findIndex(0, N - 1, input));
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static Integer findIndex(int start, int end, String input) {
        int mid = (start+end)/2;

        String pok = poket.get(keySet.get(mid));

        if (pok.equals(input)) return keySet.get(mid);
        else if (pok.compareTo(input) > 0) return findIndex(start, mid -1, input);
        else return findIndex(mid + 1, end, input);
    }
}
