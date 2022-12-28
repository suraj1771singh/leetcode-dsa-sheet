import java.util.*;

// https://leetcode.com/problems/minimum-height-trees/discuss/76055/Share-some-thoughts

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        if (n == 1)
            return new ArrayList<>(Arrays.asList(0));
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int edge[] : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) {
            indegree[i] = adj.get(i).size();
        }

        Queue<Integer> q = new LinkedList<>();
        // insert those whoes indegree is one
        for (int i = 0; i < n; i++)
            if (indegree[i] == 1)
                q.add(i);
        int cnt = n;
        while (!q.isEmpty() && cnt > 2) {
            int size = q.size();
            cnt -= size;
            while (size-- > 0) {
                int node = q.poll();
                for (int u : adj.get(node)) {
                    indegree[u]--;
                    if (indegree[u] == 1)
                        q.add(u);
                }
            }

        }
        return new ArrayList<>(q);
    }
}