
//-----EFFICIENT APPROACH

//-----ALGO
// memoize left sum and right sum 

class Solution2 {
    public int pivotIndex(int[] nums) {
        int ans = -1, n = nums.length;
        if (n == 1) // edge case
            return 0;

        int l_sum[] = new int[n];
        int r_sum[] = new int[n];

        l_sum[0] = nums[0];
        r_sum[n - 1] = nums[n - 1];

        for (int i = 1, j = n - 2; i < n && j >= 0; i++, j--) {
            l_sum[i] += nums[i] + l_sum[i - 1];
            r_sum[j] += nums[j] + r_sum[j + 1];
        }
        for (int i = 0; i < n; i++) {
            int left_sum = i > 0 ? l_sum[i - 1] : 0;
            int right_sum = i < n - 1 ? r_sum[i + 1] : 0;
            if (left_sum == right_sum)
                return i;
        }
        return ans;
    }
}

// Time complexity : O(n)
// Space complexity : O(n)