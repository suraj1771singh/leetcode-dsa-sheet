import java.util.*;

class Solution {
    int parent_a[];
    int parent_b[];

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        parent_a = new int[n + 1];
        parent_b = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent_a[i] = i;
            parent_b[i] = i;
        }
        Arrays.sort(edges, (a, b) -> b[0] - a[0]);
        int cnt = 0;

        for (int edge[] : edges) {
            if (edge[0] == 3) {
                if (find_a(edge[1]) == find_a(edge[2]))
                    cnt++;
                else {
                    union_a(edge[1], edge[2]);
                    union_b(edge[1], edge[2]);
                }
            } else if (edge[0] == 1) {
                if (find_a(edge[1]) == find_a(edge[2]))
                    cnt++;
                else
                    union_a(edge[1], edge[2]);
            } else {
                if (find_b(edge[1]) == find_b(edge[2]))
                    cnt++;
                else
                    union_b(edge[1], edge[2]);
            }
        }
        // if found more than one compoenent return -1
        int a = 0, b = 0;
        for (int i = 1; i <= n; i++) {
            if (parent_a[i] == i) {
                a++;
                if (a > 1)
                    return -1;
            }
            if (parent_b[i] == i) {
                b++;
                if (b > 1)
                    return -1;
            }

        }
        return cnt;
    }

    int find_a(int x) {
        if (parent_a[x] == x)
            return x;
        return parent_a[x] = find_a(parent_a[x]);
    }

    void union_a(int x, int y) {
        int p1 = find_a(x);
        int p2 = find_a(y);
        if (p1 == p2)
            return;
        parent_a[p2] = p1;
    }

    int find_b(int x) {
        if (parent_b[x] == x)
            return x;
        return parent_b[x] = find_b(parent_b[x]);
    }

    void union_b(int x, int y) {
        int p1 = find_b(x);
        int p2 = find_b(y);
        if (p1 == p2)
            return;
        parent_b[p2] = p1;
    }
}
// Time complexit : O(E*log E)