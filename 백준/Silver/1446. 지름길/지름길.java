import java.io.*;
import java.util.*;

public class Main {
    static class ShortCut {
        int start;
        int end;
        int dist;

        ShortCut(int start, int end, int dist) {
            this.start = start;
            this.end = end;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        ArrayList<Integer> distance = new ArrayList<>();

        for(int i = 0; i < D + 1; i++) {
            distance.add(i);
        }

        ArrayList<ShortCut> shortCuts = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            if(start > D || end > D || end - start <= dist) continue;
            shortCuts.add(new ShortCut(start, end, dist));
        }

        for(int i = 0; i < D; i++) {
            for(ShortCut sc : shortCuts) {
                if(sc.start == i) {
                    if(sc.dist + distance.get(i) < distance.get(sc.end)) {
                        distance.set(sc.end, sc.dist + distance.get(i));
                    }
                }
            }

            if(distance.get(i + 1) > distance.get(i) + 1) {
                distance.set(i + 1, distance.get(i) + 1);
            }
        }
        System.out.println(distance.get(D));
    }


}