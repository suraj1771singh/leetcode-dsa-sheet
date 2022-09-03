import java.util.*;

//--------------DFS SOLUTION

class Solution2 {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        // adjacent list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int edge[] : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] seen = new boolean[n];
        for (int i : restricted)
            seen[i] = true;
        return dfs(0, adj, seen);
    }

    private int dfs(int i, ArrayList<ArrayList<Integer>> adj, boolean seen[]) {
        int cnt = 1;
        seen[i] = true;
        // move to neghbours
        for (int neigh : adj.get(i)) {
            if (!seen[neigh])
                cnt += dfs(neigh, adj, seen);
        }
        return cnt;
    }
}
