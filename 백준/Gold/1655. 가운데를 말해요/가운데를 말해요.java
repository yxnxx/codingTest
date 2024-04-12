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