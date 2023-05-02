//Hint : similar like https://leetcode.com/problems/best-sightseeing-pair/
// and Best Time to Buy and Sell Stock

class Solution {
    public long maxPoints(int[][] points) {
        int n = points.length, m = points[0].length;
        long res = 0;
        long dp[][] = new long[n][m];

        for (int i = 0; i < m; i++) {
            dp[0][i] = points[0][i];
            res = Math.max(res, dp[0][i]);
        }

        for (int r = 1; r < n; r++) {
            long lft_ar[] = new long[m];
            long rht_ar[] = new long[m];

            long maxi = -1;
            for (int c = 0; c < m; c++, maxi--) {
                maxi = Math.max(maxi, dp[r - 1][c]);
                lft_ar[c] = maxi;
            }
            maxi = -1;
            for (int c = m - 1; c >= 0; c--, maxi--) {
                maxi = Math.max(maxi, dp[r - 1][c]);
                rht_ar[c] = maxi;
            }

            for (int c = 0; c < m; c++) {
                dp[r][c] = points[r][c] + Math.max(lft_ar[c], rht_ar[c]);
                res = Math.max(res, dp[r][c]);
            }

        }
        return res;
    }
}
// Time complexity : O(n^2)