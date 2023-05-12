/*
 we can optmize the way we are find min from above row, this can be done in O(1).
 The idea is to find first min and second min for a row
 */

class Solution {
    public static int paintCost(int n, int k, int[][] costs) {
        int dp[][] = new int[n][k];
        int firstmin = (int) 1e9, secondmin = (int) 1e9;
        for (int j = 0; j < k; j++) {
            dp[0][j] = costs[0][j];
            if (dp[0][j] <= firstmin) {
                secondmin = firstmin;
                firstmin = dp[0][j];
            } else if (dp[0][j] < secondmin)
                secondmin = dp[0][j];
        }
        for (int i = 1; i < n; i++) {
            int n_firstmin = (int) 1e9, n_secondmin = (int) 1e9;
            for (int j = 0; j < k; j++) {

                if (firstmin == dp[i - 1][j])
                    dp[i][j] = costs[i][j] + secondmin;
                else
                    dp[i][j] = costs[i][j] + firstmin;
                // calculating minimuns
                if (dp[i][j] <= n_firstmin) {
                    n_secondmin = n_firstmin;
                    n_firstmin = dp[i][j];
                } else if (dp[i][j] < n_secondmin)
                    n_secondmin = dp[i][j];

            }
            firstmin = n_firstmin;
            secondmin = n_secondmin;
        }
        // ans would be min cost from last house row
        return firstmin;
    }
}
// Time complexity : O(n^2)