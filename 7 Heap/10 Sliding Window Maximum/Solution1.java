import java.util.*;

class Solution1 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new ArrayDeque<>();
        int ans[] = new int[nums.length - k + 1];
        int ind = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!q.isEmpty() && nums[q.getLast()] <= nums[i]) {
                q.removeLast();
            }
            q.addLast(i);
            // now remove from front
            if (k - i > 1)
                continue;

            while (q.getFirst() <= i - k) {
                q.removeFirst();
            }
            ans[ind++] = nums[q.peek()];

        }
        return ans;
    }
}