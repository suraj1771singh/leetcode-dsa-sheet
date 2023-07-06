//HINT : Take two agents, both move from 0 0 to n-1 n-1
// and if their coordinate is same then pick only one cherry

class Solution {
    int n;
    int m;
    int dirs[][] = { { 0, 1 }, { 1, 0 } };

    public int cherryPickup(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        Integer dp[][][][] = new Integer[n][m][n][m];
        int ans = f(0, 0, 0, 0, grid, dp);
        return ans < 0 ? 0 : ans;
    }

    int f(int r1, int c1, int r2, int c2, int[][] grid, Integer dp[][][][]) {
        if (r1 >= n || c1 >= m || r2 >= n || c2 >= m || grid[r1][c1] == -1 || grid[r2][c2] == -1)
            return -(int) 1e9;
        if (r1 == n - 1 && c1 == n - 1)
            return grid[r1][c1];

        if (dp[r1][c1][r2][c1] != null)
            return dp[r1][c1][r2][c1];

        int cherry_cnt = 0;
        if (r1 == r2 && c1 == c2)
            cherry_cnt = grid[r1][c1];
        else
            cherry_cnt = grid[r1][c1] + grid[r2][c2];

        int next_cherry = -(int) 1e9;
        for (int dir1[] : dirs) {
            for (int dir2[] : dirs) {
                int nr1 = dir1[0] + r1;
                int nc1 = dir1[1] + c1;
                int nr2 = dir2[0] + r2;
                int nc2 = dir2[1] + c2;
                next_cherry = Math.max(next_cherry, f(nr1, nc1, nr2, nc2, grid, dp));
            }
        }
        cherry_cnt += next_cherry;
        return dp[r1][c1][r2][c1] = cherry_cnt;
    }
}

// Time complexity : O(n*m*n*m);