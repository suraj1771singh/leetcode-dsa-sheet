//----------------------TABULATION

class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int dp[][] = new int[n + 1][400];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 399; j >= 0; j--) {
                int a = (int) 1e9;
                if (j >= days[i])
                    a = dp[i + 1][j];
                int b = costs[0] + dp[i + 1][Math.max(j, days[i])];
                int c = costs[1] + dp[i + 1][Math.max(j, days[i] + 6)];
                int d = costs[2] + dp[i + 1][Math.max(j, days[i] + 29)];
                dp[i][j] = Math.min(a, Math.min(b, Math.min(c, d)));
            }
        }
        return dp[0][0];
    }
}
// Time complexity : O(n)
// Space complexity : O(n)