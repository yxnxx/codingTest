#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    int N, K;
    vector<pair<int, int>> input;
    vector<vector<int>> bag;
    
    cin >> N >> K;
    bag.resize(N + 1);
    bag[0].resize(K + 1);
    bag[0] = {0, };

    int W, V, i;
    input.push_back({0, 0});
    for(i = 1; i <= N; i++) {
        cin >> W >> V;

        input.push_back({W, V});

        bag[i].resize(K + 1);
        bag[i] = {0, };
    }

    for(i = 1; i <= N; i++) {
        int weight = input[i].first;
        int value = input[i].second;

        for(int j = 1; j <= K; j++) {
            if (weight > j) {
                /* 
                    선택한 물건 넣지 못하는 경우,
                    이전이랑 동일한 값 유지
                */
               
               bag[i][j] = bag[i - 1][j];
            }

            else {
                if (value + bag[i - 1][j - weight] > bag[i - 1][j])
                {
                    /* 
                        넣었을 때 가치가 넣지 않았을 때의 가치보다 커진다면, update
                    */
                   bag[i][j] = bag[i - 1][j - weight] + value;
                }
                else {
                    bag[i][j] = bag[i - 1][j];
                }
            }
        }
    }

    cout << bag[N][K];

    return 0;
}