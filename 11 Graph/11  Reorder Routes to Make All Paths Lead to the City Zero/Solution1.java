import java.util.*;

/*
https://www.youtube.com/watch?v=m17yOR5_PpI

Intuitatoin
1) if we can reach to node from node 0 means, we can't reach from that node to node 0
2) firstly we have make node 0's neighbour to reach to 0
4) and recursively we have to do same thing with neighbour neighbours
5) so the idea is we are make undirected graph, so that we can reach all neighbours
6) and put all edges(connections) in set 
7) while doing dfs from 0 , if we found any edge that is present in set, means 
  that edge need to be reversed , so increament the ans;
8) do dfs recursively to neighbour nodes
*/
class Solution {
    int ans;

    public int minReorder(int n, int[][] connections) {
        Set<String> set = new HashSet<>();
        ans = 0;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int edge[] : connections) {
            String str = edge[0] + "-" + edge[1]; // using string becoz we can't store arr in set(duplicacy problem)
            set.add(str);
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        boolean vis[] = new boolean[n];
        dfs(0, vis, set, adj);
        return ans;

    }

    public void dfs(int src, boolean[] vis, Set<String> set, List<List<Integer>> adj) {
        vis[src] = true;
        for (int u : adj.get(src)) {
            if (!vis[u]) {
                String str = src + "-" + u;
                if (set.contains(str))
                    ans++;
                dfs(u, vis, set, adj);
            }
        }
    }
}
// Time complexity : O(V+E)