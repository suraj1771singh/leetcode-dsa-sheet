// https://leetcode.com/problems/number-of-ways-to-reach-a-position-after-exactly-k-steps/solutions/2527267/top-down-bottom-up-dp/

//HINT : consider dist as it is always positive
//----------------------------MEMOIZATION
class Solution {
    final int MOD = (int) 1e9 + 7;

    public int numberOfWays(int startPos, int endPos, int k) {
        Integer dp[][] = new Integer[1001][k + 1];
        return f(Math.abs(startPos - endPos), k, dp);

    }

    int f(int dist, int k, Integer[][] dp) {
        if (dist >= k)
            return dist == k ? 1 : 0;

        if (dp[dist][k] != null)
            return dp[dist][k];
        return dp[dist][k] = (f(dist + 1, k - 1, dp) + f(Math.abs(dist - 1), k - 1, dp)) % MOD;
    }
}