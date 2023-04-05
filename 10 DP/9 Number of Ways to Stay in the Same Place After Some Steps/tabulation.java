//-------------------TABULATION
class Solution {
    final int MOD = (int) 1e9 + 7;
    int r_max;

    public int numWays(int steps, int arrLen) {
        r_max = Math.min(arrLen, steps / 2 + 1);
        int[][] dp = new int[steps + 1][r_max];
        dp[0][0] = 1;

        for (int k = 1; k <= steps; k++) {
            for (int d = 0; d < r_max; d++) {
                int s = 0, l = 0, r = 0;

                s = dp[k - 1][d];
                l = d < 1 ? 0 : dp[k - 1][d - 1];
                r = d >= r_max - 1 ? 0 : dp[k - 1][d + 1];

                dp[k][d] = ((s + l) % MOD + r) % MOD;
            }
        }
        return dp[steps][0];// d should be 0
    }
}

// Time complexity : O(k^2)
// Space complexity : O(k^2)