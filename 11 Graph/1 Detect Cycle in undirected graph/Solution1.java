
//GFG
import java.util.*;

//---------USING DFS

class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int v, ArrayList<ArrayList<Integer>> adj) {
        boolean[] seen = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!seen[i])
                if (dfs(i, -1, seen, adj))
                    return true;
        }
        return false;
    }

    private boolean dfs(int i, int parent, boolean[] seen, ArrayList<ArrayList<Integer>> adj) {
        seen[i] = true;
        // check all neighbours
        for (int u : adj.get(i)) {
            if (!seen[u]) {
                if (dfs(u, i, seen, adj))
                    return true;
            } else if (u != parent)
                return true;
        }
        return false;
    }
}