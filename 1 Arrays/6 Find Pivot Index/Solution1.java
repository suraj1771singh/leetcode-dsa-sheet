
//-----NAIVE APPROACH

class Solution1 {
    public int pivotIndex(int[] nums) {
        int ans = -1, n = nums.length;
        for (int i = 0; i < n; i++) {
            // left sum
            int l_sum = 0, l = i - 1;
            while (l >= 0)
                l_sum += nums[l--];

            // right sum;
            int r_sum = 0, r = i + 1;
            while (r < n)
                r_sum += nums[r++];

            if (l_sum == r_sum)
                return i;

        }
        return ans;
    }
}

// Time complexity : O(n^2)
// Space complexity : O(1)