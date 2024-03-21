#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

int solution(vector<vector<int>> triangle) {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int answer = 0;
    int tmp = 0;
    int t_size = triangle.size() -1;
    
    for (int i = 1; i <= t_size; i++) {
        for (int j = 0; j < triangle[i].size(); j++) {
            if (j == 0) {
                triangle[i][j] += triangle[i-1][j];
            }
            else if(j == triangle[i].size()-1) {
                triangle[i][j] += triangle[i-1][j-1];
            }
            else {
                if(triangle[i-1][j-1] > triangle[i-1][j]) {
                    triangle[i][j] += triangle[i-1][j-1];
                }
                else {
                    triangle[i][j] += triangle[i-1][j];
                }
            }
        }
    }
    
    for(int k = 0; k < triangle[t_size].size(); k++) {
        if(answer < triangle[t_size][k]) {
            answer = triangle[t_size][k];
        }
    }
    return answer;
}