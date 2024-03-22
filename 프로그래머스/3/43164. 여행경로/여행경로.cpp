#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

vector<string> route;
// visit 배열은 티켓을 사용했는지 여부를 나타냄
vector<bool> visited;
bool findAll = false;

void DFS(vector<vector<string>> tickets, string country, int ind, int num) {
    route.push_back(country);

    if(ind == num) {
        findAll = true;
        return;
    }
    
    int i;
    for(i = 0; i < tickets.size(); i++) {
        if(tickets[i][0] == country) {
            if(visited[i] == false) {
                /*
                * visit 배열의 티켓 순서를 잘 고려해야 함.
                */
                visited[i] = true;
                /*
                * 길이 연결된 경우 DFS로 모든 티켓이 소진될까지 들어감
                * 그러나 중간에 끊긴다면 빠져나옴
                * 이때 새로운 길을 탐색해야 하므로 빠져나온 상태에서
                * 현재 티켓은 경로가 아니기 때문에 pop하고 false로 바꿔 줌
                */
                DFS(tickets, tickets[i][1], ind+1, num);
                
                if(findAll == false) {
                    route.pop_back();
                    visited[i] = false;
                }
            }
        }
    }
}

vector<string> solution(vector<vector<string>> tickets) {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    vector<string> answer;
    int num = tickets.size();
    visited.resize(num);
    visited = {false};
    
    sort(tickets.begin(), tickets.end());
    
    DFS(tickets, "ICN", 0, num);
    answer=route;
    return answer;
}