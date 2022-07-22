
//----ALGO
// keep last_ind pointer to point last index of array with distinct elements

class Solution1 {
    public int removeDuplicates(int[] nums) {
        int last_ind = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[last_ind] != nums[i]) {
                nums[++last_ind] = nums[i];
            }
        }
        return last_ind + 1;
    }
}
// Time complexity : O(n)
// Space complexity : O(1)