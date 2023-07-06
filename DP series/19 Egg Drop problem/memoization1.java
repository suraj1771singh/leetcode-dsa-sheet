class Solution {
    public int superEggDrop(int k, int n) {
        Integer dp[][] = new Integer[k + 1][n + 1];
        return f(k, n, dp);
    }

    int f(int k, int n, Integer dp[][]) {
        if (n <= 1)
            return n;
        if (k == 1)
            return n;
        if (dp[k][n] != null)
            return dp[k][n];
        int ans = (int) 1e9;
        for (int i = 1; i <= n; i++)
            ans = Math.min(ans, 1 + Math.max(f(k - 1, i - 1, dp), f(k, n - i, dp)));
        return dp[k][n] = ans;
    }
}
// Time complexity : O(K*N*N)