public class tabulation {

    // tabulation

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        return getmin(grid, m, n, dp);
    }

    public int getmin(int[][] grid, int row, int col, int[][] dp) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[0][0];
                } else {
                    int up = grid[i][j];
                    int left = grid[i][j];
                    if (i > 0)
                        up += dp[i - 1][j];
                    else
                        up += (int) Math.pow(10, 9);
                    if (j > 0)
                        left += dp[i][j - 1];
                    else
                        left += (int) Math.pow(10, 9);
                    dp[i][j] = Math.min(up, left);
                }
            }
        }

        return dp[row - 1][col - 1];
    }
}
// Time complexity : O(m*n)
// Space complexity : O(m*n)