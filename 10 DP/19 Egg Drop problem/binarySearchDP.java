//Instead of searching linearly we can use binary search 

class Solution {
    public int superEggDrop(int k, int n) {
        Integer dp[][] = new Integer[k + 1][n + 1];
        return f(k, n, dp);
    }

    int f(int k, int n, Integer dp[][]) {
        if (n <= 1)
            return n;
        if (k == 1)
            return n;
        if (dp[k][n] != null)
            return dp[k][n];
        int ans = (int) 1e9;
        int l = 1, h = n, temp = 0;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            int broken = f(k - 1, mid - 1, dp);
            int notbroken = f(k, n - mid, dp);
            temp = 1 + Math.max(broken, notbroken);
            if (broken > notbroken)
                h = mid - 1;
            else
                l = mid + 1;
            ans = Math.min(ans, temp);
        }
        return dp[k][n] = ans;
    }
}
// Time complexity : O(K*N*log N)