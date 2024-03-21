#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

vector<bool> visited;
int con = 0;

void DFS(int ind, vector<vector<int>> computers) {
    visited[ind] = true;
    for(int i = 0; i < computers.size(); i++) {
        if(computers[ind][i] == 1 && visited[i] == false) {
            DFS(i, computers);
            cout << con << endl;
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