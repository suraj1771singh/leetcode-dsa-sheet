//---------NAIVE APPROACH (DFS traversal)

class Solution1 {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length, m = grid[0].length, ans = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (grid[i][j] == 1)
                    ans = Math.max(ans, f(i, j, grid));
        return ans;
    }

    int f(int i, int j, int[][] grid) {
        grid[i][j] = 0;
        // all directions
        int up = isValid(i - 1, j, grid) ? f(i - 1, j, grid) : 0;
        int down = isValid(i + 1, j, grid) ? f(i + 1, j, grid) : 0;
        int left = isValid(i, j - 1, grid) ? f(i, j - 1, grid) : 0;
        int right = isValid(i, j + 1, grid) ? f(i, j + 1, grid) : 0;

        // grid[i][j] = 1;

        return 1 + up + down + left + right;
    }

    boolean isValid(int i, int j, int grid[][]) {
        int n = grid.length, m = grid[0].length;
        if (i >= 0 && i < n && j >= 0 && j < m && grid[i][j] == 1)
            return true;
        return false;
    }
}
// Time complexity : O(m*n)
