
//GFG
import java.util.*;

//---------USING BFS

class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int v, ArrayList<ArrayList<Integer>> adj) {
        // [node, parent]
        boolean[] seen = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!seen[i])
                if (bfs(i, v, adj, seen))
                    return true;
        }
        return false;

    }

    private boolean bfs(int src, int v, ArrayList<ArrayList<Integer>> adj, boolean[] seen) {
        Queue<int[]> q = new LinkedList<>();
        seen[src] = true;
        q.add(new int[] { src, -1 });
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int point[] = q.poll();
                int node = point[0];
                int parent = point[1];
                // check neighbours
                for (int u : adj.get(node)) {
                    if (!seen[u]) {
                        seen[u] = true;
                        q.add(new int[] { u, node });
                    } else if (u != parent)
                        return true;
                }
            }
        }
        return false;
    }
}