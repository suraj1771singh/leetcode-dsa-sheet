import java.util.*;

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < n; i++) {
            pq.add(new int[] { matrix[0][i], 0, i });
        }
        int ans = 0;
        while (k-- > 0 && !pq.isEmpty()) {
            int num[] = pq.poll();
            ans = num[0];
            int next_x = num[1] + 1;
            int next_y = num[2];
            if (next_x >= n)
                continue;
            pq.add(new int[] { matrix[next_x][next_y], next_x, next_y });
        }

        return ans;
    }
}
// Time complexity : O(n*logn)+O(k*logn)