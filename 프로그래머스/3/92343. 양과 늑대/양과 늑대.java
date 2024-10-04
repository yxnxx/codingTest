import java.util.*;

class Solution {
    int maxSheep = 0;
    public int solution(int[] info, int[][] edges) {
        int answer = 0;
        
        // tree 저장
        List<Integer>[] tree = new ArrayList[info.length];
        for(int i = 0; i < info.length; i++) {
            tree[i] = new ArrayList<>();
        }
        for(int[] e: edges) {
            tree[e[0]].add(e[1]);
            // tree[e[1]].add(e[0]);
        }
        
        List<Integer> nextNodes = new ArrayList<>();
        nextNodes.add(0);
        DFS(info, tree, nextNodes, 0, 0, 0);
        
        return maxSheep;
    }
    
    void DFS(int[] info, List<Integer>[] tree, List<Integer> nextNodes, int node, int sheep, int wolves) {
        if(info[node] == 0) {
            sheep += 1;
        } else {
            wolves += 1;
        }
        if(sheep <= wolves) return;
        
        maxSheep = Math.max(maxSheep, sheep);
        
        List<Integer> newNodes = new ArrayList<Integer>(nextNodes);
        newNodes.remove((Integer) node);
        for(int c: tree[node]) {
            if(!nextNodes.contains(c)) {
                newNodes.add(c);
            }
        }
        
        for(int n: newNodes) {
            DFS(info, tree, newNodes, n, sheep, wolves);
        }
    }
}