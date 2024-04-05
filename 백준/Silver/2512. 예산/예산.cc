/*
* 이진 탐색 문제 - 내가 아직 풀어 본 적 없는 유형이었음!
*
* 풀이 방법
* 1. sort 후 최소 최대 값을 각각 start, end로 두기
* 2. while문 안에서 중간 값을 찾아서 (start 값 + end 값)/2 상한액으로 설정
* 3. 그보다 작은 값들은 그냥 더하고, 큰 값은 상한액 더하기
* 4. budget보다 sum이 커지면 end-1, 작으면 start+1 & 현재 상한액을 답으로 저장해 두기
* 5. start 값이 end 값보다 커질 때까지 반복
*/

#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>

using namespace std;

int find(int, int);
void findMax(int, int, int);

vector<int> req;
int answer;
int main() {
    int N;
    cin >> N;

    req.resize(N);
    int sum = 0;
    for(int i = 0; i < N; i++) {
        cin >> req[i];
        sum += req[i];
    }
    sort(req.begin(), req.end());
    
    int budget;
    cin >> budget;

    answer = 0;
    if(sum > budget) {
        // 가장 작은 예산 요청액이 (총 예산/지방 수)보다 크면?
        if(req.front() >= budget/req.size()) {
            // 상한액을 (총 예산/지방 수)로 설정
            answer = budget/req.size();
        }
        else {
            int n = req.size()/2;
            int minB_ind = find(n, budget/req.size());
            findMax(minB_ind, req[minB_ind], budget);
        }
    }
    else {
        answer = req.at(req.size()-1);
    }

    cout << answer << endl;
}

// ind_bdg: 총 예산/지방 수, 즉 모든 지방이 같은 상한액을 가졌을 때 최대 값
int find(int n, int ind_bdg) {
    if(req[n] >= ind_bdg) {
        return find(n/2, ind_bdg);
    }
    return n;
}

void findMax(int ind, int minB, int budget) {
    int sum = 0;

    // 아래 과정을 for문에서 req[i], minB의 min 값을 더하게끔 고칠 수 있음
    for(int i = 0; i < ind; i++) {
        sum += req[i];
    }
    sum += minB*(req.size()-ind);
    
    if(sum > budget) return;
    else {
        answer = minB;
        if(req[ind] < minB + 1) ind++;
        findMax(ind, minB + 1, budget);
    }
}
