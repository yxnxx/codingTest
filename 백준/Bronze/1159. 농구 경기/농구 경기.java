import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

//        String[] players = new String[N];
        HashMap<Character, Integer> names = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String player = br.readLine();
            names.put(player.charAt(0), names.getOrDefault(player.charAt(0), 0) + 1);
        }

        String answer = "";
        for(char c: names.keySet()) {
            if(names.get(c) >= 5) {
                answer += c;
            }
        }

        if(answer.isEmpty()) {
            answer = "PREDAJA";
        }

        System.out.println(answer);
    }
}