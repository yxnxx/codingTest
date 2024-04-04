#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>

using namespace std;

int find(int, int);
void findMax(int, int, int);

vector<int> req;
int answer;
int main() {
    int N;
    cin >> N;

    req.resize(N);
    int sum = 0;
    for(int i = 0; i < N; i++) {
        cin >> req[i];
        sum += req[i];
    }

    sort(req.begin(), req.end());
    int budget;
    cin >> budget;

    answer = 0;
    if(sum > budget) {
        if(req.front() >= budget/req.size()) { 
            answer = budget/req.size();
        }
        else {
            int n = req.size()/2;
            int minB_ind = find(n, budget/req.size());
            findMax(minB_ind, req[minB_ind], budget);
        }
    }
    else {
        answer = req.at(req.size()-1);
    }

    cout << answer << endl;
}

int find(int n, int ind_bdg) {
    if(req[n] >= ind_bdg) {
        return find(n/2, ind_bdg);
    }
    return n;
}

void findMax(int ind, int minB, int budget) {
    int sum = 0;
    for(int i = 0; i < ind; i++) {
        sum += req[i];
    }
    sum += minB*(req.size()-ind);
    if(sum > budget) return;
    else {
        answer = minB;
        if(req[ind] < minB + 1) ind++;
        findMax(ind, minB + 1, budget);
    }
}