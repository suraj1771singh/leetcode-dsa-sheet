//find maximum distance you can cover after taking exactly k stops, if can't take k stops return -1
// (Not working)
class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int n = stations.length;
        Integer dp[][] = new Integer[n][n];

        return f(n, 0, startFuel, stations, dp);
    }

    int f(int k, int ind, int startFuel, int[][] stations, Integer[][] dp) {
        if (k <= 0)
            return startFuel;
        if (ind >= stations.length)
            return -(int) 1e9;
        if (dp[ind][k] != null)
            return dp[ind][k];

        int p = stations[ind][1] + f(ind + 1, k - 1, startFuel, stations, dp);
        int np = f(ind + 1, k, startFuel, stations, dp);
        return dp[ind][k] = Math.max(p, np);
    }
}