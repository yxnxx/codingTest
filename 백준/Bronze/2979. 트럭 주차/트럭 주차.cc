#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int one, two, thr;
    cin >> one >> two >> thr;

    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> truck;

    for(int i = 0; i < 3; i++) {
        int s, l;
        cin >> s >> l;
        truck.push({s, l});
    }

    int truck_num[101] = {0};
    int start = truck.top().first;
    while(!truck.empty()) {
        int s = truck.top().first;
        int l = truck.top().second;

        for(int j = s; j < l; j++) {
            truck_num[j]++;
        }
        truck.pop();
    }

    int answer = 0;
    for(int i = start; i <= 101; i++) {
        if(truck_num[i] == 1) {
            answer += one;
        }
        else if (truck_num[i] == 2) {
            answer += two * 2;
        }
        else if (truck_num[i] == 3) {
            answer += thr * 3;
        }
        else continue;
    }

    cout << answer << "\n";
}