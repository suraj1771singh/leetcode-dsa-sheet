import java.util.*;

//-------------------------MEMOIZATION
class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int n = piles.size();
        Integer dp[][] = new Integer[n][k + 1];
        return f(n - 1, k, piles, dp);
    }

    int f(int ind, int k, List<List<Integer>> piles, Integer dp[][]) {
        if (ind < 0)
            return k == 0 ? 0 : -(int) 1e9;
        if (dp[ind][k] != null)
            return dp[ind][k];
        int res = f(ind - 1, k, piles, dp); // not pick
        int sum = 0;
        for (int i = 0; i < Math.min(piles.get(ind).size(), k); i++) {
            sum += piles.get(ind).get(i);
            res = Math.max(res, sum + f(ind - 1, k - i - 1, piles, dp));
        }
        return dp[ind][k] = res;
    }
}
// Time compelxity : O(n*avg(len(pile))*k);