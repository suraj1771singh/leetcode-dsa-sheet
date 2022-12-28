import java.util.*;

class Solution {
    boolean cycle[];
    boolean seen[];

    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {

        seen = new boolean[V];
        boolean stack[] = new boolean[V];
        cycle = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!seen[i]) {
                dfsCheck(i, adj, stack);
            }
        }
        List<Integer> safeNodes = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (cycle[i] == false)
                safeNodes.add(i);
        }
        return safeNodes;
        // Your code here
    }

    private boolean dfsCheck(int node, List<List<Integer>> adj, boolean stack[]) {
        seen[node] = true;
        stack[node] = true;
        cycle[node] = true;
        // traverse for adjacent nodes
        for (int it : adj.get(node)) {
            // when the node is not visited
            if (!seen[it]) {
                if (dfsCheck(it, adj, stack) == true)
                    return true;
            }
            // if the node has been previously visited
            // but it has to be visited on the same path
            else if (stack[it]) {
                return true;
            }
        }
        cycle[node] = false;
        stack[node] = false;
        return false;
    }
}
// Time complexity : O(V+E)