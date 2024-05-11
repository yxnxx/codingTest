import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Double> drinks = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            drinks.add(Double.parseDouble(st.nextToken()));
        }

        Collections.sort(drinks);

        double answer = 0;
        for(int i = 0; i < N -1; i++) {
            answer += drinks.get(i)/2;
        }

        answer += drinks.get(N-1);
        System.out.println(answer);
    }
}