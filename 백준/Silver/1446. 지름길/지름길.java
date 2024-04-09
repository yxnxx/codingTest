/*
* 값을 비교해서 최소 값으로 업데이트 할 때
* Math.min을 사용하면 더 간단하게 할 수 있음!
*/

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

            // 지름길이 아닌 경우는 꼭 제외하기
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

            // 모든 노드에 대해서 업데이트 여부 확인해야 함! 이게 없으면 지름길이 있는 지점만 업데이트 됨
            if(distance.get(i + 1) > distance.get(i) + 1) {
                distance.set(i + 1, distance.get(i) + 1);
            }
        }
        System.out.println(distance.get(D));
    }


}
