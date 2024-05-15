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