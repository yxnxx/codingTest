#include <iostream>
#include<vector>
#include <bits/stdc++.h>

using namespace std;

int solution(vector<int> A, vector<int> B) {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int answer = 0;
    int tmp = 0;
    sort(A.begin(), A.end());
    sort(B.rbegin(), B.rend());
    
    for(int i = 0; i < A.size(); i++) {
        answer += A[i]*B[i];
    }
    return answer;
}