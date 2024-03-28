#include <iostream>
#include <vector>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
  
    string input = "";
    string answer = "";
    int cnt = 0;    // X의 개수
    bool bflag = false;    // XX가 나왔는지 여부

    cin >> input;
    for (int i = 0; i <= input.length(); i++) {
        /*
            X가 연속 4번 나오면 무조건 AAAA 추가
            연속 두 번 나오면 flag만 true로 업데이트 
            -> X가 4번 연속 나올 가능성이 있으므로 바로 BB를 추가하지 않는다.
        */
        if (cnt == 4) {
            answer += "AAAA";
            cnt = 0;
            bflag = false;
        }
        else if(cnt == 2) {
            bflag = true;
        }

        /*
            .이 나오거나 마지막 문자에 대한 처리를 하기 위해
            X의 개수가 0, 2, 4개가 아니면 덮을 수 없는 보드판
            참고로 X의 개수가 0개라는 것은 현재까지 모든 X를 이미 덮었다는 뜻!
        */
        if(input[i] == '.' || i == input.length()) {
            if(cnt != 4 && cnt != 2 && cnt != 0) {
                cout << -1 << endl;
                return 0;
            }
            // X가 연속 2개만 나온 상태 - 덮어 주기
            if(bflag && cnt == 2) {
                answer += "BB";
                cnt = 0;
                bflag = false;
            }
            // .인 경우, 추가
            if(i < input.length()) answer += input[i];
        }
        else {
            // X의 개수 세기
            cnt++;
        }
    }
    
    cout << answer << endl;
    return 0;
}
