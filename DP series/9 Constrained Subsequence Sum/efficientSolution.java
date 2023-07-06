import java.util.PriorityQueue;

//--------USING MAX HEAP FOR KEEP TRACKING IF MAXIMUM BETWEEN RANGE i+1, i+k
///HINT : https://leetcode.com/problems/constrained-subsequence-sum/solutions/1402185/c-4-ways-tle-tle-accepted-accepted/

class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        int ans = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        ans = nums[0];
        pq.add(new int[] { ans, 0 });
        for (int i = 1; i < nums.length; i++) {
            while (!pq.isEmpty() && pq.peek()[1] < i - k)
                pq.poll();
            int max = Math.max(nums[i], nums[i] + pq.peek()[0]);
            pq.add(new int[] { max, i });
            ans = Math.max(ans, max);
        }
        return ans;

    }
}
// Time complexity : O(n*logn)