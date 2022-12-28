
import java.util.*;
// ALGO
//first find distance of all nodes from 0

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int edge[] : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        // calculating distance of all nodes from 0
        Queue<Integer> q = new LinkedList<>();
        int level = 0;
        boolean visited[] = new boolean[n];
        q.add(0);
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int node = q.poll();
                visited[node] = true;
                dist[0][node] = level;
                for (int i : adj.get(node))
                    if (!visited[i])
                        q.add(i);
            }
            level++;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    dist[i][j] = 0;
                } else if (i > j) {
                    dist[i][j] = dist[j][i];
                } else {
                    // check for direct edge if possible
                    boolean iscontains = false;
                    for (int neigh : adj.get(i)) {
                        if (neigh == j) {
                            iscontains = true;
                            break;
                        }
                    }
                    if (iscontains)
                        dist[i][j] = 1;

                    else {
                        if (j > i + 1)
                            dist[i][j] = dist[i][j - 1] + dist[j - 1][j];
                        else
                            dist[i][j] = dist[i][j - 2] + dist[j - 2][j];
                    }

                }
            }
        }
        int a[] = new int[n];
        int mini = (int) 1e7;
        for (int i = 0; i < n; i++) {
            int maxi = 0;

            for (int j = 0; j < n; j++)
                maxi = Math.max(maxi, dist[i][j]);
            a[i] = maxi;
            mini = Math.min(mini, maxi);

        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (a[i] == mini)
                ans.add(i);
        }
        return new ArrayList<>();

    }
}