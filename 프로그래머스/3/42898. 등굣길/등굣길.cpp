#include <string>
#include <vector>
#include <iostream>

using namespace std;

#define DIV 1000000007

/*
* 효율성에서 계속 에러가 나서 다른 사람들의 코드를 참고해
* if문을 줄이는 방향으로 수정해 보았으나, 실패
* 좀 더 검색을 해 보니, 자료형의 크기가 문제였음!
* 나머지 계산을 아예 for문에 포함 시켰다.
*/
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
