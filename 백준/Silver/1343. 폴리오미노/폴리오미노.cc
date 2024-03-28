#include <iostream>
#include <vector>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
  
    string input = "";
    string answer = "";
    int cnt = 0;
    bool bflag = false;

    cin >> input;
    for (int i = 0; i <= input.length(); i++) {
        if (cnt == 4) {
            answer += "AAAA";
            cnt = 0;
            bflag = false;
        }
        else if(cnt == 2) {
            bflag = true;
        }

        if(input[i] == '.' || i == input.length()) {
            if(cnt != 4 && cnt != 2 && cnt != 0) {
                cout << -1 << endl;
                return 0;
            }
            if(bflag && cnt == 2) {
                answer += "BB";
                cnt = 0;
                bflag = false;
            }
            if(i < input.length()) answer += input[i];
        }
        else {
            cnt++;
        }
    }
    
    cout << answer << endl;
    return 0;
}