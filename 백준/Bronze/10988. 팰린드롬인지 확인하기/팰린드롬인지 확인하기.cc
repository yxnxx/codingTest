#include <iostream>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    string input;
    cin >> input;

    int len = input.length() - 1;
    bool flag = true;
    for (int i = 0; i < input.length()/2; i++) {
        if(input[i] != input[len - i]) {
            flag = false;
            break;
        }
    }
    
    if(flag) {
        cout << 1 << "\n";
    }
    else {
        cout << 0 << "\n";
    }
}