
import java.util.*;
// ALGO
//first find distance of all nodes from 0

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        Map<Integer, HashMap<Integer, Integer>> dist = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
            dist.put(i, new HashMap<>());
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
                dist.get(0).put(node, level);
                for (int i : adj.get(node))
                    if (!visited[i])
                        q.add(i);
            }
            level++;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    dist.get(i).put(j, 0);
                } else if (i > j) {
                    dist.get(i).put(j, dist.get(j).get(i));
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
                        dist.get(i).put(j, 1);
                    else
                        dist.get(i).put(j, dist.get(i).get(j - 1) + dist.get(j - 1).get(j));
                }
            }
        }
        System.out.print(dist);
        return new ArrayList<>();

    }
}