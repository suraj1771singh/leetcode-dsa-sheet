import java.util.*;

class Solution {
    int[] parent;
    int cnt[];

    public long countPairs(int n, int[][] edges) {
        parent = new int[n];
        cnt = new int[n];
        long ans = 0, sum = 0;
        for (int i = 0; i < n; i++)
            parent[i] = i;
        Arrays.fill(cnt, 1);
        for (int edge[] : edges)
            union(edge[0], edge[1]);
            
        // find adjcent prduct of all
        // [4,2,1], ans= 4*2+4*1+2*1
        for (int i = 0; i < n; i++) {
            if (parent[i] == i) {
                ans += sum * 1L * cnt[i];
                sum += cnt[i];
            }
        }
        return ans;
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
        if (cnt[pu] > cnt[pv]) {
            parent[pv] = pu;
            cnt[pu] += cnt[pv];
        } else {
            parent[pv] = pu;
            cnt[pu] += cnt[pv];
        }
    }
}
// Time complexit : O(n)