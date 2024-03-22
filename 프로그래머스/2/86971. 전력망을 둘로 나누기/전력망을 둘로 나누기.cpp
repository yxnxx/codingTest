#include <string>
#include <vector>
#include <iostream>
#include <cmath>

using namespace std;

int cnt;
vector<bool> visited;
vector<vector<int>> mem;

void DFS(int ind, int cant, vector<vector<int>> wires) {
    visited[ind] = true;
    cnt++;
    for(int i = 0; i < mem[ind].size(); i++) {
        if(mem[ind][i] != cant) {
            if(visited[mem[ind][i]] == false) {
                DFS(mem[ind][i], cant, wires);
            }
        }
    }
}
int solution(int n, vector<vector<int>> wires) {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int answer = -1;
    mem.resize(n + 1);
    visited.resize(n+1);
    
    // 초기화
    for(auto wire: wires) {
        mem[wire[0]].push_back(wire[1]);
        mem[wire[1]].push_back(wire[0]);
    }
    
    // 간선 하나씩 끊어 보기
    for(auto wire: wires) {
        DFS(wire[0], wire[1], wires);
        // cout << cnt << endl;
        int min = abs(n - 2*cnt);
        if(min == 0 || min == 1) {
            answer = min;
            break;
        }
        if(answer < 0 || min < answer) {
            answer = min;
        }
        cnt = 0;
        fill(visited.begin(), visited.end(), 0);
    }
    return answer;
}