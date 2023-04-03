import java.util.*;

//--------------SIMPLE DFS
class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int i = 0; i < n; i++) {
            if (manager[i] == -1)
                continue;
            adj.get(manager[i]).add(i);
        }
        return dfs(headID, adj, manager, informTime);

    }

    int dfs(int node, List<List<Integer>> adj, int[] manager, int[] informTime) {
        int max = 0;
        for (int child : adj.get(node)) {
            int time = informTime[node] + dfs(child, adj, manager, informTime);
            max = Math.max(max, time);
        }
        return max;
    }
}
// Time complexity : O(n)