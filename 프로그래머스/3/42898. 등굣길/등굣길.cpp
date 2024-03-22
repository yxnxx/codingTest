#include <string>
#include <vector>
#include <iostream>

using namespace std;

#define DIV 1000000007

int solution(int m, int n, vector<vector<int>> puddles) {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int visited[101][101] = {0};
    
    // 물에 잠긴 지역 표시
    for(auto pud: puddles) {
        visited[pud[1]][pud[0]] = -1;
    }
    
    visited[0][1] = 1;
    for(int i = 1; i <= n; i++) {
        for(int j = 1; j <=m; j++) {
            if(visited[i][j] == -1) {
                continue;
            }
            visited[i][j] += (visited[i-1][j] != -1 ? visited[i-1][j] : 0);
            visited[i][j] += (visited[i][j-1] != -1 ? visited[i][j-1] : 0);
            visited[i][j] %= DIV;
        }
    }
    
    int answer = visited[n][m] % DIV;
    return answer;
}