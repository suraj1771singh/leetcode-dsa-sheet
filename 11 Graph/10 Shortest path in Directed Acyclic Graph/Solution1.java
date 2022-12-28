import java.util.*;

//gfg
class Solution {

    public int[] shortestPath(int N, int M, int[][] edges) {

        // create adj list
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++)
            adj.add(new ArrayList<>());
        for (int edge[] : edges) {
            adj.get(edge[0]).add(new int[] { edge[1], edge[2] });
        }

        // find topological order, O(N+M)
        Stack<Integer> st = new Stack<>();
        boolean vis[] = new boolean[N];
        for (int i = 0; i < N; i++) {
            if (!vis[i])
                toposort(i, st, vis, adj);
        }

        // find dist thing
        int dist[] = new int[N];
        Arrays.fill(dist, (int) 1e9);
        dist[0] = 0;

        // O(N+M)
        while (!st.isEmpty()) {
            int node = st.pop();
            for (int it[] : adj.get(node)) {
                int v = it[0];
                int wei = it[1];
                if (dist[node] + wei < dist[v])
                    dist[v] = dist[node] + wei;
            }
        }
        for (int i = 0; i < N; i++)
            if (dist[i] == (int) 1e9)
                dist[i] = -1;
        return dist;
    }

    public void toposort(int i, Stack<Integer> st, boolean[] vis, List<List<int[]>> adj) {
        vis[i] = true;
        for (int u[] : adj.get(i)) {
            if (!vis[u[0]])
                toposort(u[0], st, vis, adj);
        }
        st.push(i);
    }
}