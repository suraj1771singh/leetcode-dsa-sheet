//----------MEMOIZATION

class Solution {
    int dirs[][] = { { 1, 0 }, { 0, 1 } };
    int n;
    int m;

    public int numberOfPaths(int[][] grid, int k) {
        n = grid.length;
        m = grid[0].length;
        Integer dp[][][] = new Integer[n][m][k];
        return f(0, 0, 0, k, grid, dp);
    }

    int f(int i, int j, int sum, int k, int a[][], Integer dp[][][]) {
        if (i == n - 1 && j == m - 1)
            return (sum + a[i][j]) % k == 0 ? 1 : 0;

        if (dp[i][j][sum] != null)
            return dp[i][j][sum];
        int cnt = 0;
        for (int dir[] : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x < n && y < m) {
                cnt += f(x, y, (sum + a[i][j]) % k, k, a, dp);
            }
        }
        return dp[i][j][sum] = cnt;
    }
}
// Time complexity : O(n*m*k)