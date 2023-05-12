/*
 * Here we are doing tabulation little bit different from memoization
 * for reference see below video-----
 * dp[i][j] = denotes paiting ith house with jth color, all houses before ith house are painted optimaly
 * https://www.youtube.com/watch?v=jGywRalvoRw
 */

class Solution {
    public static int paintCost(int n, int k, int[][] costs) {
        int dp[][] = new int[n][k];
        for (int j = 0; j < k; j++)
            dp[0][j] = costs[0][j];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < k; j++) {
                int min = (int) 1e9;
                // get min from above row
                for (int t = 0; t < k; t++)
                    min = t != j ? Math.min(min, dp[i - 1][t]) : min;
                // cost = cost[i][j] + min till i-1 house;
                dp[i][j] = costs[i][j] + min;
            }
        }
        // ans would be min cost from last house row
        int ans = (int) 1e9;
        for (int j = 0; j < k; j++)
            ans = Math.min(ans, dp[n - 1][j]);
        return ans;
    }
}
// Time complexity : O(n^3)