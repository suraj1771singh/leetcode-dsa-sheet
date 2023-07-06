class Solution {
    public int getMaxLen(int[] nums) {
        int n = nums.length;
        int prod = 1, ans = 0;
        int len = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                len = 0;
                prod = 1;
                continue;
            }
            prod = nums[i] < 0 ? prod * -1 : prod;
            len++;
            if (prod > 0)
                ans = Math.max(ans, len);
        }
        prod = 1;
        len = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] == 0) {
                len = 0;
                prod = 1;
                continue;
            }
            prod = nums[i] < 0 ? prod * -1 : prod;
            len++;
            if (prod > 0)
                ans = Math.max(ans, len);
        }
        return ans;
    }
}