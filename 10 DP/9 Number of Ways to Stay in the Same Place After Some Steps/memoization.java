//HINT : instead of taking currPos as state take distance between 0 and currPos as dp state
//       if dist>k means you cannot reach at 0 index with k steps

//-----------------------MEMOIZATION

class Solution {
    int r_max;
    final int MOD = (int) 1e9 + 7;

    public int numWays(int steps, int arrLen) {
        Integer dp[][] = new Integer[steps + 1][steps + 1];
        r_max = arrLen;
        return f(0, steps, dp);

    }

    int f(int d, int k, Integer dp[][]) {
        if (d < 0 || d >= r_max)
            return 0;
        if (d >= k)
            return d == k ? 1 : 0;
        if (dp[d][k] != null)
            return dp[d][k];

        int s = f(d, k - 1, dp);
        int l = f(d - 1, k - 1, dp);
        int r = f(d + 1, k - 1, dp);
        return dp[d][k] = ((s + l) % MOD + r) % MOD;
    }
}
// Time complexity : O(k^2)