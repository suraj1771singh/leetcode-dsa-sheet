
//-----------------------MEMOIZATION

class Solution {
    int n, m;
    final int MOD = (int) 1e9 + 7;

    public int ways(String[] pizza, int k) {
        n = pizza.length;
        m = pizza[0].length();
        int[][] presum = new int[n + 1][m + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--)
                presum[i][j] = presum[i + 1][j] + presum[i][j + 1] - presum[i + 1][j + 1]
                        + (pizza[i].charAt(j) == 'A' ? 1 : 0);
        }

        Integer dp[][][] = new Integer[n + 1][m + 1][k + 1];
        return f(0, 0, k - 1, presum, dp);

    }

    private int f(int r, int c, int k, int[][] presum, Integer dp[][][]) {
        if (presum[r][c] == 0)
            return 0;
        if (k == 0)
            return 1;
        if (dp[r][c][k] != null)
            return dp[r][c][k];
        int ans = 0;
        // cut horizontally
        for (int nr = r + 1; nr < n; nr++) {
            if (presum[r][c] - presum[nr][c] > 0) {
                ans = (ans + f(nr, c, k - 1, presum, dp)) % MOD;
            }
        }
        // cut vertically
        for (int nc = c + 1; nc < m; nc++) {
            if (presum[r][c] - presum[r][nc] > 0) {
                ans = (ans + f(r, nc, k - 1, presum, dp)) % MOD;
            }
        }
        return dp[r][c][k] = ans;
    }

}
// Time complexity : O(n*m*k*(m+n)) = O(n^4)