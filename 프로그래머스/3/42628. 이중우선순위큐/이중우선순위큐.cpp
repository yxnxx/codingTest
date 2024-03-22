#include <string>
#include <vector>
#include <iostream>
#include <queue>

using namespace std;

vector<int> solution(vector<string> operations) {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    vector<int> answer;
    priority_queue<int> max_Q;
    priority_queue<int, vector<int>, greater<int>> min_Q;
    string tmp = "";
    int cnt = 0;
    
    for(int i = 0; i < operations.size(); i++) {
        if(operations[i][0] == 'I') {
            tmp = operations[i].substr(2);
            max_Q.push(stoi(tmp));
            min_Q.push(stoi(tmp));
            cnt++;
        }
        else {
            if(operations[i][2] == '1') {
                if(!max_Q.empty()) {
                    max_Q.pop();    
                    cnt--;
                }
            }
            else {
                if(!min_Q.empty()) {
                    min_Q.pop();
                    cnt--;
                }
            }
        }
        if(cnt == 0) {
            min_Q = priority_queue<int, vector<int>, greater<int>>();
            max_Q = priority_queue<int>();
        }
    }
    
    if(cnt == 0) {
        answer.push_back(0);
        answer.push_back(0);
    }
    else {
        answer.push_back(max_Q.top());
        answer.push_back(min_Q.top());
    }
    return answer;
}