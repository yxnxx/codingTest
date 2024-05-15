/*
* 처음 접근
* 1. sort 사용.
* 2. 꼴등 점수와 같고, 랭킹이 꽉 찼으면 -1
* 3. 한 명인 경우, 점수가 더 낮으면 2등이고 아니면 1등
* 4. 이분탐색으로 점수가 들어갈 수 있는 index 찾기.
* 5. 해당 인덱스 앞에 나와 같은 점수인 사람 수 세어 주기.
* 6. 같은 점수가 많고 랭킹이 꽉 차게 되면 -1, 아니면 ind-cnt+1로 등수 출력
* 사실 sort, 2번, 4번 정도만 고려해서 풀었다가 2%에서 실패. 모든 반례 찾아서 코드 복잡해짐.
* 그래도 여전히 실패...! 접근을 바꾸어 버림.
* 나보다 점수 높은 사람들 수 세기 -> 등수 결정.
* 점수 같은 사람 수 세기 -> 등수 + 같은 점수 사람 수로 랭킹에 들어갈 수 있는지 판단.
* 훨씬 깔끔해졌다... 너무 복잡하게 접근한 것이 문제
*/

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> scores;
int findScore(int, int, int);

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, new_score, P;
    cin >> N >> new_score >> P;

    if(N == 0) {
        cout << 1 << endl;
        return 0;
    }

    for(int i = 0; i < N; i++) {
        int x;
        cin >> x;
        scores.push_back(x);
    }

    int ans = 1;
    int cnt = 0;
    for(int i = 0; i < N; i++) {
        if(scores.at(i) > new_score) {
            ans++;
        } else if(scores.at(i) == new_score) {
            cnt++;
        }
    }

    if(ans + cnt > P) {
        cout << -1 << endl;
    } else {
        cout << ans << endl;
    }
}
