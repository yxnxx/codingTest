#include <vector>
#include <unordered_map>
#include <set>
#include <iostream>
using namespace std;

int solution(vector<int> nums)
{
    int pick = nums.size()/2;
    int answer = 0;
    set<int> n;
    for(int p : nums) {
        n.insert(p);
    }
    if(pick <= n.size()) {
        answer = pick;
    } else {
        answer = n.size();
    }
    return answer;
}