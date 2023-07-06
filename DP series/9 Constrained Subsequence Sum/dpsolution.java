//----DP MEMOIZATION 
// giving TLE 
class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        int n = nums.length;
        Integer dp[] = new Integer[n + 1];
        int ans = f(-1, k, nums, dp);

        if (ans == 0) {
            // if none is selected, then get max
            int max = -(int) 1e9;
            for (int i : nums)
                max = Math.max(max, i);
            ans = max;
        }
        return ans;
    }

    int f(int ind, int k, int a[], Integer dp[]) {
        if (dp[ind + 1] != null)
            return dp[ind + 1];
        int n = a.length;
        int sum = ind < 0 ? 0 : a[ind];
        int res = 0;
        if (ind == -1)
            for (int i = 0; i < n; i++)
                res = Math.max(res, f(i, k, a, dp));
        else
            for (int i = ind + 1; i <= Math.min(ind + k, n - 1); i++)
                res = Math.max(res, f(i, k, a, dp));

        return dp[ind + 1] = sum + res;
    }
}
// Time complexity : O(n^2)