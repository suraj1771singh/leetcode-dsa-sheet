//---------------ANOTHER DP SOLUTION ( TABULATION )
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int dp[] = new int[n + 1];
        int ndays[] = new int[] { 0, 6, 29 };

        for (int i = n - 1; i >= 0; i--) {
            int cost = (int) 1e9;
            for (int j = 0; j < 3; j++) {
                int ni = getNextPos(i, days[i] + ndays[j], days);
                cost = Math.min(cost, costs[j] + dp[ni]);
            }
            dp[i] = cost;
        }
        return dp[0];
    }

    // O(30) constant
    int getNextPos(int ind, int n_day, int[] days) {
        while (ind < days.length && days[ind] <= n_day)
            ind++;
        return ind;
    }
}
// Time complexity : O(n)
// Space complexity : O(n)