#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

int cnt = 0;

void DFS(int sum, int ind, vector<int> numbers, int target) {
    if(ind == numbers.size()) {
        if(sum == target) {
            cnt++;
        }
        return;
    }
    
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
