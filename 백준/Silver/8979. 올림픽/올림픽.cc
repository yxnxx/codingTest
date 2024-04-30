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