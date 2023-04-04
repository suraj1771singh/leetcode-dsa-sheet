//---------------ANOTHER DP SOLUTION ( MEMOZATION )
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        Integer dp[] = new Integer[n];
        return f(0, days, costs, dp);
    }

    int f(int ind, int days[], int[] costs, Integer[] dp) {

        if (ind >= days.length)
            return 0;
        if (dp[ind] != null)
            return dp[ind];
        // take 1 day pass
        int n_ind = getNextPos(ind, days[ind], days);
        int a = costs[0] + f(n_ind, days, costs, dp);
        // take 7 day pass
        n_ind = getNextPos(ind, days[ind] + 6, days);
        int b = costs[1] + f(n_ind, days, costs, dp);
        // take 30 day pass
        n_ind = getNextPos(ind, days[ind] + 29, days);
        int c = costs[2] + f(n_ind, days, costs, dp);

        return dp[ind] = Math.min(a, Math.min(b, c));
    }

    // O(30) constant
    int getNextPos(int ind, int n_day, int[] days) {
        while (ind < days.length && days[ind] <= n_day)
            ind++;
        return ind;
    }
}
// Time complexity : O(n)