import java.util.*;

//------------------------------USING DEQUEUE

class Solution2 {
    public int[] maxSlidingWindow(int[] a, int k) {
        int n = a.length;
        int[] ans = new int[n - k + 1];
        int ri = 0;
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < a.length; i++) {
            // remove number out of range
            if (!q.isEmpty() && q.peek() == i - k)
                q.poll();
            // remove smaller number in k ranges as they are useless
            while (!q.isEmpty() && a[q.peekLast()] < a[i])
                q.pollLast();
            q.offer(i);
            if (i >= k - 1)
                ans[ri++] = a[q.peek()];
        }
        return ans;
    }
}
// Time complexity : O(n)
// Space complexity : O(k)
