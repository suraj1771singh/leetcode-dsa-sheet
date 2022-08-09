import java.util.*;

//------ALGO
/*
 *1) Just copy the array to the end of exiting array, and make monotonic stack
 */
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<Integer>();
        int ans[] = new int[nums.length];
        Arrays.fill(ans, -1);
        int n = nums.length;
        for (int i = 0; i < 2 * n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n])
                ans[stack.pop()] = nums[i % n];
            if (i < n)
                stack.push(i);
        }
        return ans;
    }
}
// Time complexity: O(n)
// Space complexity : O(n)