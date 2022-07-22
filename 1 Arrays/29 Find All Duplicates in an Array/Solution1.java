import java.util.*;

// Efficient Approach

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int ind = Math.abs(nums[i]) - 1;

            // if that pos is already marked as -ve
            // this means there already exist num[i]
            if (nums[ind] < 0)
                ans.add(ind + 1);
            // marked its position
            else
                nums[ind] *= -1;
        }
        return ans;

    }
}
// Time complexity : O(n)
// Space complexity : O(1)