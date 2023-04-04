//-------------------MEMOIZATION

class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        Integer dp[][] = new Integer[n][400];
        return f(0, 0, days, costs, dp);
    }

    int f(int farthestDay, int ind, int[] days, int[] costs, Integer[][] dp) {

        if (ind >= days.length) {
            return 0;
        }
        if (dp[ind][farthestDay] != null)
            return dp[ind][farthestDay];
        int a = (int) 1e9;
        if (farthestDay >= days[ind])
            // don't take any pass
            a = f(farthestDay, ind + 1, days, costs, dp);
        // take 1 day pass
        int b = costs[0] + f(Math.max(farthestDay, days[ind]), ind + 1, days, costs, dp);
        // take 7 day pass
        int c = costs[1] + f(Math.max(farthestDay, days[ind] + 6), ind + 1, days, costs, dp);
        // take 30 day pass
        int d = costs[2] + f(Math.max(farthestDay, days[ind] + 29), ind + 1, days, costs, dp);

        return dp[ind][farthestDay] = Math.min(a, Math.min(b, Math.min(c, d)));
    }

}
// Time complexity : O(n)