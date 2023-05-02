
//------------APPROACH 1 (MEMOIZATION TLE)

class Solution {
    public long maxPoints(int[][] points) {
        int n = points.length;
        int m = points[0].length;
        Long dp[][] = new Long[n + 1][m + 1];
        return f(n - 1, -1, points, dp);

    }

    long f(int r, int c, int[][] points, Long dp[][]) {
        if (r < 0)
            return 0;
        if (dp[r][c] != null)
            return dp[r][c];
        long max = -(int) 1e9;
        for (int i = 0; i < points[0].length; i++) {
            max = Math.max(max, points[r][i] + f(r - 1, i, points) - (c == -1 ? 0 : Math.abs(i - c)));
        }
        return dp[r][c] = max;
    }
}
// Time complexity : O(m*n*n)