#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int T;
    cin >> T;
    int answer[T];

    int n;
    for(int i = 0; i < T; i++) {
        cin >> n;
        int st[2][n];

        for(int j = 0; j < 2; j++) {
            for(int k = 0; k < n; k++) {
                cin >> st[j][k];
            }
        }

        if(n == 1) {
            cout << max(st[0][0], st[1][0]) << endl;
            continue;
        }

        int maxP[2][n];

        maxP[0][0] = st[0][0];
        maxP[1][0] = st[1][0];
        maxP[0][1] = st[0][1] + st[1][0];
        maxP[1][1] = st[1][1] + st[0][0];
        for(int j = 2; j < n; j++) {
            maxP[0][j] = st[0][j] + max(maxP[1][j-1], maxP[1][j-2]);
            maxP[1][j] = st[1][j] + max(maxP[0][j-1], maxP[0][j-2]);
        }

        cout << max(maxP[0][n-1], maxP[1][n-1]) << endl;
    }
}