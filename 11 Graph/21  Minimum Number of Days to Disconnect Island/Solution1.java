import java.util.*;

//-------------BRIDGE PROBLEM
//---ALGO
/*
if already disconnected return 0
if bridge found return 1;
else return 2; (for disconnected corner 1's, )
*/

class Solution {
    int low[][];
    int tin[][];
    int timer = 0;
    List<String> bridges;
    int[][] dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };
    int cnt_ones = 0;

    public int minDays(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        low = new int[m][n];
        tin = new int[m][n];
        bridges = new ArrayList<>();

        boolean flag = false;

        boolean seen[][] = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !seen[i][j]) {
                    // comming second time, means disconnected graph
                    if (flag)
                        return 0;
                    flag = true;
                    dfs(i, j, -1, -1, seen, grid);
                }
            }
        }
        if (cnt_ones <= 2)
            return cnt_ones;
        if (bridges.size() > 0)
            return 1;
        return 2;
    }

    void dfs(int i, int j, int p_x, int p_y, boolean seen[][], int grid[][]) {
        seen[i][j] = true;
        cnt_ones++;
        low[i][j] = tin[i][j] = timer++;
        int m = grid.length, n = grid[0].length;
        for (int dir[] : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x == p_x && y == p_y)
                continue; // parent

            if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                if (!seen[x][y]) {

                    dfs(x, y, i, j, seen, grid);
                    low[i][j] = Math.min(low[i][j], low[x][y]);

                    // check for bridge
                    if (low[x][y] > tin[i][j])
                        bridges.add(i + " " + j);
                } else {
                    low[i][j] = Math.min(low[i][j], low[x][y]);
                }

            }
        }
    }
}
// Time complexity : O(m*n)