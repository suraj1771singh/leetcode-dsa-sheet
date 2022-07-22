class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length, l = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                // swap(i, l)
                int temp = nums[i];
                nums[i] = nums[l];
                nums[l] = temp;
                l++;
            }
        }
    }

}
// Time complexity : O(n)
// Space complexity : O(1)