import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Long> tips = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            tips.add(Long.parseLong(br.readLine()));
        }
        Collections.sort(tips, Collections.reverseOrder());

        long answer = 0;
        for(int i = 0; i < N; i++) {
            if(tips.get(i) <= i) break;
            answer += (tips.get(i) - i);
        }

        System.out.println(answer);
    }
}