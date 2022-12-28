import java.util.*;

//----------- DIJKSTRA ALGORITHM
//HINT : https://www.youtube.com/watch?v=rp1SMw7HSO8&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=35

class Solution {
    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        List<List<int[]>> adj = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        for (int i = 0; i < n + 1; i++)
            adj.add(new ArrayList<>());
        for (int edge[] : edges) {
            adj.get(edge[0]).add(new int[] { edge[1], edge[2] });
            adj.get(edge[1]).add(new int[] { edge[0], edge[2] });
        }

        int dist[] = new int[n + 1];
        int parent[] = new int[n + 1];

        for (int i = 0; i < n + 1; i++)
            parent[i] = i;
        Arrays.fill(dist, (int) 1e9);

        dist[1] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[] { 1, 0 });

        while (!pq.isEmpty()) {
            int it[] = pq.poll();
            int node = it[0];

            for (int neigh[] : adj.get(node)) {
                int u = neigh[0];
                int wei = neigh[1];
                if (dist[u] > dist[node] + wei) {
                    dist[u] = dist[node] + wei;
                    pq.add(new int[] { u, dist[u] });
                    parent[u] = node;
                }
            }
        }

        if (dist[n] == (int) 1e9) {
            path.add(-1);
            return path;
        }

        int node = n;
        while (parent[node] != node) {
            path.add(node);
            node = parent[node];
        }
        path.add(1);
        Collections.reverse(path);
        return path;
    }
}