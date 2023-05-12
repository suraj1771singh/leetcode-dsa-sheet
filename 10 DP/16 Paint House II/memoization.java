//----codestudio

class Solution {
    public static int paintCost(int n, int k, int[][] costs) {
        Integer dp[][] = new Integer[n][k + 1];
        return f(n - 1, 0, k, costs, dp);
    }

    public static int f(int ind, int preCol, int k, int[][] costs, Integer dp[][]) {
        if (ind < 0)
            return 0;
        if (dp[ind][preCol] != null)
            return dp[ind][preCol];
        int ans = (int) 1e9;
        for (int col = 1; col <= k; col++) {
            if (col != preCol) {
                ans = Math.min(ans, costs[ind][col - 1] + f(ind - 1, col, k, costs, dp));
            }
        }
        return dp[ind][preCol] = ans;
    }
}
// Time complexity : O(n*k*k) = O(n^3)