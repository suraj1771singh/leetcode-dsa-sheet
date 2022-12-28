import java.util.*;

//-----------------USING MONOTONIC STACK

class Solution2 {
    public int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && stack.peek() > nums[i] && nums.length - i + stack.size() > k)
                stack.pop();
            if (stack.size() < k)
                stack.add(nums[i]);

        }
        int ans[] = new int[k];
        int cnt = k;
        while (!stack.isEmpty()) {
            ans[--cnt] = stack.pop();
        }
        return ans;
    }
}
// Time complexity : O(n)