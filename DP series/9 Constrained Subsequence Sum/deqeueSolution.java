import java.util.*;

//IDEA : Maintain monotonic decreasing queue(similar to sliding window maximum)

class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        int ans = nums[0];
        Deque<int[]> q = new ArrayDeque<>();
    
        for (int i = 0; i < nums.length; i++) {
            while (!q.isEmpty() && q.peekFirst()[1] < i - k)
                q.pollFirst();
            int max = nums[i];
            if (!q.isEmpty())
                max = Math.max(nums[i], q.peekFirst()[0] + nums[i]);
            // maintaine decreasing order
            while (!q.isEmpty() && max >= q.peekLast()[0])
                q.pollLast();
            q.add(new int[] { max, i });
            ans = Math.max(ans, max);
        }
        return ans;

    }
}
// Time complexity : O(2*n)