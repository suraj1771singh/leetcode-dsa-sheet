//-----------------USING BINARY SEARCH
class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        double l = 0, r = 1;
        int ans[] = new int[2];
        while (l < r) {
            int cnt = 0, j = 0;
            double mid = (l + r) / 2.0;
            double maxF = 0;
            for (int i = 0; i < n; i++) {
                while (j < n && ((double) arr[i]) / arr[j] > mid)
                    j++;
                if (j == n)
                    break;
                cnt += n - j;
                if (((double) arr[i]) / arr[j] > maxF) {
                    ans[0] = arr[i];
                    ans[1] = arr[j];
                    maxF = ((double) arr[i]) / arr[j];
                }
            }
            if (cnt == k) return ans;
            else if (cnt < k) l = mid;
            else r = mid;
        }
        return ans;
    }
}
// Time complexity : O(n*c) where c is the number of iteration (depends on
// decimal precision between 0 and 1)
