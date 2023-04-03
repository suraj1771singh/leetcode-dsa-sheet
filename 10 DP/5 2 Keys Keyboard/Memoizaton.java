//-------------MEMOIZATION SOLUTION

class Solution {
    public int minSteps(int n) {
        Integer dp[][] = new Integer[n + 1][n + 1];
        return f(0, 1, n, dp);
    }

    int f(int ps, int cs, int n, Integer dp[][]) {
        int p = (int) 1e9, np = (int) 1e9;
        if (dp[ps][cs] != null)
            return dp[ps][cs];
        if (cs == n)
            return 0;
        if (ps != cs)
            p = 1 + f(cs, cs, n, dp); // copy
        if (ps != 0 && ps + cs <= n)
            np = 1 + f(ps, cs + ps, n, dp); // paste

        return dp[ps][cs] = Math.min(p, np);
    }
}
// Time complexity : O(n^2)
// Space complexity : O(n^2)