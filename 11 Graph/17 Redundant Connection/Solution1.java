//-------------------UNION AND FIND

class Solution {
    int parent[];

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;// becoz one edge is extra
        parent = new int[n + 1];
        int res[] = new int[2];
        for (int i = 0; i <= n; i++)
            parent[i] = i;
        for (int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];
            if (find(u) == find(v)) {
                res = edge;
                continue;
            }
            union(u, v);
        }
        return res;
    }

    int find(int u) {
        if (u == parent[u])
            return u;
        return parent[u] = find(parent[u]);
    }

    void union(int u, int v) {
        int pu = find(u);
        int pv = find(v);
        if (pu == pv)
            return;
        parent[pu] = pv;
    }
}
// Time complexity : O(V+E)