// https://leetcode.com/problems/number-of-ways-to-reach-a-position-after-exactly-k-steps/solutions/2527267/top-down-bottom-up-dp/
//HINT : consider dist as it is always positive
//------------------------TABULATION
class Solution {
    final int MOD = (int) 1e9 + 7;

    public int numberOfWays(int startPos, int endPos, int K) {
        int dp[][] = new int[K + 1][1001];
        for (int k = 1; k <= K; ++k) {
            dp[k][k] = 1;
            for (int i = 0; i < k; ++i)
                dp[k][i] = (dp[k - 1][Math.abs(i - 1)] + dp[k - 1][i + 1]) % MOD;
        }
        return dp[K][Math.abs(startPos - endPos)];
    }
}
// Time complexity : O(1000* k)