/*
* 처음에는 구조체 자체에 rank를 포함하여 sort를 하고, 등수가 같은 경우를 찾기 위해 for문을 돌면서 모든 국가에 대한 등수를 저장해 주었다.
* 메모리 초과가 나서 이유를 찾아 보다가 rank를 구조체에서 빼고 정렬된 순서를 바탕으로 K 국가와 같은 등수인 국가의 수를 찾아 등수를 구했다.
* 그래도 여전히 메모리 초과가 떴다...
* 알고 보니 처음에 vector size를 (N)으로 초기화 해 버렸는데, 각각에 대해 구조체의 사이즈만큼 할당을 해 주지 않아서였다.
* 근데 왜 vscode에서는 제대로 돌아갔는지 모르겠지만... 아무튼 push를 활용해 입력 받게끔 코드를 수정했다.
*/

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

struct Medal {
    int num;
    int gold;
    int silver;
    int bronze;
};

bool compare(Medal &m1, Medal &m2) {
    if(m1.gold > m2.gold) return true;
    else if(m1.gold == m2.gold) {
        if(m1.silver > m2.silver) return true;
        else if(m1.silver == m2.silver) {
            if(m1.bronze > m2.bronze) return true;
        }
    }
    return false;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, K;

    cin >> N >> K;

    vector<Medal> countries;
    Medal m;

    int c, g, s, b;
    for(int i = 0; i < N; i++) {
        cin >> c >> g >> s >> b;

        m.num = c;
        m.gold = g;
        m.silver = s;
        m.bronze = b;
        countries.push_back(m);
    }

    sort(countries.begin(), countries.end(), compare);

    int result;
    for(int i = 0; i < N; i++) {
        if(countries[i].num == K) {
            result = i;
            break;
        }
    }
    
    int cnt = 0;
    for(int i = result-1; i >= 0; i--) {
        if((countries[result].gold != countries[i].gold) || (countries[result].silver != countries[i].silver)  || (countries[result].bronze != countries[i].bronze)) {
            break;
        }
        cnt++;
    }

    cout << result - cnt + 1 << endl;
}
