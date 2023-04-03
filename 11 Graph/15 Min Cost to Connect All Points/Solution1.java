import java.util.*;

//--------------KRUSKAL'S ALGO 
//Time complexity : O(E*log E)

class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<int[]> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                arr.add(new int[] {
                        i, j, Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1])
                });
            }
        }
        int E = arr.size();
        Collections.sort(arr, (a, b) -> a[2] - b[2]);
        int V = points.length;
        Disjoint dis = new Disjoint(V);
        int sum = 0;
        for (int i = 0; i < E; i++) {
            int u = arr.get(i)[0];
            int v = arr.get(i)[1];
            int w = arr.get(i)[2];
            if (dis.find(u) == dis.find(v))
                continue;
            dis.union(u, v);
            sum += w;
        }
        return sum;
    }
}

class Disjoint {
    int size[];
    int parent[];

    Disjoint(int n) {
        size = new int[n];
        parent = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = i;
        Arrays.fill(size, 1);
    }

    public int find(int u) {
        if (u == parent[u])
            return u;
        return parent[u] = find(parent[u]);
    }

    public void union(int u, int v) {
        int pu = find(u);
        int pv = find(v);
        if (size[pu] > size[pv]) {
            parent[pv] = pu;
            size[pu] += size[pv];
        } else {
            parent[pu] = pv;
            size[pv] += size[pu];
        }
    }
}