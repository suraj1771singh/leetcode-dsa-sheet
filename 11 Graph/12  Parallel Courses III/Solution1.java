import java.util.*;

//-------TOPOLOGICAL SORT
//Idea is to calculate maxi dist of each node from its ancestor

class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        List<List<Integer>> adj = new ArrayList<>();
        int indegree[] = new int[n];

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int edge[] : relations) {
            adj.get(edge[0] - 1).add(edge[1] - 1);
            indegree[edge[1] - 1]++;
        }
        return toposort(n, indegree, adj, time);

    }

    // O(V+E)
    public int toposort(int n, int[] indegree, List<List<Integer>> adj, int[] time) {

        Queue<Integer> q = new LinkedList<>();
        int dist[] = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = time[i];
            if (indegree[i] == 0)
                q.add(i);
        }

        while (!q.isEmpty()) {
            int node = q.poll();
            for (int u : adj.get(node)) {
                dist[u] = Math.max(time[u] + dist[node], dist[u]);
                indegree[u]--;
                if (indegree[u] == 0)
                    q.add(u);
            }
        }
        int ans = 0;
        for (int i : dist)
            ans = Math.max(i, ans);
        return ans;
    }
}
// Time complexity : O(V+E)