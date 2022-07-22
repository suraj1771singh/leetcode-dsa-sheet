
//-------NAIVE APPROACH
public class Solution1 {

    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target)
                    return new int[] { i, j };
            }
        }
        return new int[2];
    }
}

// Time complexity : O(n^2)
// Space complexity : O(1)