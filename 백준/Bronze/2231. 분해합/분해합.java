// C++로 풀었던 문제인데, java 코테 연습하면서 다시 풀어 봄. 효율적으로 작성하는 방법 찾기

/**
 * 입력 받은 값보다 한 자리수 작은 수부터 탐색하기.
 * ex) 세 자리 수면 가장 최소의 생성자는 두 자리 수부터 가능!
 */

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        int len = String.valueOf(input).length();
        if (len != 1) len--;    // 일의 자리 수일 때는 일의 자리 수부터 탐색 가능.
        int x = (int)Math.pow(10, len - 1);

        int answer = 0;
        int comp = 0;
        for (int i = x; i < input; i++) {
            comp = i;
            answer = i;
            while(true) {
                if(answer / 10 == 0) break;
                comp += answer % 10;
                answer /= 10;
            }
            comp += answer;
            if(comp == input) {
                answer = i;
                break;
            }
            else answer = 0;
        }
        System.out.println(answer);
    }
}
