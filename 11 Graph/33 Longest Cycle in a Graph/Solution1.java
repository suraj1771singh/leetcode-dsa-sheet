import java.util.*;
/*
 * 1) first remove those nodes that are not part of any cycle, 
 *    this can be done by using concept of topo sort
 * 2) now from remaining nodes using cycle dectection recursion , count length of cycle
 *   and return maximum length
 */

class Solution {
    public int longestCycle(int[] edges) {
        int n = edges.length;
        int indegree[] = new int[n];
        boolean seen[] = new boolean[n];
        for (int i = 0; i < n; i++)
            if (edges[i] != -1)
                indegree[edges[i]]++;

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++)
            if (indegree[i] == 0)
                q.add(i);

        // remove non cycle nodes
        while (!q.isEmpty()) {
            int node = q.poll();
            seen[node] = true;
            int next = edges[node];
            if (next != -1) {
                indegree[next]--;
                if (indegree[next] == 0)
                    q.add(next);
            }
        }
        // From remaining nodes, definately part of cycle , return max length of cycle
        int res = -1;
        for (int i = 0; i < n; i++)
            if (!seen[i])
                res = Math.max(res, dfs(i, new boolean[n], seen, edges));
        return res;

    }

    int dfs(int node, boolean[] stack, boolean[] seen, int[] edges) {
        if (stack[node] == true)
            return 0;
        seen[node] = true;
        stack[node] = true;
        int len = dfs(edges[node], stack, seen, edges);
        stack[node] = false;
        return len + 1;
    }
}
// Time complexity : O(n)