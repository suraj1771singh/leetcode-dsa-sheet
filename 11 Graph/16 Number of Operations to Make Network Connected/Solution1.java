//----------------UNION AND FIND

class Solution {
    int parent[];

    public int makeConnected(int n, int[][] connections) {
        int E = connections.length, extraa = 0, req = 0;
        parent = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = i;
        for (int i = 0; i < E; i++) {
            int u = connections[i][0];
            int v = connections[i][1];
            if (find(u) == find(v)) {
                extraa++;
                continue;
            }
            union(u, v);
        }
        for (int i = 0; i < n; i++)
            if (parent[i] == i)
                req++;
        req--;
        if (extraa >= req)
            return req;
        else
            return -1;

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
        parent[pv] = pu;
    }

}
// Time complexity : O(V+E)