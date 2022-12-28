import java.util.*;

class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> leftHeap = new PriorityQueue<>();
        PriorityQueue<Integer> rightHeap = new PriorityQueue<>();
        int n = costs.length;
        long ans = 0;
        for (int i = 0; i < candidates; i++)
            leftHeap.add(costs[i]);
        for (int i = Math.max(n - candidates, candidates); i < n; i++)
            rightHeap.add(costs[i]);

        int left = candidates, right = Math.max(n - candidates, candidates) - 1;
        while (k-- > 0) {
            // case 1 : if both left and right are non empty
            if (!leftHeap.isEmpty() && !rightHeap.isEmpty()) {
                if (leftHeap.peek() <= rightHeap.peek()) {
                    ans += leftHeap.poll();
                    if (left <= right)
                        leftHeap.add(costs[left++]);
                } else {
                    ans += rightHeap.poll();
                    if (left <= right)
                        rightHeap.add(costs[right--]);
                }
            }
            // case 2 : if left is empty
            else if (leftHeap.isEmpty()) {
                ans += rightHeap.poll();
            }
            // case 3 : if right is empty
            else if (rightHeap.isEmpty()) {
                ans += leftHeap.poll();
            }
        }
        return ans;

    }
}
// Time complexity : O(n*logn)