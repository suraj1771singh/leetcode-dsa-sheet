//hint : https://www.youtube.com/watch?v=I-z-u0zfQtg&ab_channel=NeetCodeIO
//---------------------MEMOIZATION

class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        Integer dp[][][] = new Integer[n + 1][2][n + 1];
        return f(0, 1, 1, piles, dp);
    }

    // we are always returning alice score
    int f(int ind, int alice, int m, int[] piles, Integer dp[][][]) {
        if (ind >= piles.length)
            return 0;

        if (dp[ind][alice][m] != null)
            return dp[ind][alice][m];

        int ttl = 0;
        int res = alice == 1 ? 0 : (int) 1e9;
        for (int i = 1; i <= 2 * m; i++) {
            if (ind + i - 1 >= piles.length)
                break;
            ttl += piles[ind + i - 1];

            if (alice == 1) {
                // alice turn, it would try to maximize the score
                res = Math.max(res, ttl + f(ind + i, 0, Math.max(m, i), piles, dp));

            } else {
                // bobs turn, it would try to minimize the score
                res = Math.min(res, f(ind + i, 1, Math.max(m, i), piles, dp));
            }
        }
        return dp[ind][alice][m] = res;
    }
}
// Time complexity : O(2*n^2)