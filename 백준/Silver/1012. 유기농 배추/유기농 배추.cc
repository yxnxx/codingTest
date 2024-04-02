/**
* 다른 사람들의 코드를 보니 보통 동서남북으로 이동하는 것을 배열로 저장해서 푼다.
* x축 이동 - {0,0,-1,1} y축 이동 - {1,-1,0,0} 저장해 두고, for문 사용
*/

#include <iostream>
#include <vector>
#include <queue>
using namespace std;

vector<vector<int>> field;
queue<pair<int, int>> loc;
void DFS(int, int, int, int);
int cnt;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int T;
    cin >> T;

    int M, N, K;
    for(int i = 0; i < T; i++) {
        cnt = 0;
        cin >> M >> N >> K;
        field.resize(N);

        for(int j = 0; j < N; j++) {
            field[j].resize(M);
            field[j] = {0};
        }

        int X, Y;
        for(int k = 0; k < K; k++) {
            cin >> X >> Y;
            field[Y][X] = 1;
            loc.push({X, Y});
        }

        while(!loc.empty()) {
            X = loc.front().first;
            Y = loc.front().second;
            if(field[Y][X] == 1) {
                DFS(X, Y, M, N);
                cnt++;
            }
            loc.pop();
        }
        cout << cnt << endl;
    }
}

void DFS(int X, int Y, int M, int N) {
    field[Y][X] = 0;
    if(X + 1 < M) {
        if(field[Y][X + 1] == 1) {
            DFS(X + 1, Y, M, N);
        }
    }

    if(X > 0) {
        if(field[Y][X - 1] == 1) {
            DFS(X - 1, Y, M, N);
        }
    }

    if(Y > 0) {
        if(field[Y - 1][X] == 1) {
            DFS(X, Y - 1, M, N);
        }
    }

    if(Y + 1 < N) {
        if(field[Y + 1][X] == 1) {
            DFS(X, Y + 1, M, N);
        }
    }
}
