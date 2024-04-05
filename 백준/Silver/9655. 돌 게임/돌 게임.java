/*
* DP 문제라고 하여 풀었으나, 오히려 그렇게 풀면 복잡함!
* 그래도 DP 풀이법 한 번 보고 익혀 두자.
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if(N%2 == 0) System.out.println("CY");
        else System.out.println("SK");
    }
}
