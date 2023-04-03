import java.util.*;
//HINT : https://www.youtube.com/watch?v=Wafu5vOxPRE

class Solution {
    int parent[];

    public int regionsBySlashes(String[] grid) {
        int m = grid.length + 1;
        int n = (m) * (m);
        parent = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = i;
        int cnt = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0 || i == m - 1 || j == m - 1) {
                    int cellno = i * m + j;
                    if (cellno == 0)
                        continue;
                    if (find(0) == find(cellno))
                        cnt++;
                    else
                        union(0, cellno);
                }
            }
        }
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < m - 1; j++) {
                if (grid[i].charAt(j) == '/') {
                    int cellno1 = i * m + j + 1;
                    int cellno2 = (i + 1) * m + j;
                    if (find(cellno1) == find(cellno2))
                        cnt++;
                    else
                        union(cellno1, cellno2);

                } else if (grid[i].charAt(j) == '\\') {
                    int cellno1 = i * m + j;
                    int cellno2 = (i + 1) * m + j + 1;
                    if (find(cellno1) == find(cellno2))
                        cnt++;
                    else
                        union(cellno1, cellno2);
                }
            }
        }
        return cnt;
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
// Time complexity : O(m^2)