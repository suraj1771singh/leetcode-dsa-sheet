//---------------OPTMIZED VERSION (Prefix sum)

class Solution {
    public int minimizeArrayValue(int[] nums) {
        int l = 0, h = 0;
        for (int i : nums)
            h = Math.max(h, i);
        int ans = h;
        while (l <= h) {
            int mid = (l + h) / 2;
            if (isValid(mid, nums)) {
                ans = mid;
                h = mid - 1;
            } else
                l = mid + 1;
        }
        return ans;
    }

    private boolean isValid(int x, int[] nums) {
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > (i + 1) * 1L * x)
                return false;

        }
        return true;
    }
}
// Time complexity : O(n*logn)