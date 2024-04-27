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