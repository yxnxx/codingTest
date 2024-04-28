/*
* 처음에 문제 잘못 읽어서 틀렸음... 문제를 잘 읽자!
* 나는 queue의 pop, push, front 함수를 활용하여 구현
* 규칙을 찾아서 풀 수도 있었음! 2*input - (input보다 크거나 같은 2의 제곱수)
* 그러나 규칙을 찾기가 쉽지 않은 문제...
*/

#include <iostream>
#include <queue>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N;
    cin >> N;

    queue<int> q;
    for(int i = 1; i <= N; i++) {
        q.push(i);
    }

    while(q.size() > 1) {
        q.pop();
        q.push(q.front());
        q.pop();
    }

    cout << q.front() << endl;
}
