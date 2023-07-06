import java.util.*;

class Solution {

    public int minDays(int n) {
        Map<Integer, Integer> dp = new HashMap<>();

        return f(n, dp);
    }

    int f(int n, Map<Integer, Integer> dp) {
        if (n <= 1)
            return 1;
        if (dp.containsKey(n))
            return dp.get(n);
        int a = 1 + n % 3 + f(n / 3, dp);
        int b = 1 + n % 2 + f(n / 2, dp);
        int ans = Math.min(a, b);
        dp.put(n, ans);
        return ans;
    }
}