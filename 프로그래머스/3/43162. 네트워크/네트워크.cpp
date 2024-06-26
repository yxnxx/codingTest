#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

vector<bool> visited;
int con = 0;

void DFS(int ind, vector<vector<int>> computers) {
    visited[ind] = true;
    /*
        i = ind+1부터 해서 틀렸었다!
        예를 들어, 이런 경우를 고려하지 않은 것.
        1 -> 5 -> 2
    */
    for(int i = 0; i < computers.size(); i++) {
        if(computers[ind][i] == 1 && visited[i] == false) {
            DFS(i, computers);
            con--;
        } 
    }
}

int solution(int n, vector<vector<int>> computers) {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    visited.resize(n);
    con = n;
    
    for (int i = 0; i < n; i++) {
        if(visited[i] == false) {
            DFS(i, computers);
        }
    }
    int answer = con;
    return answer;
}
