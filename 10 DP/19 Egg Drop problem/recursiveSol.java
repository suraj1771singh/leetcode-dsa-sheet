class Solution {
    public int superEggDrop(int k, int n) {
        return f(k, n);
    }

    int f(int k, int n) {
        if (n <= 1)
            return n;
        if (k == 1)
            return n;
        int ans = (int) 1e9;
        for (int i = 1; i <= n; i++)
            ans = Math.min(ans, 1 + Math.max(f(k - 1, i - 1), f(k, n - i)));
        return ans;
    }
}