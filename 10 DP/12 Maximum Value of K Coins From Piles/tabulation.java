import java.util.*;

//-------------------------TABULATION
class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int K) {
        int n = piles.size();
        int dp[][] = new int[n + 1][K + 1];

        for (int ind = 1; ind <= n; ind++) {
            for (int k = 0; k <= K; k++) {
                int sum = 0;
                dp[ind][k] = dp[ind - 1][k];
                for (int i = 0; i < Math.min(piles.get(ind - 1).size(), k); i++) {
                    sum += piles.get(ind - 1).get(i);
                    dp[ind][k] = Math.max(dp[ind][k], sum + dp[ind - 1][k - i - 1]);
                }
            }
        }
        return dp[n][K];
    }
}
// Time compelxity : O(n*avg(len(pile))*k);