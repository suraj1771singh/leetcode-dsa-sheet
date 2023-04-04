//---------------------------TABULATION
class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0, n = stones.length;
        for (int i : stones)
            sum += i;
        boolean dp[][] = new boolean[n + 1][sum / 2 + 1];

        // base case 1
        for (int i = 0; i < n; i++)
            dp[i][0] = true;

        for (int s = sum / 2; s >= 0; s--) {
            for (int i = 1; i <= n; i++) {
                for (int j = 0; j <= s; j++) {
                    if (j - stones[i - 1] >= 0)
                        dp[i][j] = dp[i - 1][j - stones[i - 1]] || dp[i - 1][j];
                    else
                        dp[i][j] = dp[i - 1][j];
                }
            }
            if (dp[n][s])
                return sum - 2 * s;
        }
        return -1;
    }
}
// Time complexity : O(sum*sum*n)
// Space complexity : O(sum*n)