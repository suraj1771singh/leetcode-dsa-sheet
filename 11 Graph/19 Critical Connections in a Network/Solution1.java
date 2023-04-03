import java.util.*;

//----------------BRIDGE PROBLEM
class Solution {
    int low[], tin[];
    int time;
    List<List<Integer>> bridges;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (List<Integer> edge : connections) {
            adj.get(edge.get(0)).add(edge.get(1));
            adj.get(edge.get(1)).add(edge.get(0));
        }
        low = new int[n];
        tin = new int[n];
        time = 0;
        bridges = new ArrayList<>();
        dfs(0, -1, new boolean[n], adj);
        return bridges;

    }

    void dfs(int node, int parent, boolean[] seen, List<List<Integer>> adj) {
        seen[node] = true;
        tin[node] = low[node] = time++;
        for (int child : adj.get(node)) {
            if (child == parent)
                continue;
            if (!seen[child]) {
                dfs(child, node, seen, adj);
                low[node] = Math.min(low[node], low[child]);
                // check for bridge
                if (low[child] > tin[node])
                    bridges.add(new ArrayList<>(Arrays.asList(node, child)));
            } else {
                // visited: take low
                low[node] = Math.min(low[node], low[child]);
            }
        }
    }
}
// Time complexity : O(V+E)