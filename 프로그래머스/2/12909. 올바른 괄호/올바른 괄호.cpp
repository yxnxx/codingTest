#include<string>
#include <iostream>

using namespace std;

bool solution(string s)
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    bool answer = true;
    int flag = 0;
    
    for(int i = 0; i < s.length(); i++) {
        if(s[i] == '(') flag++;
        else flag--;
        
        if(flag == -1) {
            answer = false;
            break;
        }
    }

    if(flag != 0) answer = false;
    return answer;
}