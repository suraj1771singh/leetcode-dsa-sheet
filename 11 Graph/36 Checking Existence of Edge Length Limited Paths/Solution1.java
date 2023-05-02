import java.util.*;

class Solution {
    int parent[];

    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        boolean ans[] = new boolean[queries.length];
        Arrays.fill(ans, true);
        parent = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = i;

        Arrays.sort(edgeList, (a, b) -> a[2] - b[2]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> queries[a][2] - queries[b][2]);
        for (int i = 0; i < queries.length; i++)
            pq.add(i);

        for (int edge[] : edgeList) {
            while (!pq.isEmpty() && queries[pq.peek()][2] <= edge[2]) {
                int ind = pq.poll();
                ans[ind] = find(queries[ind][0]) == find(queries[ind][1]);
            }
            union(edge[0], edge[1]);
        }
        return ans;
    }

    int find(int x) {
        if (parent[x] == x)
            return x;
        return parent[x] = find(parent[x]);
    }

    void union(int x, int y) {
        int p1 = find(x);
        int p2 = find(y);
        if (p1 == p2)
            return;
        parent[p2] = p1;
    }
}
// Time complexity : O(m*log m ) , m = size of edgelist