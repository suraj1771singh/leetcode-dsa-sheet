import java.util.*;

class Solution {
    public long countFairPairs(int[] a, int lower, int upper) {
        Arrays.sort(a);
        int n = a.length;
        int h = n - 1;
        int l = n - 1;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            while (h > i && a[i] + a[h] > upper)
                h--;
            while (l > i && a[i] + a[l] >= lower)
                l--;
            if (h <= i)
                return ans;
            ans += h - Math.max(l, i);
        }
        return ans;
    }
}