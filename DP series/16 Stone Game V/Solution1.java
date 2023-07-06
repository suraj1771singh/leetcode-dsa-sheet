class Solution {
    int[] prefix;

    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        prefix = new int[n];
        prefix[0] = stoneValue[0];
        Integer dp[][] = new Integer[n][n];
        for (int i = 1; i < n; i++)
            prefix[i] = prefix[i - 1] + stoneValue[i];
        return f(0, n - 1, stoneValue, dp);

    }

    int f(int left, int right, int[] stoneValue, Integer dp[][]) {
        if (right - left <= 0)
            return 0;
        if (dp[left][right] != null)
            return dp[left][right];

        int res = -(int) 1e9;
        for (int i = left; i < right; i++) {

            int leftsum = left - 1 < 0 ? prefix[i] : prefix[i] - prefix[left - 1];
            int rightsum = prefix[right] - prefix[i];

            if (leftsum == rightsum) {
                res = Math.max(res, leftsum + f(left, i, stoneValue, dp));
                res = Math.max(res, leftsum + f(i + 1, right, stoneValue, dp));
            } else if (leftsum > rightsum)
                res = Math.max(res, rightsum + f(i + 1, right, stoneValue, dp));
            else
                res = Math.max(res, leftsum + f(left, i, stoneValue, dp));

        }
        return dp[left][right] = res;
    }
}
/// Time complexity : O(n^3)