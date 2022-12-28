import java.util.*;

//MEMOIZATION  solution DP

public class Solution2 {
    public int maxValue(int[][] events, int k) {
        int n = events.length;
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int dp[][] = new int[n][k + 1];
        for (int r[] : dp)
            Arrays.fill(r, -1);
        return f(events, n, 0, k, dp);
    }

    public int f(int events[][], int n, int pos, int k, int[][] dp) {
        int i;

        if (pos >= n || k == 0)
            return 0;
        if (dp[pos][k] != -1)
            return dp[pos][k];
        // finding the next event which we can attend
        for (i = pos + 1; i < n; i++)
            if (events[i][0] > events[pos][1])
                break;

        return dp[pos][k] = Math.max(f(events, n, pos + 1, k, dp), events[pos][2] + f(events, n, i, k - 1, dp));
    }
}
// Time complexity : O(n*logn) + O(n*k)
// Space complexity : O(n*k)