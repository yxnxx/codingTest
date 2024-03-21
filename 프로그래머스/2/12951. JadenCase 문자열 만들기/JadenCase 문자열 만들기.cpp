#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

string solution(string s) {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    string answer = "";
    
    if(islower(s[0])) {
        s[0] = toupper(s[0]);
    }
    answer += s[0];
    
    bool flag = false;
    for(int i = 1; i < s.length(); i++) {
        if(s[i] == ' ') {
            flag = true;
        }
        else {
            if(flag == true) {
                if(islower(s[i])) {
                    s[i] = toupper(s[i]);
                }
            }
            else {
                if(isupper(s[i])) {
                    s[i] = tolower(s[i]);
                }
            }
            flag = false;
        }
        answer += s[i];
    }
    
    return answer;
}