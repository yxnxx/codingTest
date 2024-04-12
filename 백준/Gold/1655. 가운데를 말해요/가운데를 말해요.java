/*
* 처음에 ArrayList에 숫자를 받고, 정렬한 다음 가운데 값을 찾는 방식으로 접근, 시간 초과
* 시간 복잡도에 대해 충분히 고려해서 문제 풀어 본 경험 X. 접근법 자체를 모르겠어서 검색해 봄
* 0.1초 시간 제한인데, 정렬 알고리즘 시간 복잡도 * N번 반복: NlogN * N, N은 최대 10만! -> 시간 초과가 날 수밖에 없음
* 우선순위 큐를 사용하면 삽입에 logN만큼 걸림.
* minHeap, maxHeap 두 가지를 사용해서 구현
* StringBuilder로 출력 빠르게 하기
*/

// 이 문제는 꼭 다시 풀어 보자! 접근법부터 검색해 버렸음...
import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if(i%2 == 0) {
                maxQ.offer(Integer.parseInt(br.readLine()));
                // 없으면 1 5 4 3 순서대로 들어왔을 때 1 4 3 5처럼 정렬이 되어 버리는 경우가 발생
                // if else 문 아래에 합쳐서 작성 가능함
                if(i != 0 && maxQ.peek() > minQ.peek()) {
                    maxQ.add(minQ.poll());
                    minQ.add(maxQ.poll());
                }
            }
            else {
                minQ.offer(Integer.parseInt(br.readLine()));
                if(maxQ.peek() > minQ.peek()) {
                    maxQ.add(minQ.poll());
                    minQ.add(maxQ.poll());
                }
            }

            sb.append(maxQ.peek());
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
