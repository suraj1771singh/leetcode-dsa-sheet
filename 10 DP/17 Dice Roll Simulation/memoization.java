//---------------------------MEMOIZATION
class Solution {
    final int MOD = (int) 1e9 + 7;;

    public int dieSimulator(int n, int[] rollMax) {
        Integer dp[][][] = new Integer[n + 1][6][16];
        int ans = 0;
        for (int i = 0; i < 6; i++)
            ans = (ans + f(n - 1, i, rollMax[i] - 1, rollMax, dp)) % MOD;
        return ans;

    }

    int f(int k, int prev, int freq, int[] rollMax, Integer dp[][][]) {
        if (k <= 0)
            return 1;
        if (dp[k][prev][freq] != null)
            return dp[k][prev][freq];
        int ans = 0;
        for (int i = 0; i < 6; i++) {
            if (i == prev && freq <= 0)
                continue;

            if (i == prev)
                ans = (ans + f(k - 1, i, freq - 1, rollMax, dp)) % MOD;
            else
                ans = (ans + f(k - 1, i, rollMax[i] - 1, rollMax, dp)) % MOD;

        }
        return dp[k][prev][freq] = ans;

    }
}
// Time complexity : O(6*6*16*n)