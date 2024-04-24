#include <iostream>

using namespace std;

int find_zero(int N) {
    int cnt = 0;
    while(1) {
        if(N/5 == 0) break;
        cnt += N/5;
        N /= 5;
    }
    return cnt;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int T;
    cin >> T;

    int nums[T];

    int N;
    int answer[T];
    for(int i = 0; i < T; i++) {
        cin >> N;
        answer[i] = find_zero(N);
    }

    for(int i = 0; i < T; i++) {
        cout << answer[i] << "\n";
    }
}