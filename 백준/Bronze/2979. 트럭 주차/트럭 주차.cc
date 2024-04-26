/*
* 굳이 pq 안 쓰고 input 받을 때 머무는 시간 동안의 차 개수 +1 해 주도록 구현할 수 있음.
* 또한 if else문으로 복잡하게 개수별 요금을 계산하지 않고, 배열을 사용할 수 있음.
* {0, A, B, C}의 값으로 초기화된 배열 arr가 있다면 answer += arr[truck_num[i]]
* for문 안에서 한 줄로 간단하게 계산 가능!
*/

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
