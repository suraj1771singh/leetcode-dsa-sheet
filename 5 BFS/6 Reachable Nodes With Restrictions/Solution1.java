import java.util.*;

//-------------------BFS SOLUTION

class Solution1 {
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

        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        int ans = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            ans += size;
            for (int i = 0; i < size; i++) {
                // get all neighbours
                int node = q.poll();
                seen[node] = true;
                for (int nextNode : adj.get(node))
                    if (!seen[nextNode])
                        q.add(nextNode);

            }
        }
        return ans;

    }
}