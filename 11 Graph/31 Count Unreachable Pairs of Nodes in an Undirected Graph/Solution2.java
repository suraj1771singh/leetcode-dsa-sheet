import java.util.*;

class Solution {
    int[][] dirs = { { 0, -1 }, { 1, 0 }, { -1, 0 }, { 0, 1 } };

    public int[][] findFarmland(int[][] land) {
        int m = land.length, n = land[0].length;
        boolean seen[][] = new boolean[m][n];
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!seen[i][j] && land[i][j] == 1) {
                    int a[] = new int[] { i, j, i, j };
                    dfs(i, j, i + j, land, seen, a);
                    list.add(a);
                }
            }
        }
        int res[][] = new int[list.size()][4];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;

    }

    void dfs(int i, int j, int max, int[][] land, boolean seen[][], int[] a) {
        int m = land.length, n = land[0].length;
        if (i + j > max) {
            max = i + j;
            a[2] = i;
            a[3] = j;
        }
        seen[i][j] = true;
        for (int dir[] : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x >= 0 && x < m && y >= 0 && y < n && !seen[x][y] && land[x][y] == 1)
                dfs(x, y, max, land, seen, a);
        }
    }
}