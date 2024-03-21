#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

int cnt = 0;

void DFS(int sum, int ind, vector<int> numbers, int target) {
    // size()-1에서 종료하면 마지막 값은 계산에 포함이 안 돼서 실패
    if(ind == numbers.size()) {
        if(sum == target) {
            cnt++;
        }
        return;
    }

    // 증감연산자 사용시 ind 값이 누적돼서 오류!!!
    DFS(sum + numbers[ind], ind+1, numbers, target);
    DFS(sum - numbers[ind], ind+1, numbers, target);
}

int solution(vector<int> numbers, int target) {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int answer = 0;
    
    DFS(0, 0, numbers, target);

    answer = cnt;
    
    return answer;
}
