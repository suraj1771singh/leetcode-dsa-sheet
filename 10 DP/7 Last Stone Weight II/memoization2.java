//--------------------------ANOTHER DP SOLUTION (MEMOIZATION) --more efficient
//the whole idea is to make two different set, and minimize sum(set1)- sum(set2)

class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0, n = stones.length;
        for (int i : stones)
            sum += i;

        // so idea to get subset sum close to sum/2 so that both subset cancel each
        // other;
        Boolean dp[][] = new Boolean[n][(sum / 2) + 1];
        for (int i = sum / 2; i >= 0; i--) {
            if (isPossible(i, n - 1, stones, dp))
                return sum - 2 * i;
        }
        return 0;
    }

    boolean isPossible(int target, int ind, int[] stones, Boolean[][] dp) {
        if (ind < 0)
            return target == 0 ? true : false;
        if (dp[ind][target] != null)
            return dp[ind][target];
        boolean p = false;
        if (target - stones[ind] >= 0)
            p = isPossible(target - stones[ind], ind - 1, stones, dp);
        boolean np = isPossible(target, ind - 1, stones, dp);
        return dp[ind][target] = p || np;
    }
}
// Time complexity : O(n*sum^2)