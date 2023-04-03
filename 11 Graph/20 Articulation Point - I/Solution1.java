import java.util.*;

//--------------------------ARTICULATION POINT\

class Solution {
    int tin[];
    int low[];
    boolean mark[];
    int timer;

    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> articulationPoints(int n, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        boolean seen[] = new boolean[n];
        mark = new boolean[n];
        tin = new int[n];
        low = new int[n];
        timer = 0;
        for (int i = 0; i < n; i++)
            if (!seen[i])
                dfs(i, -1, seen, adj);

        for (int i = 0; i < n; i++)
            if (mark[i])
                res.add(i);

        if (res.size() == 0)
            res.add(-1);
        return res;
    }

    // O(V+E)
    void dfs(int node, int parent, boolean[] seen, ArrayList<ArrayList<Integer>> adj) {
        seen[node] = true;
        tin[node] = low[node] = timer++;
        int cnt = 0;
        for (int child : adj.get(node)) {
            if (child == parent)
                continue;
            if (!seen[child]) {
                dfs(child, node, seen, adj);
                low[node] = Math.min(low[node], low[child]);

                if (low[child] >= tin[node] && parent != -1)
                    mark[node] = true;
                cnt++;
            } else {
                low[node] = Math.min(low[node], tin[child]);
            }
        }
        if (cnt > 1 && parent == -1)
            mark[node] = true;
    }
}
// Time complexity : O(V+E)