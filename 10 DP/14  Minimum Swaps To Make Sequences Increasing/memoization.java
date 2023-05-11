class Solution {
    public int minSwap(int[] nums1, int[] nums2) {
        Integer dp[][] = new Integer[nums1.length][2];
        return f(0, nums1, nums2, 0, dp);
    }

    int f(int ind, int nums1[], int nums2[], int isSwapped, Integer dp[][]) {
        if (ind >= nums1.length)
            return 0;
        if (dp[ind][isSwapped] != null)
            return dp[ind][isSwapped];
        int prev1 = ind - 1 < 0 ? -1 : isSwapped == 1 ? nums2[ind - 1] : nums1[ind - 1];
        int prev2 = ind - 1 < 0 ? -1 : isSwapped == 1 ? nums1[ind - 1] : nums2[ind - 1];

        int swap = (int) 1e9, noswap = (int) 1e9;
        // swap
        if (nums1[ind] > prev2 && nums2[ind] > prev1)
            swap = 1 + f(ind + 1, nums1, nums2, 1, dp);
        // noswap
        if (nums1[ind] > prev1 && nums2[ind] > prev2)
            noswap = f(ind + 1, nums1, nums2, 0, dp);

        return dp[ind][isSwapped] = Math.min(swap, noswap);
    }
}
// Time complexity : O(n)
// Space complexity : O(n)